package com.gerenciamento.mecanica.controller;

import com.gerenciamento.mecanica.dto.UsuarioDto;
import com.gerenciamento.mecanica.model.UsuarioModel;
import com.gerenciamento.mecanica.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        UsuarioModel usuarioModel = usuarioService.salvar(dto);
        return ResponseEntity.ok(usuarioModel);
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
    @GetMapping("/{cdUsuario}")
    public ResponseEntity<UsuarioModel> listarPorCdUsuario(@PathVariable Integer cdUsuario){
        return usuarioService.findByCdUsuario(cdUsuario)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PutMapping("/{cdUsuario}")
    public ResponseEntity<UsuarioModel> atualizaDados(@PathVariable Integer cdUsuario, @Valid @RequestBody UsuarioDto dto) {
        return usuarioService.atualizaDados(cdUsuario, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{cdUsuario}")
    public ResponseEntity<Void>deletarPorCdUsuario(@PathVariable Integer cdUsuario){
        usuarioService.deletarUsuario(cdUsuario);
        return ResponseEntity.noContent().build();
    }
}
