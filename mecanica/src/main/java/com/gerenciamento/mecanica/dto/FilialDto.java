package com.gerenciamento.mecanica.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record FilialDto(

        Integer cdFilial,
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
    public static FilialDto completo(com.gerenciamento.mecanica.model.FilialModel filial) {
        return new FilialDto(
                filial.getCdFilial(),
                filial.getNmRazao(),
                filial.getNmFantasia(),
                filial.getNuCnpj(),
                filial.getDsLocal(),
                filial.getNuTelefone(),
                filial.getFlAtivo()
        );
    }
}
