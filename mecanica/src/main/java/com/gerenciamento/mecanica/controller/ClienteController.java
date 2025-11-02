package com.gerenciamento.mecanica.controller;

import com.gerenciamento.mecanica.dto.ClienteDto;
import com.gerenciamento.mecanica.model.ClienteModel;
import com.gerenciamento.mecanica.service.ClienteService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        ClienteModel clienteModel = clienteService.salvar(dto);
        return ResponseEntity.ok(clienteModel);
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
    
    @PutMapping("/{cdCliente}")
    public ResponseEntity<ClienteModel> atualizar(@PathVariable Integer cdCliente, @Valid @RequestBody ClienteDto clienteDto) {
        return clienteService.atualizaDados(cdCliente, clienteDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{cdCliente}")
    public ResponseEntity<Void>deletarPorCdCliente(@PathVariable Integer cdCliente){
        clienteService.deletarCliente(cdCliente);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/cliente/{cdCliente}")
    public ResponseEntity<ClienteModel> listarPorCdCliente(@PathVariable Integer cdCliente){
        return clienteService.findByCdCliente(cdCliente)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/cpf/{nuCpf}")
    public ResponseEntity<ClienteModel> listarPorNuCpf(@PathVariable String nuCpf){
        return clienteService.findByNuCpf(nuCpf)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
