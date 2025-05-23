package exercicios_estrutura_de_controle_if;

import java.util.Scanner;

public class Exercicio08 {
	/*
	 * Verificador de Par e Ímpar: 
	 * Peça ao usuário para inserir um número inteiro e exiba 
	 * se o número é par ou ímpar. 
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Informe o número: ");
		int numero = sc.nextInt();
		
		if (numero % 2 != 0) {
			System.out.println("Numero Impar!");
		} else {
			System.out.println("Numero Par!");
		}
		
		
		sc.close();

	}

}
