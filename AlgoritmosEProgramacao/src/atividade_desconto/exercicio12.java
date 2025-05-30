package atividade_desconto;

import java.util.Scanner;

public class exercicio12 {
	public static void main(String[] args) {
		// 12. Desenvolva um programa em Java que:
		// Leia o valor de um produto e a porcentagem de desconto usando Scanner;
		// Calcule o valor economizado e o valor final;
		// Exiba os dois valores formatados com duas casas decimais.
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Valor Bruto: R$ ");
		double valor = sc.nextDouble();
		
		System.out.println("Porcentagem de desconto: % ");
		double porcentagem = sc.nextDouble();
		double valorFinal = calcularDesconto(valor, porcentagem);
		
		System.out.printf("Valor Final: R$ %.2f%n", valorFinal);
		System.out.printf("Você economizou: R$ %.2f%n", valor - valorFinal);
		
		sc.close();
	}

	public static double calcularDesconto(double valor, double porcentagem) {
		return valor * (1 - (porcentagem / 100));
	}
}
