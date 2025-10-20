package com.gerenciamento.mecanica.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProdutoDto(

        @NotBlank(message = "O nome do produto não pode ser vazio")
        String nmProduto,

        @NotBlank(message = "A descrição do produto não pode ser vazia")
        String dsProduto,

        @NotBlank(message = "A categoria do produto não pode ser vazia")
        String dsCategoria,

        @NotBlank(message = "A marca do produto não pode ser vazia")
        String dsMarca,

        @NotNull(message = "O valor do produto não pode ser null")
        @DecimalMin(value="0.05", message = "O valor do produto não pode ser inferior à R$ 0,05")
        @DecimalMax(value="999999")
        BigDecimal vlProduto
        ) {

}
