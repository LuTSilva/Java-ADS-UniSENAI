package com.gerenciamento.mecanica.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;

public record ClienteDto(
        @NotBlank(message = "O nome do cliente não pode ser null")
        String nomeCliente,

        @NotBlank(message = "O email do cliente não pode ser null")
        String emailCliente,

        String telefoneCliente,

        @NotBlank(message = "A senha do cliente não pode ser null")
        String senhaCliente,

        @NotBlank(message = "O cpf do cliente não pode ser null")
        String cpfCliente,

        @NotBlank(message = "O cep do cliente não pode ser null")
        String cepCliente,

        @NotBlank(message = "A cidade do cliente não pode ser null")
        String cidadeCliente,

        @NotBlank(message = "O bairro do cliente não pode ser null")
        String bairroCliente,

        @NotBlank(message = "A rua do cliente não pode ser null")
        String ruaCliente,

        @NotBlank(message = "O número de endereço do cliente não pode ser null")
        String numeroEnderecoCliente
) {
}
