package com.gerenciamento.estoque.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record ProdutoDto(
        @NotBlank(message="Não é possível salvar o produto sem um nome")
        String nmProduto,
        @NotBlank(message="Não é possível salvar o produto sem uma descrição")
        String dsProduto,
        @Pattern(regexp = "^S|N$", message="Só é possível salvar a empresa com 'S' ou 'N' para indicar o status")
        String flAtivo

) {
}
