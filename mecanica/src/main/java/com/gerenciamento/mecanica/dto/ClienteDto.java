package com.gerenciamento.mecanica.dto;

import com.gerenciamento.mecanica.model.ClienteModel;
import jakarta.validation.constraints.NotBlank;

public record ClienteDto(
        Integer cdCliente,
        @NotBlank(message = "O nome do cliente não pode estar em branco")
        String nmCliente,
        @NotBlank(message = "O email do cliente não pode estar em branco")
        String dsEmail,
        @NotBlank(message = "O telefone do cliente não pode estar em branco")
        String nuTelefone,
        @NotBlank(message = "O cpf do cliente não pode estar em branco")
        String nuCpf
) {
    public static ClienteDto completo(ClienteModel cliente) {
        return new ClienteDto(
                cliente.getCdCliente(),
                cliente.getNmCliente(),
                cliente.getDsEmail(),
                cliente.getNuTelefone(),
                cliente.getNuCpf()
        );
    }
}
