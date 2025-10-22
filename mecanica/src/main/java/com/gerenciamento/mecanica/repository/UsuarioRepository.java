package com.gerenciamento.mecanica.repository;

import com.gerenciamento.mecanica.model.UsuarioModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {

    Optional<UsuarioModel> findByCdUsuario(Integer cdUsuario);
    Optional<UsuarioModel> findByNuCpf(String nuCpf);
    @Query("SELECT emp FROM UsuarioModel emp WHERE emp.flAtivo = 'S'")
    List<UsuarioModel> findAllByFlAtivo();

    @Transactional
    Optional<UsuarioModel> deleteByCdUsuario (Integer cdUsuario);
}
