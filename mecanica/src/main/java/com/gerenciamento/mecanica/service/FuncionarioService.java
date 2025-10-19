package com.gerenciamento.mecanica.service;

import com.gerenciamento.mecanica.dto.FuncionarioDto;
import com.gerenciamento.mecanica.model.FuncionarioModel;
import com.gerenciamento.mecanica.repository.FuncionarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public FuncionarioModel salvar (@Valid @RequestBody FuncionarioDto dto) {
        FuncionarioModel func = new FuncionarioModel();
        func.setNmFuncionario(dto.nmFuncionario());
        func.setNuCpf(dto.nuCpf());
        func.setDsEmail(dto.dsEmail());
        func.setDsSenha(dto.dsSenha());
        func.setDsCargo(dto.dsCargo());
        func.setVlSalario(dto.vlSalario());
        return funcionarioRepository.save(func);
    }
    public List<FuncionarioModel> listarTodos() {
        return funcionarioRepository.findAll();
    }

    public Optional<FuncionarioModel> findByCdFuncionario(Integer cdFuncionario) {
        return funcionarioRepository.findByCdFuncionario(cdFuncionario);
    }

    public Optional<FuncionarioModel> findByCpf(String nuCpf) {
        return funcionarioRepository.findByNuCpf(nuCpf);
    }

    public Optional<FuncionarioModel> atualizaDados(Integer cdFuncionario, FuncionarioDto funcionarioDto) {
        return funcionarioRepository.findByCdFuncionario(cdFuncionario).map(func -> {
            func.setNmFuncionario(funcionarioDto.nmFuncionario());
            func.setNuCpf(funcionarioDto.nuCpf());
            func.setDsEmail(funcionarioDto.dsEmail());
            func.setDsSenha(funcionarioDto.dsSenha());
            func.setDsCargo(funcionarioDto.dsCargo());
            func.setVlSalario(funcionarioDto.vlSalario());
            return funcionarioRepository.save(func);
        });
    }

    public void deletarFuncionario(Integer cdFuncionario){
        funcionarioRepository.deleteByCdFuncionario(cdFuncionario);
    }

}
