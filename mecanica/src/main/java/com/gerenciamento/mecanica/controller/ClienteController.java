package com.gerenciamento.mecanica.controller;

import com.gerenciamento.mecanica.dto.ClienteDto;
import com.gerenciamento.mecanica.model.ClienteModel;
import com.gerenciamento.mecanica.service.ClienteService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("api/v1/cliente")
@CrossOrigin("*")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteModel> criar(@Valid @RequestBody ClienteDto dto) {
        ClienteModel cliente = clienteService.salvar(dto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(cliente.getCdCliente())
                .toUri();

        return ResponseEntity.created(location).body(cliente);
    }

    @GetMapping
    public ResponseEntity<List<ClienteModel>> listarTodos() {
        return ResponseEntity.ok(clienteService.listarTodos());
    }

    @GetMapping("/completo")
    public ResponseEntity<List<ClienteDto>> listarTodosCompleto(){
        List<ClienteDto> clientes = clienteService.listarTodos().stream()
                .map(ClienteDto::completo)
                .collect(Collectors.toList());
        return ResponseEntity.ok(clientes);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ClienteModel> listarPorCdCliente(@PathVariable Integer id){
        ClienteModel cliente = clienteService.findByCdCliente(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com o código: " + id));

        return ResponseEntity.ok(cliente);
    }

    @GetMapping("/cpf/{nuCpf}")
    public ResponseEntity<ClienteModel> listarPorNuCpf(@PathVariable String nuCpf){
        ClienteModel cliente = clienteService.findByNuCpf(nuCpf)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com o CPF: " + nuCpf));

        return ResponseEntity.ok(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteModel> atualizar(@PathVariable Integer id, @Valid @RequestBody ClienteDto dto) {
        ClienteModel cliente = clienteService.atualizaDados(id, dto)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com o código: " + id));

        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deletarPorCdCliente(@PathVariable Integer id){
        clienteService.findByCdCliente(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com o código: " + id));

        clienteService.deletarCliente(id);
        return ResponseEntity.noContent().build();
    }
}
