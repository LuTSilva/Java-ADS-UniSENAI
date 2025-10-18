package com.gerenciamento.mecanica.repository;

import com.gerenciamento.mecanica.model.FilialModel;
import com.gerenciamento.mecanica.model.VeiculoModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VeiculoRepository extends JpaRepository<VeiculoModel, Integer> {
    Optional<VeiculoModel> findByCdVeiculo(Integer cdVeiculo);
    Optional<VeiculoModel> findByPlaca(String placaVeiculo);

    @Transactional
    Optional<VeiculoModel> deleteByCdVeiculo (Integer cdVeiculo);
}
