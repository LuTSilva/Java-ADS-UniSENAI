package com.gerenciamento.mecanica.service;

import com.gerenciamento.mecanica.dto.ProdutoDto;
import com.gerenciamento.mecanica.dto.ProdutoEstoqueDto;
import com.gerenciamento.mecanica.model.EstoqueModel;
import com.gerenciamento.mecanica.model.ProdutoModel;
import com.gerenciamento.mecanica.repository.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoModel salvar (@Valid @RequestBody ProdutoEstoqueDto dto) {
        ProdutoModel produto = new ProdutoModel();
        produto.setNmProduto(dto.nmProduto());
        produto.setDsProduto(dto.dsProduto());
        produto.setDsCategoria(dto.dsCategoria());
        produto.setDsMarca(dto.dsMarca());
        produto.setVlProduto(dto.vlProduto());

        EstoqueModel estoque = new EstoqueModel();
        // Se estoque não for informado, será 0
        estoque.setQtEstoque(dto.qtEstoque() != null ? dto.qtEstoque() : 0);

        estoque.setProduto(produto);
        produto.setEstoque(estoque);

        return produtoRepository.save(produto);
    }
    public List<ProdutoModel> listarTodos() {
        return produtoRepository.findAll();
    }

    public Optional<ProdutoModel> findByCdProduto(Integer cdProduto) {
        return produtoRepository.findByCdProduto(cdProduto);
    }

    public Optional<ProdutoModel> findByNmProduto(String nmProduto) {
        return produtoRepository.findByNmProduto(nmProduto);
    }

    public Optional<ProdutoModel> atualizaDados(Integer cdProduto, ProdutoDto produtoDto) {
        return produtoRepository.findByCdProduto(cdProduto).map(produto -> {
            produto.setNmProduto(produtoDto.nmProduto());
            produto.setDsProduto(produtoDto.dsProduto());
            produto.setDsCategoria(produtoDto.dsCategoria());
            produto.setDsMarca(produtoDto.dsMarca());
            produto.setVlProduto(produtoDto.vlProduto());
            return produtoRepository.save(produto);
        });
    }

    public void deletarProduto(Integer cdProduto){
        produtoRepository.deleteByCdProduto(cdProduto);
    }

}
