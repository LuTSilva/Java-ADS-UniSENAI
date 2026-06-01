package com.gerenciamento.mecanica.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record PagamentoDto(

        @NotBlank(message = "A forma de pagamento é obrigatória")
        @Pattern(
                regexp = "^DINHEIRO|PIX|CARTAO_CREDITO|CARTAO_DEBITO$",
                message = "Forma de pagamento inválida. Use: DINHEIRO, PIX, CARTAO_CREDITO ou CARTAO_DEBITO"
        )
        String formaPagamento,

        @NotNull(message = "O valor do pagamento é obrigatório")
        @Positive(message = "O valor do pagamento deve ser positivo")
        BigDecimal vlPagamento
) {
}