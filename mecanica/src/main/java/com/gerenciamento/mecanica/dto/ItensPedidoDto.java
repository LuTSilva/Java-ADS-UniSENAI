package com.gerenciamento.mecanica.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ItensPedidoDto(
        @Min(value = 1, message = "A quantidade deve ser maior que zero")
        Integer qtProduto,

        @Positive(message = "O valor unitário deve ser positivo")
        BigDecimal vlUnitario,

        Integer cdProduto,

        Integer cdServico,
        Integer cdPedido
) {
}
