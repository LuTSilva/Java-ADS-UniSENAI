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
        func.setNomeFuncionario(dto.nomeFuncionario());
        func.setCpfFuncionario(dto.cpfFuncionario());
        func.setEmailFuncionario(dto.emailFuncionario());
        func.setSenhaFuncionario(dto.senhaFuncionario());
        func.setCargoFuncionario(dto.cargoFuncionario());
        func.setSalarioFuncionario(dto.salarioFuncionario());
        return funcionarioRepository.save(func);
    }
    public List<FuncionarioModel> listarTodos() {
        return funcionarioRepository.findAll();
    }

    public Optional<FuncionarioModel> findByCdFuncionario(Integer cdFuncionario) {
        return funcionarioRepository.findByCdFuncionario(cdFuncionario);
    }

    public Optional<FuncionarioModel> findByCpf(String cpfFuncionario) {
        return funcionarioRepository.findByCpf(cpfFuncionario);
    }

    public Optional<FuncionarioModel> atualizaDados(Integer cdFuncionario, FuncionarioDto funcionarioDto) {
        return funcionarioRepository.findByCdFuncionario(cdFuncionario).map(func -> {
            func.setNomeFuncionario(funcionarioDto.nomeFuncionario());
            func.setCpfFuncionario(funcionarioDto.cpfFuncionario());
            func.setEmailFuncionario(funcionarioDto.emailFuncionario());
            func.setSenhaFuncionario(funcionarioDto.senhaFuncionario());
            func.setCargoFuncionario(funcionarioDto.cargoFuncionario());
            func.setSalarioFuncionario(funcionarioDto.salarioFuncionario());
            return funcionarioRepository.save(func);
        });
    }

    public void deletarFuncionario(Integer cdFuncionario){
        funcionarioRepository.deleteByCdFuncionario(cdFuncionario);
    }

}
