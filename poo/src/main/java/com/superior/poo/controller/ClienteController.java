package com.superior.poo.controller;

import com.superior.poo.dto.ClienteDto;
import com.superior.poo.model.ClienteModel;
import com.superior.poo.repository.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // indica que esta classe é um Controller REST, responsável por expor endpoints que retornam dados no formato JSON.
@CrossOrigin(origins = "*") // permite acesso de qualquer origem (CORS liberado). Isso é útil quando o frontend (Angular, React, etc.) roda em outro servidor/porta.
@RequestMapping("/api/v1/cliente") // define o caminho base dos endpoints deste controller (/api/v1/cliente).
public class ClienteController {
    @Autowired // injeta automaticamente a dependência do repositório, que faz a comunicação com o banco de dados.
    ClienteRepository clienteRepository;

    // Criar Cliente
    @PostMapping
    public ResponseEntity<ClienteModel> CriarCliente(
            @Valid @RequestBody ClienteDto clienteDto) {
        var clienteModel = new ClienteModel();
        BeanUtils.copyProperties(clienteDto, clienteModel);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(clienteRepository.save(clienteModel));
    }
    /*
    @PostMapping → mapeia o método para requisições HTTP do tipo POST.
    @Valid → ativa as validações configuradas no ClienteDto (ex.: campos obrigatórios, mínimo/máximo, etc.).
    @RequestBody ClienteDto clienteDto → indica que os dados virão no corpo da requisição (JSON).
    BeanUtils.copyProperties → copia os atributos do ClienteDto para o ClienteModel, evitando atribuições manuais.
    clienteRepository.save(clienteModel) → persiste o cliente no banco.
    ResponseEntity.status(HttpStatus.CREATED) → retorna 201 Created em caso de sucesso.
    */

    // Listar todos os clientes
    @GetMapping
    public ResponseEntity<List<ClienteModel>> ListarClientes() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(clienteRepository.findAll());
    }
}
