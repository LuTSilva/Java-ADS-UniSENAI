package com.gerenciamento.estoque.controller;

import com.gerenciamento.estoque.dto.EstoqueDto;
import com.gerenciamento.estoque.model.EstoqueModel;
import com.gerenciamento.estoque.service.EstoqueService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//PERMITE A GENTE CONFIGURAR O LOG - DEIXA A MENSAGEM MAIS EXPLICIDA CASO DE ERRO
@Slf4j
@RestController
@RequestMapping("api/v1/estoque")
@CrossOrigin ("*")
public class EstoqueController {

    @Autowired
    private EstoqueService estoqueService;

    @PostMapping
    public ResponseEntity<EstoqueModel> criar (@Valid @RequestBody EstoqueDto dto){
        EstoqueModel estoqueModel = estoqueService.salvar(dto);
        return ResponseEntity.ok(estoqueModel);
    }

    @GetMapping
    public ResponseEntity<List<EstoqueModel>> listarTodas(){
        return ResponseEntity.ok(estoqueService.listarTodos());
    }

    @GetMapping("/ativas")
    public ResponseEntity<List<EstoqueModel>> listarAtivas(){
        return ResponseEntity.ok(estoqueService.listarEstoquesAtivos());
    }

    @GetMapping("/{cdEstoque}")
    public ResponseEntity<EstoqueModel> listarPorCdEstoque(@PathVariable Integer cdEstoque){
        return estoqueService.findByCdEstoque(cdEstoque)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


}