package com.gerenciamento.mecanica.repository;

import com.gerenciamento.mecanica.model.ClienteModel;
import com.gerenciamento.mecanica.model.FilialModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<ClienteModel, Integer> {
    Optional<ClienteModel> findByCdCliente(Integer cdCliente);
    Optional<ClienteModel>findByNuCpf(String cpfCliente);

    @Transactional
    Optional<ClienteModel> deleteByCdCliente (Integer cdCliente);

}
