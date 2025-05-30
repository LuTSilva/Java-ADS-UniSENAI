package atividade_desconto;

public class exercicio17 {
	public static void main(String[] args) {
		// 17. Um notebook de R$2.000,00 está com uma promoção de 
		// três descontos sucessivos: 10%, 5% e 2%.
		// Escreva um programa em Java que calcule e exiba 
		// o valor final do produto após todos os descontos aplicados em ordem.
		
		double valor = 2000;
		double desconto1 = 10;
		double desconto2 = 5;
		double desconto3 = 2;
		
		double valorFinal = calcularDesconto(valor, desconto1);
		valorFinal = calcularDesconto(valorFinal, desconto2);
		valorFinal = calcularDesconto(valorFinal, desconto3);
		
		System.out.printf("Valor Final: R$ %.2f%n", valorFinal);
		}
		public static double calcularDesconto(double valorOriginal, double desconto1) {
		return valorOriginal * (1 - (desconto1 / 100));
		}

}
