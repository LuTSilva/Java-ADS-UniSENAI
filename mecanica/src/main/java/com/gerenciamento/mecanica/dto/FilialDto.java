package com.gerenciamento.mecanica.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Value;

public record FilialDto(

        @NotBlank(message="Não é possível salvar a filial sem informar razão social")
        String nmRazao,
        String nmFantasia,
        @NotBlank(message="Não é possível salvar a filial sem informar CNPJ")
        String nuCnpj,
        @NotBlank(message="Não é possível salvar a filial sem telefone")
        String nuTelefone,
        String dsLocal,
        @Pattern(regexp = "^S|N$", message = "Só é possível valores 'S' ou 'N'")
        String flAtivo

) {
}
