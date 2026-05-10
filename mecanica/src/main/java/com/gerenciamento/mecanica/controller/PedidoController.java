package com.gerenciamento.mecanica.controller;

import com.gerenciamento.mecanica.dto.AdicionarProdutoDto;
import com.gerenciamento.mecanica.dto.AdicionarServicoDto;
import com.gerenciamento.mecanica.dto.PedidoDto;
import com.gerenciamento.mecanica.model.ItensPedidoModel;
import com.gerenciamento.mecanica.model.PedidoModel;
import com.gerenciamento.mecanica.service.ItensPedidoService;
import com.gerenciamento.mecanica.service.PedidoService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/pedido")
@CrossOrigin("*")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ItensPedidoService itensPedidoService;

    @PostMapping
    public ResponseEntity<PedidoModel> criar (@Valid @RequestBody PedidoDto dto) {
        PedidoModel pedido = pedidoService.salvar(dto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(pedido.getCdPedido())
                .toUri();

        return ResponseEntity.created(location).body(pedido);
    }

    @PostMapping("/{id}/incluir-produto")
    public ResponseEntity<ItensPedidoModel> adicionarProduto(
            @PathVariable Integer id,
            @Valid @RequestBody AdicionarProdutoDto dto) {

        PedidoModel pedido = pedidoService.findByCdPedido(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado com código: " + id));

        ItensPedidoModel item = itensPedidoService.adicionarProduto(dto, pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(item);
    }

    @PostMapping("{id}/incluir-servico")
    public ResponseEntity<ItensPedidoModel> adicionarServico(
            @PathVariable Integer id,
            @Valid @RequestBody AdicionarServicoDto dto) {

        PedidoModel pedido = pedidoService.findByCdPedido(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado com código: " + id));

        ItensPedidoModel item = itensPedidoService.adicionarServico(dto, pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(item);
    }

    @GetMapping
    public ResponseEntity<List<PedidoModel>> listarTodos(){
        return ResponseEntity.ok(pedidoService.listarTodos());
    }

    @GetMapping("/confirmados")
    public ResponseEntity<List<PedidoModel>> listarConfirmados(){
        return ResponseEntity.ok(pedidoService.listarConfirmados());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoModel> listarPorCdPedido(@PathVariable Integer id){
        PedidoModel pedido = pedidoService.findByCdPedido(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado com o código: " + id));

        return ResponseEntity.ok(pedido);
    }

    @GetMapping("/{id}/itens")
    public ResponseEntity<List<ItensPedidoModel>> listarItens(@PathVariable Integer id) {
        PedidoModel pedido = pedidoService.findByCdPedido(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado com código: " + id));

        List<ItensPedidoModel> itens = itensPedidoService.findByPedido(pedido);
        return ResponseEntity.ok(itens);
    }

    @PatchMapping("/{id}/confirmar")
    public ResponseEntity<Void> confirmarPedido(@PathVariable Integer id) {
        pedidoService.confirmarPedido(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoModel> atualizar(@PathVariable Integer id, @Valid @RequestBody PedidoDto dto) {
        PedidoModel pedido = pedidoService.atualizaDados(id, dto)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado com o código: " + id));

        return ResponseEntity.ok(pedido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deletarPorCdPedido(@PathVariable Integer id){
        pedidoService.findByCdPedido(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado com o código: " + id));

        pedidoService.deletarPedido(id);
        return ResponseEntity.noContent().build();
    }
}
