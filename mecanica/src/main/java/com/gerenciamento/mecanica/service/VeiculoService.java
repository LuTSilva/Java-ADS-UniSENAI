package com.gerenciamento.mecanica.service;

import com.gerenciamento.mecanica.dto.VeiculoDto;
import com.gerenciamento.mecanica.model.VeiculoModel;
import com.gerenciamento.mecanica.repository.VeiculoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public VeiculoModel salvar (@Valid @RequestBody VeiculoDto dto) {
        VeiculoModel veiculo = new VeiculoModel();
        veiculo.setMarcaVeiculo(dto.marcaVeiculo());
        veiculo.setModeloVeiculo(dto.modeloVeiculo());
        veiculo.setTipoVeiculo(dto.tipoVeiculo());
        veiculo.setAnoVeiculo(dto.anoVeiculo());
        veiculo.setPlacaVeiculo(dto.placaVeiculo());
        return veiculoRepository.save(veiculo);
    }
    public List<VeiculoModel> listarTodos() {
        return veiculoRepository.findAll();
    }

    public Optional<VeiculoModel> findByCdVeiculo(Integer cdVeiculo) {
        return veiculoRepository.findByCdVeiculo(cdVeiculo);
    }

    public Optional<VeiculoModel> findByPlaca(String placaVeiculo) {
        return veiculoRepository.findByPlaca(placaVeiculo);
    }

    public Optional<VeiculoModel> atualizaDados(Integer cdVeiculo, VeiculoDto veiculoDto) {
        return veiculoRepository.findByCdVeiculo(cdVeiculo).map(veiculo -> {
            veiculo.setMarcaVeiculo(veiculoDto.marcaVeiculo());
            veiculo.setModeloVeiculo(veiculoDto.modeloVeiculo());
            veiculo.setTipoVeiculo(veiculoDto.tipoVeiculo());
            veiculo.setAnoVeiculo(veiculoDto.anoVeiculo());
            veiculo.setPlacaVeiculo(veiculoDto.placaVeiculo());
            return veiculoRepository.save(veiculo);
        });
    }

    public void deletarVeiculo(Integer cdVeiculo){
        veiculoRepository.deleteByCdVeiculo(cdVeiculo);
    }

}
