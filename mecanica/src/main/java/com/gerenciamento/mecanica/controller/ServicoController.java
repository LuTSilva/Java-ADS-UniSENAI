package com.gerenciamento.mecanica.controller;

import com.gerenciamento.mecanica.dto.ServicoDto;
import com.gerenciamento.mecanica.model.ServicoModel;
import com.gerenciamento.mecanica.service.ServicoService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/servico")
@CrossOrigin("*")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @PostMapping
    public ResponseEntity<ServicoModel> criar(@Valid @RequestBody ServicoDto dto) {
        ServicoModel servico = servicoService.salvar(dto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(servico.getCdServico())
                .toUri();

        return ResponseEntity.created(location).body(servico);
    }

    @GetMapping
    public ResponseEntity<List<ServicoModel>> listarTodos() {
        return ResponseEntity.ok(servicoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicoModel> listarPorCdServico(@PathVariable Integer id){
        ServicoModel servico = servicoService.findByCdServico(id)
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado com o código: " + id));

        return ResponseEntity.ok(servico);
    }

    @GetMapping("/nome/{nmServico}")
    public ResponseEntity<ServicoModel> listarPorNmServico(@PathVariable String nmServico){
        ServicoModel servico = servicoService.findByNmServico(nmServico)
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado com o nome: " + nmServico));

        return ResponseEntity.ok(servico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServicoModel> atualizar(@PathVariable Integer id, @Valid @RequestBody ServicoDto dto) {
        ServicoModel servico = servicoService.atualizaDados(id, dto)
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado com o código: " + id));

        return ResponseEntity.ok(servico);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deletarPorCdServico(@PathVariable Integer id) {
        servicoService.findByCdServico(id)
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado com o código: " + id));

        servicoService.deletarServico(id);
        return ResponseEntity.noContent().build();
    }
}
