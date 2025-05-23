package exercicios_estrutura_de_repeticao_for;

import java.util.Scanner;

public class Exercicio07 {
	/*
	 * Fatorial de N: Calcule o fatorial de N, onde N é fornecido pelo usuário. 
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Informe o número N: ");
		int n = sc.nextInt();
		int fatorial = 1;
		for (int i = 1; i <= n; i++) {
			fatorial *= i;
		}
		System.out.println("O fatorial de " + n + " é: " + fatorial);
		sc.close();
	}

}
