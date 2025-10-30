package com.gerenciamento.mecanica.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record ProdutoEstoqueDto(

        @NotBlank(message = "O nome do produto não pode ser vazio")
        String nmProduto,

        @NotBlank(message = "A descrição do produto não pode ser vazia")
        String dsProduto,

        @NotBlank(message = "A categoria do produto não pode ser vazia")
        String dsCategoria,

        @NotBlank(message = "A marca do produto não pode ser vazia")
        String dsMarca,

        @Min(0) @Max(999999)
        Integer qtEstoque,

        @NotNull(message = "O valor do produto não pode ser null")
        @DecimalMin(value="0.05", message = "O valor do produto não pode ser inferior à R$ 0,05")
        @DecimalMax(value="999999")
        BigDecimal vlProduto
        ) {

}
