package com.gerenciamento.mecanica.controller;

import com.gerenciamento.mecanica.dto.EstoqueDto;
import com.gerenciamento.mecanica.model.EstoqueModel;
import com.gerenciamento.mecanica.model.ProdutoModel;
import com.gerenciamento.mecanica.service.EstoqueService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/estoque")
@CrossOrigin("*")
public class EstoqueController {

    @Autowired
    private EstoqueService estoqueService;

    @PostMapping
    public ResponseEntity<EstoqueModel> criar(@Valid @RequestBody EstoqueDto dto) {
        EstoqueModel estoqueModel = estoqueService.salvar(dto);
        return ResponseEntity.ok(estoqueModel);
    }

    @GetMapping
    public ResponseEntity<List<EstoqueModel>> listarTodos() {
        return ResponseEntity.ok(estoqueService.listarTodos());
    }

    @GetMapping("/{cdEstoque}")
    public ResponseEntity<EstoqueModel> listarPorCdEstoque(@PathVariable Integer cdEstoque){
        return estoqueService.findByCdEstoque(cdEstoque)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/{cdProduto}")
    public ResponseEntity<EstoqueModel> buscarPorCdProduto(@PathVariable ProdutoModel cdProduto){
        return estoqueService.buscarPorCdProduto(cdProduto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
