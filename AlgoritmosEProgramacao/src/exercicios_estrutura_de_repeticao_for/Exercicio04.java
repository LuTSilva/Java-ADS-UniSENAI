package exercicios_estrutura_de_repeticao_for;

import java.util.Scanner;

public class Exercicio04 {
	/*
	 * Números em Ordem Decrescente: Exiba os números inteiros de 100 a 1. 
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Os números inteiros de 100 a 1 são: ");
		for (int i = 100; i >= 1; i--) {
			System.out.println(i);
		}
		sc.close();
	}

}
