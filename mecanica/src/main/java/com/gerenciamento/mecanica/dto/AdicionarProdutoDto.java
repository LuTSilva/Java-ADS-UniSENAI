package com.gerenciamento.mecanica.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record AdicionarProdutoDto(
        @NotNull(message = "Código do produto é obrigatório")
        Integer cdProduto,

        @Min(value = 1, message = "A quantidade deve ser maior que zero")
        Integer qtProduto,

        @Positive(message = "O valor unitário deve ser positivo")
        BigDecimal vlUnitario  // opcional — usa o do cadastro se não informado
) {
}
