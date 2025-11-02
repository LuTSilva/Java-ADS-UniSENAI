package com.gerenciamento.mecanica.service;

import com.gerenciamento.mecanica.dto.ServicoDto;
import com.gerenciamento.mecanica.model.FuncionarioModel;
import com.gerenciamento.mecanica.model.ServicoModel;
import com.gerenciamento.mecanica.repository.FuncionarioRepository;
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

    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @Autowired
    private FuncionarioService funcionarioService;

    public ServicoModel salvar (@Valid @RequestBody ServicoDto dto) {
        //Validar se o funcionário está ativo
        FuncionarioModel funcionario = funcionarioRepository.findByNuCpf(dto.nuCpf())
                .orElseThrow(() -> new IllegalArgumentException("Funcionário não encontrado com o CPF: " + dto.nuCpf()));
        
        if (funcionario.getFlAtivo() == null || !"S".equals(funcionario.getFlAtivo())) {
            throw new IllegalArgumentException("Todo serviço deve estar vinculado a um funcionário ativo. Funcionário ID " + dto.cdFuncionario() + " está inativo.");
        }
        
        ServicoModel servico = new ServicoModel();
        servico.setNmServico(dto.nmServico());
        servico.setDsServico(dto.dsServico());
        servico.setDsTipo(dto.dsTipo());
        servico.setQtDuracao(dto.qtDuracao());
        servico.setVlServico(dto.vlServico());
        servico.setFuncionario(funcionarioService.findByNuCpf(dto.nuCpf()).get());
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
            // RN009: Validar se o funcionário está ativo
            FuncionarioModel funcionario = funcionarioRepository.findByCdFuncionario(servicoDto.cdFuncionario())
                    .orElseThrow(() -> new IllegalArgumentException("Funcionário não encontrado com ID: " + servicoDto.cdFuncionario()));
            
            if (funcionario.getFlAtivo() == null || !"S".equals(funcionario.getFlAtivo())) {
                throw new IllegalArgumentException("RN009: Todo serviço deve estar vinculado a um funcionário ativo. Funcionário ID " + servicoDto.cdFuncionario() + " está inativo.");
            }
            
            servico.setNmServico(servicoDto.nmServico());
            servico.setDsServico(servicoDto.dsServico());
            servico.setDsTipo(servicoDto.dsTipo());
            servico.setQtDuracao(servicoDto.qtDuracao());
            servico.setVlServico(servicoDto.vlServico());
            servico.setFuncionario(funcionario);
            return servicoRepository.save(servico);
        });
    }

    public void deletarServico(Integer cdServico){
        servicoRepository.deleteByCdServico(cdServico);
    }

}
