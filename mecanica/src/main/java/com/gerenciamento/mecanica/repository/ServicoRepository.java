package com.gerenciamento.mecanica.repository;


import com.gerenciamento.mecanica.model.ServicoModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ServicoRepository extends JpaRepository<ServicoModel, Integer> {

    Optional<ServicoModel> findByCdServico(Integer cdServico);

    Optional<ServicoModel> findByNmServico(String nmServico);

    @Transactional
    Optional<ServicoModel> deleteByCdServico(Integer cdServico);
}
