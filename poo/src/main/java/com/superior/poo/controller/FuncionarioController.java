package com.superior.poo.controller;

import com.superior.poo.dto.FuncionarioDto;
import com.superior.poo.model.FuncionarioModel;
import com.superior.poo.repository.FuncionarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // indica que esta classe é um Controller REST, responsável por expor endpoints que retornam dados no formato JSON.
@CrossOrigin(origins = "*") // permite acesso de qualquer origem (CORS liberado). Isso é útil quando o frontend (Angular, React, etc.) roda em outro servidor/porta.
@RequestMapping("/api/v1/funcionario") // define o caminho base dos endpoints deste controller (/api/v1/funcionario).
public class FuncionarioController {
    @Autowired // injeta automaticamente a dependência do repositório, que faz a comunicação com o banco de dados.
    FuncionarioRepository funcionarioRepository;

    // Criar Funcionario
    @PostMapping
    public ResponseEntity<FuncionarioModel> CriarFuncionario(
            @Valid @RequestBody FuncionarioDto funcionarioDto) {
        var funcionarioModel = new FuncionarioModel();
        BeanUtils.copyProperties(funcionarioDto, funcionarioModel);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(funcionarioRepository.save(funcionarioModel));
    }
    /*
    @PostMapping → mapeia o método para requisições HTTP do tipo POST.
    @Valid → ativa as validações configuradas no FuncionarioDto (ex.: campos obrigatórios, mínimo/máximo, etc.).
    @RequestBody FuncionarioDto FuncionarioDto → indica que os dados virão no corpo da requisição (JSON).
    BeanUtils.copyProperties → copia os atributos do FuncionarioDto para o FuncionarioModel, evitando atribuições manuais.
    FuncionarioRepository.save(FuncionarioModel) → persiste o Funcionario no banco.
    ResponseEntity.status(HttpStatus.CREATED) → retorna 201 Created em caso de sucesso.
    */

    // Listar todos os Funcionarios
    @GetMapping
    public ResponseEntity<List<FuncionarioModel>> ListarFuncionarios() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(funcionarioRepository.findAll());
    }
}
