package com.gerenciamento.mecanica.service;

import com.gerenciamento.mecanica.dto.UsuarioDto;
import com.gerenciamento.mecanica.model.UsuarioModel;
import com.gerenciamento.mecanica.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioModel salvar (@Valid @RequestBody UsuarioDto dto) {
        UsuarioModel usuario = new UsuarioModel();
        usuario.setDsLogin(dto.dsLogin());
        usuario.setDsSenha(dto.dsSenha());
        usuario.setFlAtivo("S");
        return usuarioRepository.save(usuario);
    }
    public List<UsuarioModel> listarTodos() {
        return usuarioRepository.findAll();
    }

    public List<UsuarioModel> listarUsuariosAtivos() {
        return usuarioRepository.findAllByFlAtivo();
    }

    public Optional<UsuarioModel> findByCdUsuario(Integer cdUsuario) {
        return usuarioRepository.findByCdUsuario(cdUsuario);
    }

    public Optional<UsuarioModel> findByNuCpf(String nuCpf) {
        return usuarioRepository.findByNuCpf(nuCpf);
    }

    public Optional<UsuarioModel> atualizaDados(Integer cdUsuario, UsuarioDto usuarioDto) {
        return usuarioRepository.findByCdUsuario(cdUsuario).map(usuario -> {
            usuario.setDsLogin(usuarioDto.dsLogin());
            usuario.setDsSenha(usuarioDto.dsSenha());
            usuario.setFlAtivo(usuarioDto.flAtivo());
            return usuarioRepository.save(usuario);
        });
    }

    public void deletarUsuario(Integer cdUsuario){
        usuarioRepository.deleteByCdUsuario(cdUsuario);
    }
}
