package com.gerenciamento.mecanica.repository;

import com.gerenciamento.mecanica.model.ItensPedidoModel;
import com.gerenciamento.mecanica.model.PedidoModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ItensPedidoRepository extends JpaRepository<ItensPedidoModel, Integer> {
    Optional<ItensPedidoModel> findByCdItensPedido(Integer cdItensPedido);
    
    List<ItensPedidoModel> findByPedido(PedidoModel pedido);

    @Transactional
    Optional<ItensPedidoModel> deleteByCdItensPedido(Integer cdItensPedido);
}
