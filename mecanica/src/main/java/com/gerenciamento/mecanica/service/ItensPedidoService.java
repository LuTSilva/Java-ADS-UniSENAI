package com.gerenciamento.mecanica.service;

import com.gerenciamento.mecanica.dto.ItensPedidoDto;
import com.gerenciamento.mecanica.model.ItensPedidoModel;
import com.gerenciamento.mecanica.model.PedidoModel;
import com.gerenciamento.mecanica.model.ProdutoModel;
import com.gerenciamento.mecanica.model.ServicoModel;
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
    private ServicoService servicoService;

    @Autowired
    private EstoqueService estoqueService;

    public ItensPedidoModel adicionarItemAoPedido(@Valid @RequestBody ItensPedidoDto dto, PedidoModel pedido) {
        ItensPedidoModel item = new ItensPedidoModel();
        /**
         * PedidoModel pedido = new PedidoModel();
         */
        item.setVlUnitario(dto.vlUnitario());
        item.setPedido(pedido);

        BigDecimal subtotal = BigDecimal.ZERO;

        // Processar produto se informado
        if (dto.cdProduto() != null) {
            if (dto.qtProduto() == null || dto.qtProduto() <= 0) {
                throw new IllegalArgumentException("Quantidade do produto é obrigatória e deve ser maior que zero");
            }

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

            item.setQtProduto(dto.qtProduto());
            item.setProduto(produto);
            subtotal = subtotal.add(dto.vlUnitario().multiply(BigDecimal.valueOf(dto.qtProduto())));
        }

        // Processar serviço se informado
        if (dto.cdServico() != null) {
            Optional<ServicoModel> servicoOpt = servicoService.findByCdServico(dto.cdServico());
            if (servicoOpt.isEmpty()) {
                throw new IllegalArgumentException("Serviço não encontrado com código: " + dto.cdServico());
            }

            ServicoModel servico = servicoOpt.get();
            item.setServico(servico);
            subtotal = subtotal.add(dto.vlUnitario());
        }

        // Validar se pelo menos um foi informado
        if (dto.cdProduto() == null && dto.cdServico() == null) {
            throw new IllegalArgumentException("Informe o código do produto e/ou o código do serviço");
        }

        item.setVlSubtotal(subtotal);
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

    public ItensPedidoModel atualizarItem(ItensPedidoModel item) {
        return itensPedidoRepository.save(item);
    }

    public void deletarItem(Integer cdItensPedido) {
        itensPedidoRepository.deleteByCdItensPedido(cdItensPedido);
    }
}
