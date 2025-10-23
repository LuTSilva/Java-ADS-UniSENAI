package com.gerenciamento.mecanica.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record UsuarioFuncionarioDto(

        @Valid @NotNull FuncionarioDto funcionario,
        @Valid @NotNull UsuarioDto usuario
        ) {

}
