package com.gerenciamento.mecanica.service;

import com.gerenciamento.mecanica.dto.EstoqueDto;
import com.gerenciamento.mecanica.model.EstoqueModel;
import com.gerenciamento.mecanica.model.ProdutoModel;
import com.gerenciamento.mecanica.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepository;
    @Autowired
    private ProdutoService produtoService;

    public List<EstoqueModel> listarTodos() {
        return estoqueRepository.findAll();
    }

    public Optional<EstoqueModel> buscarPorCdEstoque(Integer cdEstoque) {
        return estoqueRepository.findByCdEstoque(cdEstoque);
    }

    public Optional<EstoqueModel> buscarPorCdProduto(ProdutoModel cdProduto){
        return  estoqueRepository.findByProduto(cdProduto);
    }

    public Optional<EstoqueModel> atualizaDados(Integer cdEstoque, EstoqueDto estoqueDto) {
        return estoqueRepository.findByCdEstoque(cdEstoque).map(estoque -> {
            estoque.setQtEstoque(estoqueDto.qtEstoque());
            return estoqueRepository.save(estoque);
        });
    }

    public boolean validarEstoqueDisponivel(ProdutoModel produto, Integer quantidadeSolicitada) {
        Optional<EstoqueModel> estoqueOpt = buscarPorCdProduto(produto);
        
        if (estoqueOpt.isEmpty()) {
            return false; // Produto não possui estoque cadastrado
        }
        
        EstoqueModel estoque = estoqueOpt.get();
        return estoque.getQtEstoque() >= quantidadeSolicitada;
    }

    public boolean atualizarEstoqueAposVenda(ProdutoModel produto, Integer quantidadeVendida) {
        Optional<EstoqueModel> estoqueOpt = buscarPorCdProduto(produto);
        
        if (estoqueOpt.isEmpty()) {
            return false; // Produto não possui estoque cadastrado
        }
        
        EstoqueModel estoque = estoqueOpt.get();

        if (!validarEstoqueDisponivel(produto, quantidadeVendida)) {
            return false;
        }

        estoque.setQtEstoque(estoque.getQtEstoque() - quantidadeVendida);
        estoqueRepository.save(estoque);
        
        return true;
    }

    public Integer obterQuantidadeDisponivel(ProdutoModel produto) {
        Optional<EstoqueModel> estoqueOpt = buscarPorCdProduto(produto);
        
        if (estoqueOpt.isEmpty()) {
            return 0; // Produto não possui estoque cadastrado
        }
        
        return estoqueOpt.get().getQtEstoque();
    }

}
