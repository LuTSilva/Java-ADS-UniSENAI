package atividade_desconto;

import java.util.Scanner;

public class exercicio14 {
	public static void main(String[] args) {
		// 14. Implemente uma função em Java chamada aplicarDesconto que receba dois
		// parâmetros (valor e taxaDeDesconto)
		// e retorne o valor final com o desconto aplicado.
		// Use a função dentro do main para exibir o resultado com um valor de exemplo.
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Valor Bruto: R$ ");
		double valor = sc.nextDouble();
		
		System.out.println("Porcentagem de desconto: % ");
		double porcentagem = sc.nextDouble();
		double valorFinal = aplicarDesconto(valor, porcentagem);
		
		System.out.printf("Valor Final: R$ %.2f%n", valorFinal);
		
		sc.close();
	}

	public static double aplicarDesconto(double valor, double taxaDeDesconto) {
		return valor * (1 - (taxaDeDesconto / 100));
	}
}