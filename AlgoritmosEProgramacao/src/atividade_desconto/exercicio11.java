package atividade_desconto;

public class exercicio11 {
// 11. Crie uma função em Java chamada calcularDesconto que receba dois parâmetros:
// o valor original de um produto e o percentual de desconto.
// A função deve retornar o valor final com o desconto aplicado.

	public static double calcularDesconto(double valorOriginal, double percentualDesconto) {
		return valorOriginal * (1 - (percentualDesconto / 100));
	}
}
