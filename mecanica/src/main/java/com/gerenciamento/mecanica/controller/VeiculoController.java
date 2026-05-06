package com.gerenciamento.mecanica.controller;

import com.gerenciamento.mecanica.dto.VeiculoDto;
import com.gerenciamento.mecanica.model.VeiculoModel;
import com.gerenciamento.mecanica.service.VeiculoService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
        VeiculoModel veiculo = veiculoService.salvar(dto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(veiculo.getCdVeiculo())
                .toUri();

        return ResponseEntity.created(location).body(veiculo);
    }

    @GetMapping
    public ResponseEntity<List<VeiculoModel>> listarTodos() {
        return ResponseEntity.ok(veiculoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VeiculoModel> listarPorCdVeiculo(@PathVariable Integer id){
        VeiculoModel veiculo = veiculoService.findByCdVeiculo(id)
                .orElseThrow(() -> new RuntimeException("Veiculo não localizado com o código: " + id));

        return ResponseEntity.ok(veiculo);
    }

    @GetMapping("/placa/{dsPlaca}")
    public ResponseEntity<VeiculoModel> findByDsPlaca(@PathVariable String dsPlaca){
        VeiculoModel veiculo = veiculoService.findByDsPlaca(dsPlaca)
                .orElseThrow(() -> new RuntimeException("Veiculo não localizado com a placa: " + dsPlaca));

        return ResponseEntity.ok(veiculo);
    }
    @PutMapping("/{id}")
    public ResponseEntity<VeiculoModel> atualizaDados(@PathVariable Integer id, @Valid @RequestBody VeiculoDto dto) {
        VeiculoModel veiculo = veiculoService.atualizaDados(id, dto)
                .orElseThrow(() -> new RuntimeException("Veiculo não localizado com o código: " + id));

        return ResponseEntity.ok(veiculo);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deletarPorCdVeiculo(@PathVariable Integer id){
        veiculoService.findByCdVeiculo(id)
                .orElseThrow(() -> new RuntimeException("Filial não localizada com código: " + id));

        veiculoService.deletarVeiculo(id);
        return ResponseEntity.noContent().build();
    }
}
