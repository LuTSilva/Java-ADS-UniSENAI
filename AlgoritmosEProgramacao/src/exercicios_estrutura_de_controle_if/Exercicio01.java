package exercicios_estrutura_de_controle_if;

import java.util.Scanner;

public class Exercicio01 {
	/*
	 * Desconto Progressivo em Mercadoria: Dado o preço de um produto, aplique um desconto de 10% 
	 * se o preço for superior a R$10,00 e 5% caso contrário. Exiba o preço final.
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		System.out.println("Informe o preço do produto:");
		double preco = sc.nextDouble();
		
		if (preco > 10) {
			System.out.println("Desconto 10% Aplicado!");
			preco *= 0.9;
		} else if (preco <= 0) {
			System.out.println("Preço Inválido!");
			preco = 0;
		} else {
			System.out.println("Desconto 5% Aplicado!");
			preco *= 0.95;
		}
		System.out.printf("Preço Final: R$ %.2f", preco);
		
		sc.close();
	}

}
