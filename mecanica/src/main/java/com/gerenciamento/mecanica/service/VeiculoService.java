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
    @Autowired
    private ClienteService clienteService;

    public VeiculoModel salvar (@Valid @RequestBody VeiculoDto dto) {
        VeiculoModel veiculo = new VeiculoModel();
        veiculo.setDsMarca(dto.dsMarca());
        veiculo.setDsModelo(dto.dsModelo());
        veiculo.setDsTipo(dto.dsTipo());
        veiculo.setNuAno(dto.nuAno());
        veiculo.setDsPlaca(dto.dsPlaca());
        veiculo.setCliente(clienteService.findByNuCpf(dto.nuCpf()).get());
        return veiculoRepository.save(veiculo);
    }
    public List<VeiculoModel> listarTodos() {
        return veiculoRepository.findAll();
    }

    public Optional<VeiculoModel> findByCdVeiculo(Integer cdVeiculo) {
        return veiculoRepository.findByCdVeiculo(cdVeiculo);
    }

    public Optional<VeiculoModel> findByDsPlaca(String dsPlaca) {
        return veiculoRepository.findByDsPlaca(dsPlaca);
    }

    public Optional<VeiculoModel> atualizaDados(Integer cdVeiculo, VeiculoDto veiculoDto) {
        return veiculoRepository.findByCdVeiculo(cdVeiculo).map(veiculo -> {
            veiculo.setDsMarca(veiculoDto.dsMarca());
            veiculo.setDsModelo(veiculoDto.dsModelo());
            veiculo.setDsTipo(veiculoDto.dsTipo());
            veiculo.setNuAno(veiculoDto.nuAno());
            veiculo.setDsPlaca(veiculoDto.dsPlaca());
            return veiculoRepository.save(veiculo);
        });
    }

    public void deletarVeiculo(Integer cdVeiculo){
        veiculoRepository.deleteByCdVeiculo(cdVeiculo);
    }

}
