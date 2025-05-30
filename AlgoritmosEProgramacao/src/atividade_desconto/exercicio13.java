package atividade_desconto;

import java.util.Scanner;

public class exercicio13 {
	public static void main(String[] args) {
		// 13. Utilizando Scanner, peça ao usuário para digitar o valor de um produto e a porcentagem de desconto.
		// Em seguida, mostre na tela o valor final do produto após a aplicação do desconto, 
		// com formatação de duas casas decimais.

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Valor Bruto: R$ ");
		double valor = sc.nextDouble();
		
		System.out.println("Porcentagem de desconto: % ");
		double porcentagem = sc.nextDouble();
		double valorFinal = calcularDesconto(valor, porcentagem);
		
		System.out.printf("Valor Final: R$ %.2f%n", valorFinal);
		
		sc.close();
	}

	public static double calcularDesconto(double valor, double porcentagem) {
		return valor * (1 - (porcentagem / 100));
	}
}