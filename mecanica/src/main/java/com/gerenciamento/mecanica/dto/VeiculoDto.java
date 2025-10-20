package com.gerenciamento.mecanica.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record VeiculoDto(

        @NotBlank(message = "A marca do veículo não pode estar em branco")
        String dsMarca,

        @NotBlank(message = "O modelo do veículo não pode estar em branco")
        String dsModelo,

        @NotBlank(message = "O tipo do veículo não pode estar em branco")
        String dsTipo,

        @NotNull(message = "O ano do veículo não pode ser null")
        @Min(1950)
        Integer nuAno,

        @NotBlank(message = "A placa do veículo não pode estar em branco")
        String dsPlaca
) {
}
