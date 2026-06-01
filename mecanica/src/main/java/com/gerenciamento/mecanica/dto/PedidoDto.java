package com.gerenciamento.mecanica.dto;

import jakarta.validation.constraints.NotNull;

public record PedidoDto(
        @NotNull(message = "O código do cliente é obrigatório")
        Integer cliente,

        @NotNull(message = "O código do usuário é obrigatório")
        Integer usuario
) {
}
