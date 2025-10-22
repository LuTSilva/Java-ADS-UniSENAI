package com.gerenciamento.mecanica.controller;

import com.gerenciamento.mecanica.dto.ProdutoDto;
import com.gerenciamento.mecanica.dto.ServicoDto;
import com.gerenciamento.mecanica.model.ProdutoModel;
import com.gerenciamento.mecanica.model.ServicoModel;
import com.gerenciamento.mecanica.service.ServicoService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        ServicoModel servicoModel = servicoService.salvar(dto);
        return ResponseEntity.ok(servicoModel);
    }

    @GetMapping
    public ResponseEntity<List<ServicoModel>> listarTodos() {
        return ResponseEntity.ok(servicoService.listarTodos());
    }

    @PutMapping
    public ResponseEntity<ServicoModel> atualizar(@PathVariable Integer cdServico, @Valid @RequestBody ServicoDto servicoDto) {
        return servicoService.atualizaDados(cdServico, servicoDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping
    public ResponseEntity<Void>deletarPorCdServico(@PathVariable Integer cdServico) {
        servicoService.deletarServico(cdServico);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{cdServico}")
    public ResponseEntity<ServicoModel> listarPorCdServico(@PathVariable Integer cdServico){
        return servicoService.findByCdServico(cdServico)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
