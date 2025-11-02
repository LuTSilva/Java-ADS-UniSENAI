package com.gerenciamento.mecanica.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.gerenciamento.mecanica.dto.ItensPedidoDto;
import com.gerenciamento.mecanica.model.ItensPedidoModel;
import com.gerenciamento.mecanica.model.PedidoModel;
import com.gerenciamento.mecanica.model.ProdutoModel;
import com.gerenciamento.mecanica.model.ServicoModel;
import com.gerenciamento.mecanica.repository.ItensPedidoRepository;
import com.gerenciamento.mecanica.repository.PedidoRepository;

import jakarta.validation.Valid;

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

    @Autowired
    private PedidoRepository pedidoRepository;

    public ItensPedidoModel criar(@Valid @RequestBody ItensPedidoDto dto) {
        if (dto.cdPedido() == null) {
            throw new IllegalArgumentException("Código do pedido é obrigatório");
        }

        Optional<PedidoModel> pedidoOpt = pedidoRepository.findByCdPedido(dto.cdPedido());
        if (pedidoOpt.isEmpty()) {
            throw new IllegalArgumentException("Pedido não encontrado com código: " + dto.cdPedido());
        }

        return adicionarItemAoPedido(dto, pedidoOpt.get());
    }

    public ItensPedidoModel adicionarItemAoPedido(@Valid @RequestBody ItensPedidoDto dto, PedidoModel pedido) {
        ItensPedidoModel item = new ItensPedidoModel();
        item.setPedido(pedido);

        BigDecimal subtotal = BigDecimal.ZERO;
        BigDecimal valorUnitario = dto.vlUnitario(); // Pode ser null

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

            // Se vlUnitario não foi informado, usa o preço do produto
            if (valorUnitario == null) {
                valorUnitario = produto.getVlProduto();
            }

            if (!estoqueService.validarEstoqueDisponivel(produto, dto.qtProduto())) {
                Integer quantidadeDisponivel = estoqueService.obterQuantidadeDisponivel(produto);
                throw new IllegalArgumentException(
                    String.format("Estoque insuficiente para o produto %s. Disponível: %d, Solicitado: %d", 
                        produto.getNmProduto(), quantidadeDisponivel, dto.qtProduto())
                );
            }

            item.setQtProduto(dto.qtProduto());
            item.setProduto(produto);
            subtotal = subtotal.add(valorUnitario.multiply(BigDecimal.valueOf(dto.qtProduto())));
        }

        // Processar serviço se informado
        if (dto.cdServico() != null) {
            Optional<ServicoModel> servicoOpt = servicoService.findByCdServico(dto.cdServico());
            if (servicoOpt.isEmpty()) {
                throw new IllegalArgumentException("Serviço não encontrado com código: " + dto.cdServico());
            }

            ServicoModel servico = servicoOpt.get();
            
            // Se vlUnitario não foi informado, usa o preço do serviço
            if (valorUnitario == null) {
                valorUnitario = servico.getVlServico();
            }

            item.setServico(servico);
            subtotal = subtotal.add(valorUnitario);
        }

        // Validar se pelo menos um foi informado
        if (dto.cdProduto() == null && dto.cdServico() == null) {
            throw new IllegalArgumentException("Informe o código do produto e/ou o código do serviço");
        }

        // Validar se valor unitário foi definido (do DTO ou do produto/serviço)
        if (valorUnitario == null) {
            throw new IllegalArgumentException("Valor unitário não foi informado e não foi possível obter do produto/serviço");
        }

        item.setVlUnitario(valorUnitario);
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
