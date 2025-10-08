package com.gerenciamento.estoque.service;

import com.gerenciamento.estoque.dto.ProdutoDto;
import com.gerenciamento.estoque.model.ProdutoModel;
import com.gerenciamento.estoque.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// ARMAZENA AS REGRAS DE NEGOCIOS EX: TODA VEZ Q FAZ PEDIDO GANHA 10% DE DESCONTO
@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoModel salvar(ProdutoDto dto) {
        ProdutoModel produto = new ProdutoModel();
        produto.setNmProduto(dto.nmProduto());
        produto.setDsProduto(dto.dsProduto());
        produto.setFlAtivo(dto.flAtivo());
        return produtoRepository.save(produto);
    }

    public List<ProdutoModel> listarTodos() {
        return produtoRepository.findAll();
    }

    public List<ProdutoModel> listarProdutosAtivos() {
        return produtoRepository.findAllByFlAtivo();
    }

    public Optional<ProdutoModel> findByCdProduto(Integer cdProduto) {
        return produtoRepository.findByCdProduto(cdProduto);

    }

    public Optional<ProdutoModel> atualizaDados(Integer cdProduto, ProdutoDto produtoDto) {
        return produtoRepository.findByCdProduto(cdProduto).map(produto -> {
            produto.setNmProduto(produtoDto.nmProduto());
            produto.setDsProduto(produtoDto.dsProduto());
            produto.setFlAtivo(produtoDto.flAtivo());
            return produtoRepository.save(produto);
        });
    }

    public void deletarProduto(Integer cdProduto){
        produtoRepository.deleteByCdProduto(cdProduto);
    }

}