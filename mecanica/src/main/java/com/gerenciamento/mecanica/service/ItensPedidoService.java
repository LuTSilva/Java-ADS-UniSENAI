package com.gerenciamento.mecanica.service;

import com.gerenciamento.mecanica.dto.ItensPedidoDto;
import com.gerenciamento.mecanica.model.ItensPedidoModel;
import com.gerenciamento.mecanica.model.PedidoModel;
import com.gerenciamento.mecanica.model.ProdutoModel;
import com.gerenciamento.mecanica.repository.ItensPedidoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ItensPedidoService {

    @Autowired
    private ItensPedidoRepository itensPedidoRepository;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private EstoqueService estoqueService;

    public ItensPedidoModel adicionarItemAoPedido(@Valid @RequestBody ItensPedidoDto dto, PedidoModel pedido) {
        Optional<ProdutoModel> produtoOpt = produtoService.findByCdProduto(dto.cdProduto());
        if (produtoOpt.isEmpty()) {
            throw new IllegalArgumentException("Produto não encontrado com código: " + dto.cdProduto());
        }

        ProdutoModel produto = produtoOpt.get();

        if (!estoqueService.validarEstoqueDisponivel(produto, dto.qtProduto())) {
            Integer quantidadeDisponivel = estoqueService.obterQuantidadeDisponivel(produto);
            throw new IllegalArgumentException(
                String.format("Estoque insuficiente para o produto %s. Disponível: %d, Solicitado: %d", 
                    produto.getNmProduto(), quantidadeDisponivel, dto.qtProduto())
            );
        }

        ItensPedidoModel item = new ItensPedidoModel();
        item.setQtProduto(dto.qtProduto());
        item.setVlUnitario(dto.vlUnitario());
        item.setVlSubtotal(dto.vlUnitario().multiply(BigDecimal.valueOf(dto.qtProduto())));
        item.setPedido(pedido);
        item.setProduto(produto);

        return itensPedidoRepository.save(item);
    }

    public boolean processarVenda(PedidoModel pedido) {
        List<ItensPedidoModel> itens = itensPedidoRepository.findByPedido(pedido);
        
        if (itens.isEmpty()) {
            return false; // Pedido sem itens
        }

        for (ItensPedidoModel item : itens) {
            if (!estoqueService.validarEstoqueDisponivel(item.getProduto(), item.getQtProduto())) {
                Integer quantidadeDisponivel = estoqueService.obterQuantidadeDisponivel(item.getProduto());
                throw new IllegalArgumentException(
                    String.format("Estoque insuficiente para o produto %s. Disponível: %d, Solicitado: %d", 
                        item.getProduto().getNmProduto(), quantidadeDisponivel, item.getQtProduto())
                );
            }
        }

        for (ItensPedidoModel item : itens) {
            boolean sucesso = estoqueService.atualizarEstoqueAposVenda(item.getProduto(), item.getQtProduto());
            if (!sucesso) {
                throw new RuntimeException("Erro ao atualizar estoque para o produto: " + item.getProduto().getNmProduto());
            }
        }

        return true;
    }

    public List<ItensPedidoModel> listarTodos() {
        return itensPedidoRepository.findAll();
    }

    public Optional<ItensPedidoModel> findByCdItensPedido(Integer cdItensPedido) {
        return itensPedidoRepository.findByCdItensPedido(cdItensPedido);
    }

    public List<ItensPedidoModel> findByPedido(PedidoModel pedido) {
        return itensPedidoRepository.findByPedido(pedido);
    }

    public void deletarItem(Integer cdItensPedido) {
        itensPedidoRepository.deleteByCdItensPedido(cdItensPedido);
    }
}
