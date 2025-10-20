package com.gerenciamento.mecanica.repository;


import com.gerenciamento.mecanica.model.ProdutoModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Integer> {

    Optional<ProdutoModel> findByCdProduto(Integer cdProduto);

    Optional<ProdutoModel> findByNmProduto(String nmProduto);

    @Transactional
    Optional<ProdutoModel> deleteByCdProduto(Integer cdProduto);
}
