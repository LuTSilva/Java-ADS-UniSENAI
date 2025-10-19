package com.gerenciamento.mecanica.repository;


import com.gerenciamento.mecanica.model.FuncionarioModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FuncionarioRepository extends JpaRepository<FuncionarioModel, Integer> {

    Optional<FuncionarioModel> findByCdFuncionario(Integer cdFuncionario);

    Optional<FuncionarioModel> findByNuCpf(String nuCpf);

    @Transactional
    Optional<FuncionarioModel> deleteByCdFuncionario(Integer cdFuncionario);
}
