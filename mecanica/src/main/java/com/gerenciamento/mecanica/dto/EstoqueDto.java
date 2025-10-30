package com.gerenciamento.mecanica.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record EstoqueDto(

        @NotNull(message = "A quantidade do estoque não pode ser null")
        @Min(0) @Max(999999)
        Integer qtEstoque,

        Integer cdProduto
) {
}
