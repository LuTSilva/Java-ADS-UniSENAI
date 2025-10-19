package com.gerenciamento.mecanica.dto;

import jakarta.validation.constraints.NotBlank;

public record ClienteDto(
        @NotBlank(message = "O nome do cliente não pode estar em branco")
        String nmCliente,

        @NotBlank(message = "O email do cliente não pode estar em branco")
        String dsEmail,

        @NotBlank(message = "O telefone do cliente não pode estar em branco")
        String nuTelefone,

        @NotBlank(message = "O cpf do cliente não pode estar em branco")
        String nuCpf
) {
}
