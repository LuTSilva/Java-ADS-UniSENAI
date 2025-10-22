package com.gerenciamento.mecanica.service;

import com.gerenciamento.mecanica.dto.FuncionarioDto;
import com.gerenciamento.mecanica.dto.FuncionarioDto2;
import com.gerenciamento.mecanica.dto.UsuarioDto;
import com.gerenciamento.mecanica.model.FuncionarioModel;
import com.gerenciamento.mecanica.model.UsuarioModel;
import com.gerenciamento.mecanica.repository.FuncionarioRepository;
import com.gerenciamento.mecanica.repository.UsuarioRepository;
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
    @Autowired
    private UsuarioRepository usuarioRepository;

    public FuncionarioModel salvar (@Valid @RequestBody FuncionarioDto2 dto2) {
        FuncionarioDto dto = dto2.funcionario();
        UsuarioDto usuarioDto = dto2.usuario();

        FuncionarioModel func = new FuncionarioModel();
        func.setNmFuncionario(dto.nmFuncionario());
        func.setNuCpf(dto.nuCpf());
        func.setDsEmail(dto.dsEmail());
        func.setDsSenha(dto.dsSenha());
        func.setDsCargo(dto.dsCargo());
        func.setVlSalario(dto.vlSalario());

        UsuarioModel usuario = new UsuarioModel();
        usuario.setDsLogin(usuarioDto.dsLogin());
        usuario.setDsSenha(usuarioDto.dsSenha());
        usuario.setNuCpf(usuarioDto.nuCpf());
        usuario.setFlAtivo("S");


        usuario.setFuncionario(func);
        func.setUsuario(usuario);

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
