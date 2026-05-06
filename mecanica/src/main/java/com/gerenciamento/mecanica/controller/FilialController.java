package com.gerenciamento.mecanica.controller;

import com.gerenciamento.mecanica.dto.FilialDto;
import com.gerenciamento.mecanica.model.FilialModel;
import com.gerenciamento.mecanica.service.FilialService;
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
@RequestMapping("api/v1/filial")
@CrossOrigin("*")
public class FilialController {

    @Autowired
    private FilialService filialService;

    @PostMapping
    public ResponseEntity<FilialModel> criar (@Valid @RequestBody FilialDto dto) {
        FilialModel filial = filialService.salvar(dto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(filial.getCdFilial())
                .toUri();

        return ResponseEntity.created(location).body(filial);
    }
    @GetMapping
    public ResponseEntity<List<FilialModel>> listarTodos(){
        return ResponseEntity.ok(filialService.listarTodos());
    }
    @GetMapping("/ativas")
    public ResponseEntity<List<FilialModel>> listarAtivas(){
        return ResponseEntity.ok(filialService.listarFiliaisAtivas());
    }

    @GetMapping("/ativas/completo")
    public ResponseEntity<List<FilialDto>> listarAtivasCompleto(){
        List<FilialDto> filiais = filialService.listarFiliaisAtivas().stream()
                .map(FilialDto::completo)
                .collect(Collectors.toList());
        return ResponseEntity.ok(filiais);
    }

    @GetMapping("/completo")
    public ResponseEntity<List<FilialDto>> listarTodasCompleto(){
        List<FilialDto> filiais = filialService.listarTodos().stream()
                .map(FilialDto::completo)
                .collect(Collectors.toList());
        return ResponseEntity.ok(filiais);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilialModel> listarPorCdFilial(@PathVariable Integer id){
        FilialModel filial = filialService.findByCdFilial(id)
                .orElseThrow(() -> new RuntimeException("Filial não localizada com o código: " + id));

        return ResponseEntity.ok(filial);
    }
    
    @GetMapping("/{id}/completo")
    public ResponseEntity<FilialDto> listarPorCdFilialCompleto(@PathVariable Integer id){
        FilialDto filial = filialService.findByCdFilial(id)
                .map(FilialDto::completo)
                .orElseThrow(() -> new RuntimeException("Filial não localizada com código: " + id));

        return ResponseEntity.ok(filial);
    }

    @GetMapping("/cnpj/{nuCnpj}")
    public ResponseEntity<FilialModel> listarporNuCnpj(@PathVariable String nuCnpj){
        FilialModel filial = filialService.findByNuCnpj(nuCnpj)
                .orElseThrow(() -> new RuntimeException("Filial não localizada com o CNPJ: " + nuCnpj));

        return ResponseEntity.ok(filial);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FilialModel> atualizar(@PathVariable Integer id, @Valid @RequestBody FilialDto dto) {
        FilialModel filial = filialService.atualizaDados(id, dto)
                .orElseThrow(() -> new RuntimeException("Filial não localizada com o código: " + id));

        return ResponseEntity.ok(filial);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deletarPorCdFilial(@PathVariable Integer id){
        filialService.findByCdFilial(id)
                .orElseThrow(() -> new RuntimeException("Filial não localizada com código: " + id));

        filialService.deletarFilial(id);
        return ResponseEntity.noContent().build();
    }
}
