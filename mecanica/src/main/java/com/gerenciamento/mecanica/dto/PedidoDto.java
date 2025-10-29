package com.gerenciamento.mecanica.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDateTime;

public record PedidoDto(

        @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
        @PastOrPresent(message = "A data de criação deve ser no passado ou no momento atual")
        LocalDateTime dtPedido,

        @Pattern(regexp = "^S|N$", message = "Só é possível valores 'S' ou 'N'")
        String flPgtoConfirmado,

        Integer usuario,
        Integer cliente
) {
}
