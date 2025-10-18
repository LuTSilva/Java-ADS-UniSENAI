package com.gerenciamento.mecanica.controller;

import com.gerenciamento.mecanica.dto.ClienteDto;
import com.gerenciamento.mecanica.dto.FilialDto;
import com.gerenciamento.mecanica.model.ClienteModel;
import com.gerenciamento.mecanica.model.FilialModel;
import com.gerenciamento.mecanica.service.ClienteService;
import com.gerenciamento.mecanica.service.FilialService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/cliente")
@CrossOrigin("*")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteModel> criar(@Valid @RequestBody ClienteDto dto) {
        ClienteModel clienteModel = clienteService.salvar(dto);
        return ResponseEntity.ok(clienteModel);
    }

    @GetMapping
    public ResponseEntity<List<ClienteModel>> listarTodas() {
        return ResponseEntity.ok(clienteService.listarTodos());
    }

    @GetMapping("/{cdFilial}")
    public ResponseEntity<ClienteModel> listarPorCdCliente(@PathVariable Integer cdCliente){
        return clienteService.findByCdCliente(cdCliente)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
