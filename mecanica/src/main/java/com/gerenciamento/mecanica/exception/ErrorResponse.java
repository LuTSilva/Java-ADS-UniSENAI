package com.gerenciamento.mecanica.exception;

public record ErrorResponse(int status, String mensagem) {

    public static ErrorResponse of(int status, String mensagem) {
        return new ErrorResponse(status, mensagem);
    }
}