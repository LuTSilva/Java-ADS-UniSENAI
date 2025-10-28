package com.gerenciamento.mecanica.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ItensPedidoDto(
        @NotNull(message = "A quantidade do produto não pode ser nula")
        @Min(value = 1, message = "A quantidade deve ser maior que zero")
        Integer qtProduto,

        @NotNull(message = "O valor unitário não pode ser nulo")
        @Positive(message = "O valor unitário deve ser positivo")
        BigDecimal vlUnitario,

        @NotNull(message = "O código do produto não pode ser nulo")
        Integer cdProduto
) {
}
