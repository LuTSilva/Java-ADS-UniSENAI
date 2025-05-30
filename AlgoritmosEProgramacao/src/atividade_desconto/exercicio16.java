package atividade_desconto;

public class exercicio16 {
	public static void main(String[] args) {
		// 16. Um servidor custa R$5.000,00. Ele está com dois descontos sucessivos: 
		// o primeiro de 15% e o segundo de 10%.
		// Implemente um programa em Java que calcule e exiba o valor final do servidor 
		// após os dois descontos aplicados em sequência.
		
		double valor = 5000;
		double desconto1 = 15;
		double desconto2 = 10;
		
		double valorFinal = calcularDesconto(valor, desconto1);
		valorFinal = calcularDesconto(valorFinal, desconto2);
		
		System.out.printf("Valor Final: R$ %.2f%n", valorFinal);
	}

	public static double calcularDesconto(double valorOriginal, double desconto) {
		return valorOriginal * (1 - (desconto / 100));
	}
}