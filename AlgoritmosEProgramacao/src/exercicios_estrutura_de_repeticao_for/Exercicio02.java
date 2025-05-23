package exercicios_estrutura_de_repeticao_for;

import java.util.Scanner;

public class Exercicio02 {
	/*
	 * Cálculo da Soma de Sequência: 
	 * Calcule e exiba a soma de todos os números de 1 a N, 
	 * onde N é fornecido pelo usuário.
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Informe o número N: ");
		int n = sc.nextInt();
		int soma = 0;
		
		for (int i = 1; i <= n; i++) {
			soma += i;
		}
		System.out.println("A soma de todos os números de 1 a " + n + " é: " + soma);
		sc.close();
	}

}
