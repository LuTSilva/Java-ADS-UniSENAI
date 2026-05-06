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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
        FuncionarioModel funcionario = funcionarioService.salvar(dto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(funcionario.getCdFuncionario())
                .toUri();

        return ResponseEntity.created(location).body(funcionario);
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

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioModel> listarPorCdFuncionario(@PathVariable Integer id){
        FuncionarioModel funcionario = funcionarioService.findByCdFuncionario(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não localizado com o código: " + id));

        return ResponseEntity.ok(funcionario);
    }
    @GetMapping("/{id}/completo")
    public ResponseEntity<FuncionarioDto> listarPorCdFuncionarioCompleto(@PathVariable Integer id){
        FuncionarioDto funcionario = funcionarioService.findByCdFuncionario(id)
                .map(FuncionarioDto::completo)
                .orElseThrow(() -> new RuntimeException("Funcionário não localizado com o código: " + id));

        return ResponseEntity.ok(funcionario);
    }

    @GetMapping("/cpf/{nuCpf}")
    public ResponseEntity<FuncionarioModel> listarPorNuCpf(@PathVariable String nuCpf) {
        FuncionarioModel funcionario = funcionarioService.findByNuCpf(nuCpf)
                .orElseThrow(() -> new RuntimeException("Funcionário não localizado com o CPF: " + nuCpf));

        return ResponseEntity.ok(funcionario);
    }

    @GetMapping("/cpf/{nuCpf}/completo")
    public ResponseEntity<FuncionarioDto> listarPorNuCpfCompleto(@PathVariable String nuCpf) {
        FuncionarioDto funcionario = funcionarioService.findByNuCpf(nuCpf)
                .map(FuncionarioDto::completo)
                .orElseThrow(() -> new RuntimeException("Funcionário não localizado com o CPF: " + nuCpf));

        return ResponseEntity.ok(funcionario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncionarioModel> atualizar(@PathVariable Integer id, @Valid @RequestBody FuncionarioDto dto) {
        FuncionarioModel funcionario = funcionarioService.atualizaDados(id, dto)
                .orElseThrow(() -> new RuntimeException("Funcionário não localizado com o código: " + id));

        return ResponseEntity.ok(funcionario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deletarPorCdFuncionario(@PathVariable Integer id){
        funcionarioService.findByCdFuncionario(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não localizado com código: " + id));

        funcionarioService.deletarFuncionario(id);
        return ResponseEntity.noContent().build();
    }
}
