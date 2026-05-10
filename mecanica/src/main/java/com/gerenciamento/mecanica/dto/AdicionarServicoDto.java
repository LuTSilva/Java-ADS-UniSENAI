package com.gerenciamento.mecanica.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record AdicionarServicoDto(
        @NotNull(message = "Código do serviço é obrigatório")
        Integer cdServico,

        @Positive(message = "O valor unitário deve ser positivo")
        BigDecimal vlUnitario  // opcional — usa o do cadastro se não informado
) {
}
