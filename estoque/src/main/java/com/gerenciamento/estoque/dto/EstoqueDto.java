package com.gerenciamento.estoque.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record EstoqueDto(
        @NotNull(message="é necessário informar o estoque")
        @Min(0)
        Integer cdLocalEstoque,
        @NotNull(message="é necessário informar o estoque")
        @Min(0)
        Integer qtEstoque,
        @Pattern(regexp = "^S|N$", message="Só é possível salvar a empresa com 'S' ou 'N' para indicar o status")
        String flAtivo

) {
}
