package exercicios_estrutura_de_repeticao_for;

import java.util.Scanner;

public class Exercicio06 {
	/*
	 * Quadrados dos Números Inteiros: 
	 * Leia um número N e imprima os quadrados de 1 a N. 
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Informe o número N: ");
		int n = sc.nextInt();
		System.out.println("Os quadrados de 1 a " + n + " são: ");
		for (int i = 1; i <= n; i++) {
			System.out.println(i + "² = " + (i * i));
		}
		sc.close();
	}

}
