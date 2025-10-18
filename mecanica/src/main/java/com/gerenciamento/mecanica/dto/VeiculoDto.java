package com.gerenciamento.mecanica.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record VeiculoDto(

        @NotBlank(message = "A marca do veículo não pode ser null")
        String marcaVeiculo,

        @NotBlank(message = "O modelo do veículo não pode ser null")
        String modeloVeiculo,

        @NotBlank(message = "O tipo do veículo não pode ser null")
        String tipoVeiculo,

        @NotNull(message = "O ano do veículo não pode ser null")
        int anoVeiculo,

        @NotBlank(message = "A placa do veículo não pode ser null")
        String placaVeiculo
) {
}
