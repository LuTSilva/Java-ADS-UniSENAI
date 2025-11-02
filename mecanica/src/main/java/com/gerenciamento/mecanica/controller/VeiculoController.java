package com.gerenciamento.mecanica.controller;

import com.gerenciamento.mecanica.dto.VeiculoDto;
import com.gerenciamento.mecanica.model.VeiculoModel;
import com.gerenciamento.mecanica.service.VeiculoService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/veiculo")
@CrossOrigin("*")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @PostMapping
    public ResponseEntity<VeiculoModel> criar(@Valid @RequestBody VeiculoDto dto) {
        VeiculoModel veiculoModel = veiculoService.salvar(dto);
        return ResponseEntity.ok(veiculoModel);
    }

    @GetMapping
    public ResponseEntity<List<VeiculoModel>> listarTodos() {
        return ResponseEntity.ok(veiculoService.listarTodos());
    }

    @GetMapping("/veiculo/{cdVeiculo}")
    public ResponseEntity<VeiculoModel> listarPorCdVeiculo(@PathVariable Integer cdVeiculo){
        return veiculoService.findByCdVeiculo(cdVeiculo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/placa/{dsPlaca}")
    public ResponseEntity<VeiculoModel> findByDsPlaca(@PathVariable String dsPlaca){
        return veiculoService.findByDsPlaca(dsPlaca)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PutMapping("/{cdVeiculo}")
    public ResponseEntity<VeiculoModel> atualizaDados(@PathVariable Integer cdVeiculo, @Valid @RequestBody VeiculoDto dto) {
        return veiculoService.atualizaDados(cdVeiculo, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{cdVeiculo}")
    public ResponseEntity<Void>deletarPorCdVeiculo(@PathVariable Integer cdVeiculo){
        veiculoService.deletarVeiculo(cdVeiculo);
        return ResponseEntity.noContent().build();
    }
}
