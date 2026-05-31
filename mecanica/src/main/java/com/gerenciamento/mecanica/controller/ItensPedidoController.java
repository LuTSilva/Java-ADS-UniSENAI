package com.gerenciamento.mecanica.controller;

import com.gerenciamento.mecanica.model.ItensPedidoModel;
import com.gerenciamento.mecanica.service.ItensPedidoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/itenspedido")
@CrossOrigin("*")

public class ItensPedidoController {

    @Autowired
    private ItensPedidoService itensPedidoService;

    @GetMapping
    public ResponseEntity<List<ItensPedidoModel>> listarTodos() {
        List<ItensPedidoModel> itens = itensPedidoService.listarTodos();
        return ResponseEntity.ok(itens);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItensPedidoModel> buscarPorId(@PathVariable Integer id) {
        ItensPedidoModel item = itensPedidoService.findByCdItensPedido(id)
                .orElseThrow(() -> new RuntimeException("Item não encontrado com código: " + id));

        return ResponseEntity.ok(item);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarItem(@PathVariable Integer id) {
        itensPedidoService.findByCdItensPedido(id)
                .orElseThrow(() -> new RuntimeException("Item não encontrado com código: " + id));

        itensPedidoService.deletarItem(id);
        return ResponseEntity.noContent().build();
    }
}
