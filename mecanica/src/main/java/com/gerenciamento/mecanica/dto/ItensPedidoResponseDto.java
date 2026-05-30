package com.gerenciamento.mecanica.dto;

import com.gerenciamento.mecanica.model.ItensPedidoModel;

import java.math.BigDecimal;

public record ItensPedidoResponseDto(
        Integer cdItensPedido,
        Integer qtProduto,
        BigDecimal vlUnitario,
        BigDecimal vlSubtotal,
        ProdutoResumoDto produto,
        ServicoResumoDto servico
) {
    public record ProdutoResumoDto(Integer cdProduto, String nmProduto) {}
    public record ServicoResumoDto(Integer cdServico, String nmServico, BigDecimal vlServico) {}

    public static ItensPedidoResponseDto from(ItensPedidoModel item) {
        ProdutoResumoDto produto = item.getProduto() != null
                ? new ProdutoResumoDto(item.getProduto().getCdProduto(), item.getProduto().getNmProduto())
                : null;

        ServicoResumoDto servico = item.getServico() != null
                ? new ServicoResumoDto(item.getServico().getCdServico(), item.getServico().getNmServico(), item.getServico().getVlServico())
                : null;

        return new ItensPedidoResponseDto(
                item.getCdItensPedido(),
                item.getQtProduto(),
                item.getVlUnitario(),
                item.getVlSubtotal(),
                produto,
                servico
        );
    }
}