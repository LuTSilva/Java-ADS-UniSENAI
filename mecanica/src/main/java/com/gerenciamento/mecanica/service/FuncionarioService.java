package com.gerenciamento.mecanica.service;

import com.gerenciamento.mecanica.dto.FuncionarioDto;
import com.gerenciamento.mecanica.dto.UsuarioFuncionarioDto;
import com.gerenciamento.mecanica.model.FuncionarioModel;
import com.gerenciamento.mecanica.model.UsuarioModel;
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
    @Autowired
    private FilialService filialService;

    public FuncionarioModel salvar (@Valid @RequestBody UsuarioFuncionarioDto dto) {

        FuncionarioModel func = new FuncionarioModel();
        func.setNmFuncionario(dto.nmFuncionario());
        func.setNuCpf(dto.nuCpf());
        func.setDsCargo(dto.dsCargo());
        func.setVlSalario(dto.vlSalario());
        func.setFlAtivo("S"); // Por padrão, funcionário é criado como ativo
        func.setFilial(filialService.findByCdFilial(dto.cdFilial()).get());

        UsuarioModel usuario = new UsuarioModel();
        usuario.setDsEmail(dto.dsEmail());
        usuario.setDsSenha(dto.dsSenha());
        usuario.setFlAtivo("S");
        usuario.setFlAdministrador("N");

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

    public Optional<FuncionarioModel> findByNuCpf(String nuCpf) {
        return funcionarioRepository.findByNuCpf(nuCpf);
    }

    public Optional<FuncionarioModel> atualizaDados(Integer cdFuncionario, FuncionarioDto funcionarioDto) {
        return funcionarioRepository.findByCdFuncionario(cdFuncionario).map(func -> {
            func.setNmFuncionario(funcionarioDto.nmFuncionario());
            func.setNuCpf(funcionarioDto.nuCpf());
            func.setDsCargo(funcionarioDto.dsCargo());
            func.setVlSalario(funcionarioDto.vlSalario());
            func.setFlAtivo(funcionarioDto.flAtivo());
            return funcionarioRepository.save(func);
        });
    }

    public void deletarFuncionario(Integer cdFuncionario){
        funcionarioRepository.deleteByCdFuncionario(cdFuncionario);
    }

}
