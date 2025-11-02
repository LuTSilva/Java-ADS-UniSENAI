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
import java.util.stream.Collectors;

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
    public ResponseEntity<List<FilialModel>> listarTodos(){
        return ResponseEntity.ok(filialService.listarTodos());
    }
    @GetMapping("/ativas")
    public ResponseEntity<List<FilialModel>> listarAtivas(){
        return ResponseEntity.ok(filialService.listarFiliaisAtivas());
    }
    
    @GetMapping("/completo")
    public ResponseEntity<List<FilialDto>> listarTodasCompleto(){
        List<FilialDto> filiais = filialService.listarTodos().stream()
                .map(FilialDto::completo)
                .collect(Collectors.toList());
        return ResponseEntity.ok(filiais);
    }
    @GetMapping("/ativas/completo")
    public ResponseEntity<List<FilialDto>> listarAtivasCompleto(){
        List<FilialDto> filiais = filialService.listarFiliaisAtivas().stream()
                .map(FilialDto::completo)
                .collect(Collectors.toList());
        return ResponseEntity.ok(filiais);
    }

    @PutMapping("/{cdFilial}")
    public ResponseEntity<FilialModel> atualizar(@PathVariable Integer cdFilial, @Valid @RequestBody FilialDto filialDto) {
        return filialService.atualizaDados(cdFilial, filialDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{cdFilial}")
    public ResponseEntity<Void>deletarPorCdFilial(@PathVariable Integer cdFilial){
        filialService.deletarFilial(cdFilial);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/filial/{cdFilial}")
    public ResponseEntity<FilialModel> listarPorCdFilial(@PathVariable Integer cdFilial){
        return filialService.findByCdFilial(cdFilial)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/filial/{cdFilial}/completo")
    public ResponseEntity<FilialDto> listarPorCdFilialCompleto(@PathVariable Integer cdFilial){
        return filialService.findByCdFilial(cdFilial)
                .map(FilialDto::completo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/cnpj/{cdFilial}")
    public ResponseEntity<FilialModel> listarporNuCnpj(@PathVariable String nuCnpj){
        return filialService.findByNuCnpj(nuCnpj)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
