package com.gerenciamento.mecanica.service;

import com.gerenciamento.mecanica.dto.PagamentoDto;
import com.gerenciamento.mecanica.dto.PedidoDto;
import com.gerenciamento.mecanica.model.PedidoModel;
import com.gerenciamento.mecanica.repository.PedidoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ItensPedidoService itensPedidoService;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private UsuarioService usuarioService;

    public PedidoModel salvar (@Valid @RequestBody PedidoDto dto) {
        PedidoModel pedido = new PedidoModel();
        pedido.setStatus("ABERTO");
        pedido.setCliente(clienteService.findByCdCliente(dto.cliente())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com código: " + dto.cliente())));
        pedido.setUsuario(usuarioService.findByCdUsuario(dto.usuario())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com código: " + dto.usuario())));
        return pedidoRepository.save(pedido);
    }

    public List<PedidoModel> listarTodos() {
        return pedidoRepository.findAll();
    }

    public List<PedidoModel> listarPorStatus(String status) {
        return pedidoRepository.findByStatus(status.toUpperCase());
    }

    public Optional<PedidoModel> findByCdPedido(Integer cdPedido) {
        return pedidoRepository.findByCdPedido(cdPedido);
    }

    public void deletarPedido(Integer cdPedido){
        pedidoRepository.deleteByCdPedido(cdPedido);
    }

    @Transactional
    public void confirmarPedido(Integer cdPedido) {
        PedidoModel pedido = findByCdPedido(cdPedido)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado com código: " + cdPedido));

        if (!"ABERTO".equals(pedido.getStatus())) {
            throw new IllegalArgumentException("Apenas pedidos com status ABERTO podem ser confirmados. Status atual: " + pedido.getStatus());
        }

        itensPedidoService.processarVenda(pedido);

        pedido.setStatus("CONFIRMADO");
        pedidoRepository.save(pedido);
    }

    @Transactional
    public PedidoModel registrarPagamento(Integer cdPedido, PagamentoDto dto) {
        PedidoModel pedido = findByCdPedido(cdPedido)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado com código: " + cdPedido));

        if (!"CONFIRMADO".equals(pedido.getStatus())) {
            throw new IllegalArgumentException("Apenas pedidos com status CONFIRMADO podem ser pagos. Status atual: " + pedido.getStatus());
        }

        BigDecimal totalPedido = itensPedidoService.calcularTotalPedido(cdPedido);

        if (dto.vlPagamento().compareTo(totalPedido) < 0) {
            throw new IllegalArgumentException(String.format(
                    "Valor do pagamento insuficiente. Total do pedido: R$ %.2f, Valor informado: R$ %.2f",
                    totalPedido, dto.vlPagamento()));
        }

        pedido.setFormaPagamento(dto.formaPagamento());
        pedido.setVlPagamento(dto.vlPagamento());
        pedido.setDtPagamento(LocalDateTime.now());
        pedido.setStatus("PAGO");

        // calcula troco apenas para pagamento em dinheiro
        if ("DINHEIRO".equals(dto.formaPagamento())) {
            pedido.setVlTrocado(dto.vlPagamento().subtract(totalPedido));
        }

        return pedidoRepository.save(pedido);
    }
}
