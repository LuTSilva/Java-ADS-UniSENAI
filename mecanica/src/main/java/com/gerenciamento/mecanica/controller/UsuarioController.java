package com.gerenciamento.mecanica.controller;

import com.gerenciamento.mecanica.dto.UsuarioDto;
import com.gerenciamento.mecanica.model.UsuarioModel;
import com.gerenciamento.mecanica.service.UsuarioService;
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
@RequestMapping("api/v1/usuario")
@CrossOrigin("*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioModel> criar (@Valid @RequestBody UsuarioDto dto) {
        UsuarioModel usuario = usuarioService.salvar(dto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(usuario.getCdUsuario())
                .toUri();

        return ResponseEntity.created(location).body(usuario);
    }
    @GetMapping
    public ResponseEntity<List<UsuarioModel>> listarTodos(){
        return ResponseEntity.ok(usuarioService.listarTodos());
    }
    @GetMapping("/completo")
    public ResponseEntity<List<UsuarioDto>> listarTodosCompleto(){
        List<UsuarioDto> usuarios = usuarioService.listarTodos().stream()
                .map(UsuarioDto::completo)
                .collect(Collectors.toList());
        return ResponseEntity.ok(usuarios);
    }
    @GetMapping("/ativos")
    public ResponseEntity<List<UsuarioModel>> listarAtivos(){
        return ResponseEntity.ok(usuarioService.listarUsuariosAtivos());
    }
    @GetMapping("/ativos/completo")
    public ResponseEntity<List<UsuarioDto>> listarAtivosCompleto(){
        List<UsuarioDto> usuarios = usuarioService.listarUsuariosAtivos().stream()
                .map(UsuarioDto::completo)
                .collect(Collectors.toList());
        return ResponseEntity.ok(usuarios);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioModel> listarPorCdUsuario(@PathVariable Integer id){
        UsuarioModel usuario = usuarioService.findByCdUsuario(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com o código: " + id));

        return ResponseEntity.ok(usuario);
    }
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioModel> atualizaDados(@PathVariable Integer id, @Valid @RequestBody UsuarioDto dto) {
        UsuarioModel usuario = usuarioService.atualizaDados(id, dto)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com o código: " + id));

        return ResponseEntity.ok(usuario);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deletarPorCdUsuario(@PathVariable Integer id){
        usuarioService.findByCdUsuario(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com o código: " + id));

        usuarioService.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
