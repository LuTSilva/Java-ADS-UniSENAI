package com.gerenciamento.mecanica.controller;

import com.gerenciamento.mecanica.dto.EstoqueDto;
import com.gerenciamento.mecanica.model.EstoqueModel;
import com.gerenciamento.mecanica.model.ProdutoModel;
import com.gerenciamento.mecanica.service.EstoqueService;
import com.gerenciamento.mecanica.service.ProdutoService;
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

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<EstoqueModel>> listarTodos() {
        return ResponseEntity.ok(estoqueService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstoqueModel> listarPorCdEstoque(@PathVariable Integer id){
        EstoqueModel estoque = estoqueService.findByCdEstoque(id)
                .orElseThrow(() -> new RuntimeException("Estoque não encontrado com o código: " + id));

        return ResponseEntity.ok(estoque);
    }
    @GetMapping("/{id}/produto")
    public ResponseEntity<EstoqueModel> buscarPorCdProduto(@PathVariable Integer id) {
        ProdutoModel produto = produtoService.findByCdProduto(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com o código: " + id));

        EstoqueModel estoque = estoqueService.findByCdProduto(produto)
                .orElseThrow(() -> new RuntimeException("Estoque não encontrado para o produto: " + id));

        return ResponseEntity.ok(estoque);
    }
    @PutMapping("/{id}")
    public ResponseEntity<EstoqueModel> atualizar(@PathVariable Integer id, @Valid @RequestBody EstoqueDto dto) {
        EstoqueModel estoque = estoqueService.atualizaDados(id, dto)
                .orElseThrow(() -> new RuntimeException("Estoque não encontrado com o código: " + id));

        return ResponseEntity.ok(estoque);
    }

}
