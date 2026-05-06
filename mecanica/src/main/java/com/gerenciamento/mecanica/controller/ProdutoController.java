package com.gerenciamento.mecanica.controller;

import com.gerenciamento.mecanica.dto.ProdutoDto;
import com.gerenciamento.mecanica.dto.ProdutoEstoqueDto;
import com.gerenciamento.mecanica.model.ProdutoModel;
import com.gerenciamento.mecanica.service.ProdutoService;
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
@RequestMapping("api/v1/produto")
@CrossOrigin("*")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<ProdutoModel> criar(@Valid @RequestBody ProdutoEstoqueDto dto) {
        ProdutoModel produto = produtoService.salvar(dto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(produto.getCdProduto())
                .toUri();

        return ResponseEntity.created(location).body(produto);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoModel>> listarTodos() {
        return ResponseEntity.ok(produtoService.listarTodos());
    }
    
    @GetMapping("/completo")
    public ResponseEntity<List<ProdutoDto>> listarTodosCompleto(){
        List<ProdutoDto> produtos = produtoService.listarTodos().stream()
                .map(ProdutoDto::completo)
                .collect(Collectors.toList());
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoModel> listarPorCdProduto(@PathVariable Integer id){
        ProdutoModel produto = produtoService.findByCdProduto(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com o código: " + id));

        return ResponseEntity.ok(produto);
    }

    @GetMapping("/nome/{nmProduto}")
    public ResponseEntity<ProdutoModel> listarPorNmProduto(@PathVariable String nmProduto){
        ProdutoModel produto = produtoService.findByNmProduto(nmProduto)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com o nome: " + nmProduto));

        return ResponseEntity.ok(produto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoModel> atualizar(@PathVariable Integer id, @Valid @RequestBody ProdutoDto dto) {
        ProdutoModel produto = produtoService.atualizaDados(id, dto)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com o código: " + id));

        return ResponseEntity.ok(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deletarPorCdProduto(@PathVariable Integer id){
        produtoService.findByCdProduto(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com o código: " + id));

        produtoService.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }
}
