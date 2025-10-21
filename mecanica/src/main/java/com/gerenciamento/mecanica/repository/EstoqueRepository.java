package com.gerenciamento.mecanica.repository;

import com.gerenciamento.mecanica.model.EstoqueModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstoqueRepository extends JpaRepository<EstoqueModel, Integer> {
    Optional<EstoqueModel> findByCdEstoque(Integer cdEstoque);

    Optional<EstoqueModel> findByCdProduto(Integer cdProduto);

    @Transactional
    Optional<EstoqueModel> deleteByCdEstoque (Integer cdEstoque);
}
