package com.gerenciamento.mecanica.repository;

import com.gerenciamento.mecanica.model.ItensPedidoModel;
import com.gerenciamento.mecanica.model.PedidoModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ItensPedidoRepository extends JpaRepository<ItensPedidoModel, Integer> {
    Optional<ItensPedidoModel> findByCdItensPedido(Integer cdItensPedido);
    
    List<ItensPedidoModel> findByPedido(PedidoModel pedido);

    @Query("SELECT COALESCE(SUM(i.vlSubtotal), 0) FROM ItensPedidoModel i WHERE i.pedido.cdPedido = :cdPedido")
    BigDecimal calcularTotalPedido(@Param("cdPedido") Integer cdPedido);
    @Transactional
    void deleteByCdItensPedido(Integer cdItensPedido);
}
