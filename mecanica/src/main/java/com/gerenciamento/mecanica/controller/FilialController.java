package com.gerenciamento.mecanica.controller;

import com.gerenciamento.mecanica.dto.FilialDto;
import com.gerenciamento.mecanica.model.FilialModel;
import com.gerenciamento.mecanica.service.FilialService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/filial")
@CrossOrigin("*")
public class FilialController {

    @Autowired
    private FilialService filialService;

    @PostMapping
    public ResponseEntity<FilialModel> criar (@Valid @RequestBody FilialDto dto) {
        FilialModel filialModel = filialService.salvar(dto);
        return ResponseEntity.ok(filialModel);
    }
    @GetMapping
    public ResponseEntity<List<FilialModel>> listarTodas(){
        return ResponseEntity.ok(filialService.listarTodos());
    }
    @GetMapping("/ativas")
    public ResponseEntity<List<FilialModel>> listarAtivas(){
        return ResponseEntity.ok(filialService.listarFiliaisAtivas());
    }

    @PutMapping
    public ResponseEntity<FilialModel> atualizar(@PathVariable Integer cdFilial, @Valid @RequestBody FilialDto filialDto) {
        return filialService.atualizaDados(cdFilial, filialDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping
    public ResponseEntity<Void>deletarPorCdFilial(@PathVariable Integer cdFilial){
        filialService.deletarFilial(cdFilial);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{cdFilial}")
    public ResponseEntity<FilialModel> listarPorCdFilial(@PathVariable Integer cdFilial){
        return filialService.findByCdFilial(cdFilial)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
