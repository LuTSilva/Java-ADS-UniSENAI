package com.gerenciamento.mecanica.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record ServicoDto(

        @NotBlank(message = "O nome do servico não pode ser vazio")
        String nmServico,

        @NotBlank(message = "A descrição do servico não pode ser vazia")
        String dsServico,

        @NotBlank(message = "O tipo do servico não pode ser vazio")
        String dsTipo,

        @NotNull(message = "A duracao do servico não pode ser null (em minutos)")
        @Min(1) @Max(10080)
        Integer qtDuracao,

        @NotNull(message = "O valor do servico não pode ser null")
        @DecimalMin(value="0.05", message = "O valor do servico não pode ser inferior à R$ 0,05")
        @DecimalMax(value="999999")
        BigDecimal vlServico,

        @NotNull(message = "O funcionário responsável pelo serviço não pode ser null")
        Integer cdFuncionario
        ) {

}
