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
    
    public PedidoModel salvar (@Valid @RequestBody PedidoDto dto) {
        PedidoModel pedido = new PedidoModel();
        pedido.setDsLogin(dto.dsLogin());
        pedido.setDsSenha(dto.dsSenha());
        pedido.setFlAtivo(dto.flAtivo());
        return pedidoRepository.save(pedido);
    }
    public List<PedidoModel> listarTodos() {
        return pedidoRepository.findAll();
    }

    public Optional<PedidoModel> findByCdPedido(Integer cdPedido) {
        return pedidoRepository.findByCdPedido(cdPedido);
    }

    public Optional<PedidoModel> atualizaDados(Integer cdPedido, PedidoDto pedidoDto) {
        return pedidoRepository.findByCdPedido(cdPedido).map(pedido -> {
            pedido.setDsLogin(pedidoDto.dsLogin());
            pedido.setDsSenha(pedidoDto.dsSenha());
            pedido.setFlAtivo(pedidoDto.flAtivo());
            return pedidoRepository.save(pedido);
        });
    }

    public void deletarPedido(Integer cdPedido){
        pedidoRepository.deleteByCdPedido(cdPedido);
    }
}
