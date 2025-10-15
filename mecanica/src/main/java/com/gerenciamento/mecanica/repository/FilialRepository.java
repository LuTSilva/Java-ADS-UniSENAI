package com.gerenciamento.mecanica.repository;

import com.gerenciamento.mecanica.model.FilialModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface FilialRepository extends JpaRepository<FilialModel, Integer> {

    Optional<FilialModel> findByCdFilial(Integer cdFilial);
    Optional<FilialModel>findByNuCnpj(String nuCnpj);

    @Query("SELECT emp FROM FilialModel emp WHERE emp.flAtivo = 'S'")
    List<FilialModel> findAllByFlAtivo();

    @Transactional
    Optional<FilialModel> deleteByCdFilial (Integer cdFilial);
}
