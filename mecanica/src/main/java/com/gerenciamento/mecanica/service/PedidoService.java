package com.gerenciamento.mecanica.service;

import com.gerenciamento.mecanica.dto.PedidoDto;
import com.gerenciamento.mecanica.model.PedidoModel;
import com.gerenciamento.mecanica.repository.PedidoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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
        pedido.setFlPgtoConfirmado(dto.flPgtoConfirmado());
        pedido.setCliente(clienteService.findByCdCliente(dto.cliente()).get());
        pedido.setUsuario(usuarioService.findByCdUsuario(dto.usuario()).get());
        pedido.setItensPedido(itensPedidoService.findByCdItensPedido(dto.itensPedido()).get());
        return pedidoRepository.save(pedido);
    }
    public List<PedidoModel> listarTodos() {
        return pedidoRepository.findAll();
    }

    public List<PedidoModel> listarConfirmados() {
        return pedidoRepository.findAllByFlPgtoConfirmado();
    }

    public Optional<PedidoModel> findByCdPedido(Integer cdPedido) {
        return pedidoRepository.findByCdPedido(cdPedido);
    }

    public Optional<PedidoModel> atualizaDados(Integer cdPedido, PedidoDto pedidoDto) {
        return pedidoRepository.findByCdPedido(cdPedido).map(pedido -> {
            pedido.setFlPgtoConfirmado(pedidoDto.flPgtoConfirmado());
            return pedidoRepository.save(pedido);
        });
    }

    public void deletarPedido(Integer cdPedido){
        pedidoRepository.deleteByCdPedido(cdPedido);
    }

    public boolean confirmarPedido(Integer cdPedido) {
        Optional<PedidoModel> pedidoOpt = findByCdPedido(cdPedido);
        
        if (pedidoOpt.isEmpty()) {
            return false; // Pedido não encontrado
        }
        
        PedidoModel pedido = pedidoOpt.get();

        if ("S".equals(pedido.getFlPgtoConfirmado())) {
            return true; // Pedido já confirmado
        }

        boolean vendaProcessada = itensPedidoService.processarVenda(pedido);
        
        if (vendaProcessada) {
            pedido.setFlPgtoConfirmado("S");
            pedidoRepository.save(pedido);
            return true;
        }
        
        return false;
    }
}
