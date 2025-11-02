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
import java.util.stream.Collectors;

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

    @GetMapping("/completo")
    public ResponseEntity<List<FuncionarioDto>> listarTodosCompleto(){
        List<FuncionarioDto> funcionarios = funcionarioService.listarTodos().stream()
                .map(FuncionarioDto::completo)
                .collect(Collectors.toList());
        return ResponseEntity.ok(funcionarios);
    }

    @PutMapping("/{cdFuncionario}")
    public ResponseEntity<FuncionarioModel> atualizar(@PathVariable Integer cdFuncionario, @Valid @RequestBody FuncionarioDto funcionarioDto) {
        return funcionarioService.atualizaDados(cdFuncionario, funcionarioDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{cdFuncionario}")
    public ResponseEntity<Void>deletarPorCdFuncionario(@PathVariable Integer cdFuncionario){
        funcionarioService.deletarFuncionario(cdFuncionario);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/funcionario/{cdFuncionario}")
    public ResponseEntity<FuncionarioModel> listarPorCdFuncionario(@PathVariable Integer cdFuncionario){
        return funcionarioService.findByCdFuncionario(cdFuncionario)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/funcionario/{cdFuncionario}/completo")
    public ResponseEntity<FuncionarioDto> listarPorCdFuncionarioCompleto(@PathVariable Integer cdFuncionario){
        return funcionarioService.findByCdFuncionario(cdFuncionario)
                .map(FuncionarioDto::completo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/cpf/{nuCpf}")
    public ResponseEntity<FuncionarioModel> listarPorNuCpf(@PathVariable String nuCpf) {
        return funcionarioService.findByNuCpf(nuCpf)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/cpf/{nuCpf}/completo")
    public ResponseEntity<FuncionarioDto> listarPorNuCpfCompleto(@PathVariable String nuCpf) {
        return funcionarioService.findByNuCpf(nuCpf)
                .map(FuncionarioDto::completo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
