package com.gerenciamento.mecanica.dto;

import jakarta.validation.constraints.Pattern;

public record PedidoDto(

        @Pattern(regexp = "^S|N$", message = "Só é possível valores 'S' ou 'N'")
        String flPgtoConfirmado,

        Integer usuario,
        Integer cliente
) {
}
