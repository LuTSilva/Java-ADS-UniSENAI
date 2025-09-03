package com.superior.poo.controller;

import com.superior.poo.dto.ProdutoDto;
import com.superior.poo.model.ProdutoModel;
import com.superior.poo.repository.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // indica que esta classe é um Controller REST, responsável por expor endpoints que retornam dados no formato JSON.
@CrossOrigin(origins = "*") // permite acesso de qualquer origem (CORS liberado). Isso é útil quando o frontend (Angular, React, etc.) roda em outro servidor/porta.
@RequestMapping("/api/v1/produto") // define o caminho base dos endpoints deste controller (/api/v1/produto).
public class ProdutoController {
    @Autowired // injeta automaticamente a dependência do repositório, que faz a comunicação com o banco de dados.
    ProdutoRepository produtoRepository;

    // Criar Produto
    @PostMapping
    public ResponseEntity<ProdutoModel> CriarProduto(
            @Valid @RequestBody ProdutoDto produtoDto) {
        var produtoModel = new ProdutoModel();
        BeanUtils.copyProperties(produtoDto, produtoModel);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(produtoRepository.save(produtoModel));
    }
    /*
    @PostMapping → mapeia o método para requisições HTTP do tipo POST.
    @Valid → ativa as validações configuradas no ProdutoDto (ex.: campos obrigatórios, mínimo/máximo, etc.).
    @RequestBody ProdutoDto produtoDto → indica que os dados virão no corpo da requisição (JSON).
    BeanUtils.copyProperties → copia os atributos do ProdutoDto para o ProdutoModel, evitando atribuições manuais.
    produtoRepository.save(produtoModel) → persiste o produto no banco.
    ResponseEntity.status(HttpStatus.CREATED) → retorna 201 Created em caso de sucesso.
    */

    // Listar todos os produtos
    @GetMapping
    public ResponseEntity<List<ProdutoModel>> ListarProdutos() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(produtoRepository.findAll());
    }
}
