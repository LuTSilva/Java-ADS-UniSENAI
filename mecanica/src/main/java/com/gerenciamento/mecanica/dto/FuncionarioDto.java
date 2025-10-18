package com.gerenciamento.mecanica.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;

public record FuncionarioDto(

        @NotBlank(message = "O nome do funcionário não pode ser null")
        String nomeFuncionario,

        @NotBlank(message = "O CPF do funcionário não pode ser null")
        String cpfFuncionario,

        @NotBlank(message = "O email do funcionário não pode ser null")
        String emailFuncionario,

        @NotBlank(message = "A senha do funcionário não pode ser null")
        String senhaFuncionario,

        @NotBlank(message = "O cargo do funcionário não pode ser null")
        String cargoFuncionario,

        @NotBlank(message = "O salário do funcionário não pode ser null")
        String salarioFuncionario
        ) {

}
