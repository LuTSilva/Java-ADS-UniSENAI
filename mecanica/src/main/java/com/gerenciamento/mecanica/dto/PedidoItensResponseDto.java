package com.gerenciamento.mecanica.dto;

import java.math.BigDecimal;
import java.util.List;

public record PedidoItensResponseDto(
        Integer cdPedido,
        BigDecimal vlTotal,
        List<ItensPedidoResponseDto> itens
) {}