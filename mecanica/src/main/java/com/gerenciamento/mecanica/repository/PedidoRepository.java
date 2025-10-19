package com.gerenciamento.mecanica.repository;

import com.gerenciamento.mecanica.model.PedidoModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PedidoRepository extends JpaRepository<PedidoModel, Integer> {

    Optional<PedidoModel> findByCdPedido(Integer cdPedido);

    @Transactional
    Optional<PedidoModel> deleteByCdPedido (Integer cdPedido);
}
