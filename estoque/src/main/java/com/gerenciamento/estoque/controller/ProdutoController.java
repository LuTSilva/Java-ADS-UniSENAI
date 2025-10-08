package com.gerenciamento.estoque.controller;

import com.gerenciamento.estoque.dto.ProdutoDto;
import com.gerenciamento.estoque.model.ProdutoModel;
import com.gerenciamento.estoque.service.ProdutoService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//PERMITE A GENTE CONFIGURAR O LOG - DEIXA A MENSAGEM MAIS EXPLICIDA CASO DE ERRO
@Slf4j
@RestController
@RequestMapping("api/v1/produto")
@CrossOrigin ("*")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<ProdutoModel> criar (@Valid @RequestBody ProdutoDto dto){
        ProdutoModel produtoModel = produtoService.salvar(dto);
        return ResponseEntity.ok(produtoModel);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoModel>> listarTodas(){
        return ResponseEntity.ok(produtoService.listarTodos());
    }

    @GetMapping("/ativas")
    public ResponseEntity<List<ProdutoModel>> listarAtivas(){
        return ResponseEntity.ok(produtoService.listarProdutosAtivos());
    }

    @GetMapping("/{cdProduto}")
    public ResponseEntity<ProdutoModel> listarPorCdProduto(@PathVariable Integer cdProduto){
        return produtoService.findByCdProduto(cdProduto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


}