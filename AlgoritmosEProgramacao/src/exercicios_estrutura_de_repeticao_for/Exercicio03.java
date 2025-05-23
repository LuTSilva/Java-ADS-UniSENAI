package exercicios_estrutura_de_repeticao_for;

import java.util.Scanner;

public class Exercicio03 {
	/*
	 * Tabuada: Mostre na tela a tabuada do 1 ao 10. 
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Tabuada do 1 ao 10: ");
		for (int i = 1; i <= 10; i++) {
			System.out.println("Tabuada do " + i + ":");
			for (int j = 1; j <= 10; j++) {
				System.out.println(i + " x " + j + " = " + (i * j));
			}
			System.out.println();
		}
		sc.close();
	}

}
