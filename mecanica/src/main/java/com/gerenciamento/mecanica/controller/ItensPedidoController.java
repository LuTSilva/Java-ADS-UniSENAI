package com.gerenciamento.mecanica.controller;

import com.gerenciamento.mecanica.dto.ItensPedidoDto;
import com.gerenciamento.mecanica.model.ItensPedidoModel;
import com.gerenciamento.mecanica.model.PedidoModel;
import com.gerenciamento.mecanica.service.ItensPedidoService;
import com.gerenciamento.mecanica.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/itenspedido")
/*
@RequestMapping("/itenspedido")
* */
public class ItensPedidoController {

    @Autowired
    private ItensPedidoService itensPedidoService;

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<ItensPedidoModel> criar(@Valid @RequestBody ItensPedidoDto dto) {
        ItensPedidoModel item = itensPedidoService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(item);
    }

    @PostMapping("/pedido/{cdPedido}")
    public ResponseEntity<?> adicionarItemAoPedido(
            @PathVariable Integer cdPedido,
            @Valid @RequestBody ItensPedidoDto dto) {
        try {
            Optional<PedidoModel> pedidoOpt = pedidoService.findByCdPedido(cdPedido);
            if (pedidoOpt.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Pedido não encontrado com código: " + cdPedido);
            }

            PedidoModel pedido = pedidoOpt.get();
            ItensPedidoModel item = itensPedidoService.adicionarItemAoPedido(dto, pedido);
            
            return ResponseEntity.status(HttpStatus.CREATED).body(item);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/confirmarpedido/{cdPedido}")
    public ResponseEntity<?> confirmarPedido(@PathVariable Integer cdPedido) {
        try {
            boolean confirmado = pedidoService.confirmarPedido(cdPedido);
            if (confirmado) {
                return ResponseEntity.ok("Pedido confirmado e estoque atualizado com sucesso");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Não foi possível confirmar o pedido");
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<ItensPedidoModel>> listarTodos() {
        List<ItensPedidoModel> itens = itensPedidoService.listarTodos();
        return ResponseEntity.ok(itens);
    }

    @GetMapping("/{cdItensPedido}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer cdItensPedido) {
        Optional<ItensPedidoModel> item = itensPedidoService.findByCdItensPedido(cdItensPedido);
        if (item.isPresent()) {
            return ResponseEntity.ok(item.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Item não encontrado com código: " + cdItensPedido);
        }
    }

    @GetMapping("/pedido/{cdPedido}")
    public ResponseEntity<List<ItensPedidoModel>> buscarPorPedido(@PathVariable Integer cdPedido) {
        Optional<PedidoModel> pedidoOpt = pedidoService.findByCdPedido(cdPedido);
        if (pedidoOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        
        List<ItensPedidoModel> itens = itensPedidoService.findByPedido(pedidoOpt.get());
        return ResponseEntity.ok(itens);
    }

    @DeleteMapping("/{cdItensPedido}")
    public ResponseEntity<?> deletarItem(@PathVariable Integer cdItensPedido) {
        Optional<ItensPedidoModel> item = itensPedidoService.findByCdItensPedido(cdItensPedido);
        if (item.isPresent()) {
            itensPedidoService.deletarItem(cdItensPedido);
            return ResponseEntity.ok("Item deletado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Item não encontrado com código: " + cdItensPedido);
        }
    }
}
