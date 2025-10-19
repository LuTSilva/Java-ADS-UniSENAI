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
    public ResponseEntity<List<UsuarioModel>> listarTodas(){
        return ResponseEntity.ok(usuarioService.listarTodos());
    }
    @GetMapping("/ativas")
    public ResponseEntity<List<UsuarioModel>> listarAtivas(){
        return ResponseEntity.ok(usuarioService.listarUsuariosAtivos());
    }
    @GetMapping("/{cdUsuario}")
    public ResponseEntity<UsuarioModel> listarPorCdUsuario(@PathVariable Integer cdUsuario){
        return usuarioService.findByCdUsuario(cdUsuario)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
