package exercicios_estrutura_de_repeticao_for;

import java.util.Scanner;

public class Exercicio09 {
	/*
	 * Cálculo de Potência: 
	 * Utilize “for” para calcular a potência de um número A elevado a B.
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Informe o número A: ");
		int a = sc.nextInt();

		System.out.println("Informe o número B: ");
		int b = sc.nextInt();

		int resultado = 1;
		for (int i = 0; i < b; i++) {
			resultado *= a;
		}
		System.out.println("O resultado de " + a + " elevado a " + b + " é: " + resultado);
		sc.close();
	}
}