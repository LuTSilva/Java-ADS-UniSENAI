package com.gerenciamento.mecanica.service;

import com.gerenciamento.mecanica.dto.AdicionarProdutoDto;
import com.gerenciamento.mecanica.dto.AdicionarServicoDto;
import com.gerenciamento.mecanica.model.ItensPedidoModel;
import com.gerenciamento.mecanica.model.PedidoModel;
import com.gerenciamento.mecanica.model.ProdutoModel;
import com.gerenciamento.mecanica.model.ServicoModel;
import com.gerenciamento.mecanica.repository.ItensPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private ServicoService servicoService;

    @Autowired
    private EstoqueService estoqueService;

    public ItensPedidoModel adicionarProduto(AdicionarProdutoDto dto, PedidoModel pedido) {
        ProdutoModel produto = produtoService.findByCdProduto(dto.cdProduto())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com código: " + dto.cdProduto()));

        if (!estoqueService.validarEstoqueDisponivel(produto, dto.qtProduto())) {
            Integer disponivel = estoqueService.obterQuantidadeDisponivel(produto);
            throw new IllegalArgumentException(String.format(
                    "Estoque insuficiente para %s. Disponível: %d, Solicitado: %d",
                    produto.getNmProduto(), disponivel, dto.qtProduto()));
        }

        BigDecimal vlUnitario = dto.vlUnitario() != null ? dto.vlUnitario() : produto.getVlProduto();
        BigDecimal subtotal = vlUnitario.multiply(BigDecimal.valueOf(dto.qtProduto()));

        ItensPedidoModel item = new ItensPedidoModel();
        item.setPedido(pedido);
        item.setProduto(produto);
        item.setQtProduto(dto.qtProduto());
        item.setVlUnitario(vlUnitario);
        item.setVlSubtotal(subtotal);

        return itensPedidoRepository.save(item);
    }

    public ItensPedidoModel adicionarServico(AdicionarServicoDto dto, PedidoModel pedido) {
        ServicoModel servico = servicoService.findByCdServico(dto.cdServico())
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado com código: " + dto.cdServico()));

        BigDecimal vlUnitario = dto.vlUnitario() != null ? dto.vlUnitario() : servico.getVlServico();

        ItensPedidoModel item = new ItensPedidoModel();
        item.setPedido(pedido);
        item.setServico(servico);
        item.setVlUnitario(vlUnitario);
        item.setVlSubtotal(vlUnitario);

        return itensPedidoRepository.save(item);
    }

    public boolean processarVenda(PedidoModel pedido) {
        List<ItensPedidoModel> itens = itensPedidoRepository.findByPedido(pedido);
        
        if (itens.isEmpty()) {
            return false; // Pedido sem itens
        }

        // Validar estoque apenas para produtos (identificados pela presença do campo produto)
        for (ItensPedidoModel item : itens) {
            if (item.getProduto() != null) {
                if (!estoqueService.validarEstoqueDisponivel(item.getProduto(), item.getQtProduto())) {
                    Integer quantidadeDisponivel = estoqueService.obterQuantidadeDisponivel(item.getProduto());
                    throw new IllegalArgumentException(
                        String.format("Estoque insuficiente para o produto %s. Disponível: %d, Solicitado: %d", 
                            item.getProduto().getNmProduto(), quantidadeDisponivel, item.getQtProduto())
                    );
                }
            }
        }

        // Atualizar estoque apenas para produtos (identificados pela presença do campo produto)
        for (ItensPedidoModel item : itens) {
            if (item.getProduto() != null) {
                boolean sucesso = estoqueService.atualizarEstoqueAposVenda(item.getProduto(), item.getQtProduto());
                if (!sucesso) {
                    throw new RuntimeException("Erro ao atualizar estoque para o produto: " + item.getProduto().getNmProduto());
                }
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
