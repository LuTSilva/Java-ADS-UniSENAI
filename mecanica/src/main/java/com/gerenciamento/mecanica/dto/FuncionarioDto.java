package com.gerenciamento.mecanica.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record FuncionarioDto(

        @NotBlank(message = "O nome do funcionário não pode ser vazio")
        String nmFuncionario,

        @NotBlank(message = "O CPF do funcionário não pode ser vazio")
        String nuCpf,

        @NotBlank(message = "O email do funcionário não pode ser vazio")
        String dsEmail,

        @NotBlank(message = "A senha do funcionário não pode ser vazio")
        String dsSenha,

        @NotBlank(message = "O cargo do funcionário não pode ser vazio")
        String dsCargo,

        @NotNull(message = "O salário do funcionário não pode ser null")
        BigDecimal vlSalario
        ) {

}
