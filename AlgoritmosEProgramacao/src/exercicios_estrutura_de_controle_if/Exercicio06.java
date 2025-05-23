package exercicios_estrutura_de_controle_if;

import java.util.Scanner;

public class Exercicio06 {
	/*
	 * Preço de Produto em Promoção: 
	 * Implemente um programa que leia o preço de um produto. 
	 * Se for superior a R$ 100,00, aplique desconto de 10%; senão, desconto de 5%. 
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Informe o preço do produto:");
		double preco = sc.nextDouble();
		
		if (preco > 100) {
			System.out.println("Desconto 10% aplicado!");
			preco *= 0.9;
		} else if (preco < 0) {
			System.out.println("Preço inválido!");
			preco = 0;
		} else {
			System.out.println("Desconto 5% aplicado!");
			preco *= 0.95;
		}
		
		System.out.printf("Preço final: R$ %.2f", preco);
		sc.close();

	}

}
