package com.gerenciamento.mecanica.controller;

import com.gerenciamento.mecanica.dto.FuncionarioDto;
import com.gerenciamento.mecanica.dto.UsuarioFuncionarioDto;
import com.gerenciamento.mecanica.model.FuncionarioModel;
import com.gerenciamento.mecanica.service.FuncionarioService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/funcionario")
@CrossOrigin("*")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping
    public ResponseEntity<FuncionarioModel> criar(@Valid @RequestBody UsuarioFuncionarioDto dto) {
        FuncionarioModel funcionarioModel = funcionarioService.salvar(dto);
        return ResponseEntity.ok(funcionarioModel);
    }

    @GetMapping
    public ResponseEntity<List<FuncionarioModel>> listarTodos() {
        return ResponseEntity.ok(funcionarioService.listarTodos());
    }

    @PutMapping
    public ResponseEntity<FuncionarioModel> atualizar(@PathVariable Integer cdFuncionario, @Valid @RequestBody FuncionarioDto funcionarioDto) {
        return funcionarioService.atualizaDados(cdFuncionario, funcionarioDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping
    public ResponseEntity<Void>deletarPorCdFuncionario(@PathVariable Integer cdFuncionario){
        funcionarioService.deletarFuncionario(cdFuncionario);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{cdFuncionario}")
    public ResponseEntity<FuncionarioModel> listarPorCdFuncionario(@PathVariable Integer cdFuncionario){
        return funcionarioService.findByCdFuncionario(cdFuncionario)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
