package com.gerenciamento.mecanica.controller;

import com.gerenciamento.mecanica.dto.ProdutoDto;
import com.gerenciamento.mecanica.model.ProdutoModel;
import com.gerenciamento.mecanica.service.ProdutoService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/produto")
@CrossOrigin("*")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<ProdutoModel> criar(@Valid @RequestBody ProdutoDto dto) {
        ProdutoModel produtoModel = produtoService.salvar(dto);
        return ResponseEntity.ok(produtoModel);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoModel>> listarTodos() {
        return ResponseEntity.ok(produtoService.listarTodos());
    }

    @PutMapping
    public ResponseEntity<ProdutoModel> atualizar(@PathVariable Integer cdProduto, @Valid @RequestBody ProdutoDto produtoDto) {
        return produtoService.atualizaDados(cdProduto, produtoDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping
    public ResponseEntity<Void>deletarPorCdProduto(@PathVariable Integer cdProduto){
        produtoService.deletarProduto(cdProduto);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{cdProduto}")
    public ResponseEntity<ProdutoModel> listarPorCdProduto(@PathVariable Integer cdProduto){
        return produtoService.findByCdProduto(cdProduto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
