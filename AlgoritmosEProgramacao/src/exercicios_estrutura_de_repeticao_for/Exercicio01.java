package exercicios_estrutura_de_repeticao_for;

import java.util.Scanner;

public class Exercicio01 {
	/*
	 * Sequência Numérica Simples: 
	 * imprima os números de 1 a 100 um ao lado do outro separados por espaço. 
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Os números de 1 a 100 são: ");
		for (int i = 1; i <= 100; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		sc.close();
	}

}
