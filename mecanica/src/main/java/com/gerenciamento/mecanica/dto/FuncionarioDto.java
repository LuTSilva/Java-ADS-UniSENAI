package com.gerenciamento.mecanica.dto;

import com.gerenciamento.mecanica.model.FilialModel;
import com.gerenciamento.mecanica.model.FuncionarioModel;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record FuncionarioDto(

        Integer cdFuncionario,
        @NotBlank(message = "O nome do funcionário não pode ser vazio")
        String nmFuncionario,

        @NotBlank(message = "O CPF do funcionário não pode ser vazio")
        String nuCpf,

        @NotBlank(message = "O cargo do funcionário não pode ser vazio")
        String dsCargo,

        @NotNull(message = "O salário do funcionário não pode ser null")
        @DecimalMin(value = "1000", message = "O salário do funcionário não deve ser inferior à R$ 1000,00")
        @DecimalMax(value = "999999")
        BigDecimal vlSalario,

        String flAtivo,
        FilialModel filial
        ) {
    public static FuncionarioDto completo(FuncionarioModel funcionario) {
        return new FuncionarioDto(
                funcionario.getCdFuncionario(),
                funcionario.getNmFuncionario(),
                funcionario.getNuCpf(),
                funcionario.getDsCargo(),
                funcionario.getVlSalario(),
                funcionario.getFlAtivo(),
                funcionario.getFilial()
        );
    }
}