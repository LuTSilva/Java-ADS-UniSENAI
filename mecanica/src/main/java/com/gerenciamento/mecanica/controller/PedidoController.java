package com.gerenciamento.mecanica.controller;

import com.gerenciamento.mecanica.dto.PedidoDto;
import com.gerenciamento.mecanica.model.PedidoModel;
import com.gerenciamento.mecanica.service.PedidoService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/pedido")
@CrossOrigin("*")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<PedidoModel> criar (@Valid @RequestBody PedidoDto dto) {
        PedidoModel pedidoModel = pedidoService.salvar(dto);
        return ResponseEntity.ok(pedidoModel);
    }
    @GetMapping
    public ResponseEntity<List<PedidoModel>> listarTodos(){
        return ResponseEntity.ok(pedidoService.listarTodos());
    }
    @GetMapping("/confirmados")
    public ResponseEntity<List<PedidoModel>> listarConfirmados(){
        return ResponseEntity.ok(pedidoService.listarConfirmados());
    }
    @GetMapping("/{cdPedido}")
    public ResponseEntity<PedidoModel> listarPorCdPedido(@PathVariable Integer cdPedido){
        return pedidoService.findByCdPedido(cdPedido)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
