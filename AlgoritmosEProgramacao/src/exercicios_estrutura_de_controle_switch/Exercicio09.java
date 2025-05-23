package exercicios_estrutura_de_controle_switch;

import java.util.Scanner;

public class Exercicio09 {
	/*
	 * Sistema de Desconto por Categoria: 
	 * Dado um produto com categoria (A, B, C, D), aplique um desconto específico: 
	 * A (5%), B (10%), C (15%), D (20%). 
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Digite o valor do produto: ");
		double valorProduto = sc.nextDouble();
		System.out.println("Digite a categoria do produto (A, B, C, D): ");
		char categoria = sc.next().charAt(0);
		double valorFinal;

		switch (Character.toUpperCase(categoria)) {
			case 'A':
				valorFinal = valorProduto * 0.95;
				break;
			case 'B':
				valorFinal = valorProduto * 0.9;
				break;
			case 'C':
				valorFinal = valorProduto * 0.85;
				break;
			case 'D':
				valorFinal = valorProduto * 0.8;
				break;
			default:
				System.out.println("Categoria inválida!");
				sc.close();
				return; // Encerrar o programa se a categoria for inválida, saindo do método Main
		}
		System.out.println("Valor do produto após desconto: " + valorFinal);
		sc.close();
	}

}
