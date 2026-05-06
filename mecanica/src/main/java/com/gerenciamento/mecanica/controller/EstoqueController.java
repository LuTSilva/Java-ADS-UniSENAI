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

    @GetMapping
    public ResponseEntity<List<EstoqueModel>> listarTodos() {
        return ResponseEntity.ok(estoqueService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstoqueModel> listarPorCdEstoque(@PathVariable Integer id){
        EstoqueModel estoque = estoqueService.findByCdEstoque(id)
                .orElseThrow(() -> new RuntimeException("Estoque não localizado com o código: " + id));

        return ResponseEntity.ok(estoque);
    }
    @GetMapping("/produto/{id}")
    public ResponseEntity<EstoqueModel> buscarPorCdProduto(@PathVariable ProdutoModel id){
        EstoqueModel estoque = estoqueService.findByCdProduto(id)
                .orElseThrow(() -> new RuntimeException("Produto não localizado com o código: " + id));

        return ResponseEntity.ok(estoque);
    }
    @PutMapping("/{id}")
    public ResponseEntity<EstoqueModel> atualizar(@PathVariable Integer id, @Valid @RequestBody EstoqueDto dto) {
        EstoqueModel estoque = estoqueService.atualizaDados(id, dto)
                .orElseThrow(() -> new RuntimeException("Estoque não localizado com o código: " + id));

        return ResponseEntity.ok(estoque);
    }

}
