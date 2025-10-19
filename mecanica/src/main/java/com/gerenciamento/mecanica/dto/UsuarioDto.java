package com.gerenciamento.mecanica.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Value;

public record UsuarioDto(

        @NotBlank(message="Não é possível salvar o usuário sem informar login")
        String dsLogin,
        @NotBlank(message="Não é possível salvar o usuário sem informar senha")
        String dsSenha,
        @Pattern(regexp = "^S|N$", message = "Só é possível valores 'S' ou 'N'")
        @Value("S")
        String flAtivo

) {
}
