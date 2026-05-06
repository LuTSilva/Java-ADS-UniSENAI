package com.gerenciamento.mecanica.controller;

import com.gerenciamento.mecanica.dto.ItensPedidoDto;
import com.gerenciamento.mecanica.model.ItensPedidoModel;
import com.gerenciamento.mecanica.service.ItensPedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/v1/itenspedido")

public class ItensPedidoController {

    @Autowired
    private ItensPedidoService itensPedidoService;

    @PostMapping
    public ResponseEntity<ItensPedidoModel> criar(@Valid @RequestBody ItensPedidoDto dto) {
        ItensPedidoModel item = itensPedidoService.criar(dto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(item.getCdItensPedido())
                .toUri();

        return ResponseEntity.created(location).body(item);
    }

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
