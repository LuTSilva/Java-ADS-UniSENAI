package com.gerenciamento.mecanica.dto;

import com.gerenciamento.mecanica.model.FuncionarioModel;
import com.gerenciamento.mecanica.model.UsuarioModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Value;

public record UsuarioDto(

        Integer cdUsuario,
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
        FuncionarioModel funcionario

) {
    public static UsuarioDto completo(UsuarioModel usuario) {
        return new UsuarioDto(
                usuario.getCdUsuario(),
                usuario.getDsEmail(),
                usuario.getDsSenha(),
                usuario.getFlAtivo(),
                usuario.getFlAdministrador(),
                usuario.getFuncionario()
        );
    }
}