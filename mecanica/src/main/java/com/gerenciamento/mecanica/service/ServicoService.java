package com.gerenciamento.mecanica.service;

import com.gerenciamento.mecanica.dto.ServicoDto;
import com.gerenciamento.mecanica.model.ServicoModel;
import com.gerenciamento.mecanica.repository.ServicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    public ServicoModel salvar (@Valid @RequestBody ServicoDto dto) {
        ServicoModel servico = new ServicoModel();
        servico.setNmServico(dto.nmServico());
        servico.setDsServico(dto.dsServico());
        servico.setDsTipo(dto.dsTipo());
        servico.setQtDuracao(dto.qtDuracao());
        servico.setVlServico(dto.vlServico());
        return servicoRepository.save(servico);
    }
    public List<ServicoModel> listarTodos() {
        return servicoRepository.findAll();
    }

    public Optional<ServicoModel> findByCdServico(Integer cdServico) {
        return servicoRepository.findByCdServico(cdServico);
    }

    public Optional<ServicoModel> findByNmServico(String nmServico) {
        return servicoRepository.findByNmServico(nmServico);
    }

    public Optional<ServicoModel> atualizaDados(Integer cdServico, ServicoDto servicoDto) {
        return servicoRepository.findByCdServico(cdServico).map(servico -> {
            servico.setNmServico(servicoDto.nmServico());
            servico.setDsServico(servicoDto.dsServico());
            servico.setDsTipo(servicoDto.dsTipo());
            servico.setQtDuracao(servicoDto.qtDuracao());
            servico.setVlServico(servicoDto.vlServico());
            return servicoRepository.save(servico);
        });
    }

    public void deletarServico(Integer cdServico){
        servicoRepository.deleteByCdServico(cdServico);
    }

}
