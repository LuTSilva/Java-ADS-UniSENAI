package com.gerenciamento.mecanica.service;

import com.gerenciamento.mecanica.dto.EstoqueDto;
import com.gerenciamento.mecanica.model.EstoqueModel;
import com.gerenciamento.mecanica.repository.EstoqueRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepository;

    public EstoqueModel salvar (@Valid @RequestBody EstoqueDto dto) {
        EstoqueModel estoque = new EstoqueModel();
        estoque.setDsTipo(dto.dsTipo());
        estoque.setQtEstoque(dto.qtEstoque());
        return estoqueRepository.save(estoque);
    }
    public List<EstoqueModel> listarTodos() {
        return estoqueRepository.findAll();
    }

    public Optional<EstoqueModel> findByCdEstoque(Integer cdEstoque) {
        return estoqueRepository.findByCdEstoque(cdEstoque);
    }

    public Optional<EstoqueModel> atualizaDados(Integer cdEstoque, EstoqueDto estoqueDto) {
        return estoqueRepository.findByCdEstoque(cdEstoque).map(estoque -> {
            estoque.setDsTipo(estoqueDto.dsTipo());
            estoque.setQtEstoque(estoqueDto.qtEstoque());
            return estoqueRepository.save(estoque);
        });
    }

    public void deletarEstoque(Integer cdEstoque){
        estoqueRepository.deleteByCdEstoque(cdEstoque);
    }

}
