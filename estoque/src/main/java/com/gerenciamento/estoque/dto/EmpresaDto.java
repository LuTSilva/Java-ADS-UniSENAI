package com.gerenciamento.estoque.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record EmpresaDto(
        @NotBlank(message="Não é possível salvar a empresa sem uma razão social")
        String nmRazao,
        String nmFantasia,
        @NotBlank(message="Não é possível salvar a empresa sem um CNPJ")
        String nuCnpj,
        String nuTelefone,
        @NotBlank(message="Não é possível salvar a empresa sem um Endereço")
        String dsEndereco,
        @Pattern(regexp = "^S|N$", message="Só é possível salvar a empresa com 'S' ou 'N' para indicar o status")
        String flAtivo

) {
}
