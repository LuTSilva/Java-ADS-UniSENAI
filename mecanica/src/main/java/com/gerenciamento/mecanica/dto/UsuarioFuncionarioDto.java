package com.gerenciamento.mecanica.dto;

import jakarta.validation.constraints.*;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;

public record UsuarioFuncionarioDto(
        @NotBlank(message="Não é possível salvar o usuário sem informar email")
        String dsEmail,
        @NotBlank(message="Não é possível salvar o usuário sem informar senha")
        String dsSenha,

        @Pattern(regexp = "^S|N$", message = "Só é possível valores 'S' ou 'N'")
        @Value("S")
        String flAtivo,

        @Pattern(regexp = "^S|N$", message = "Só é possível valores 'S' ou 'N'")
        @Value("N")
        String flAdministrador,
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

        Integer cdFilial
        ) {

}
