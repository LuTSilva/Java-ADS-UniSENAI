package com.gerenciamento.mecanica.repository;

import com.gerenciamento.mecanica.model.PedidoModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PedidoRepository extends JpaRepository<PedidoModel, Integer> {

    Optional<PedidoModel> findByCdPedido(Integer cdPedido);

    @Query("SELECT emp FROM PedidoModel emp WHERE emp.flPgtoConfirmado = 'S'")
    List<PedidoModel> findAllByFlPgtoConfirmado();

    @Transactional
    Optional<PedidoModel> deleteByCdPedido (Integer cdPedido);
}
