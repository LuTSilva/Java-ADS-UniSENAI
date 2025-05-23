package exercicios_estrutura_de_repeticao_while;

import java.util.Scanner;

public class Exercicio07 {
	/*
	 * Calcular Divisores de um Número: 
	 * Peça um número e mostre todos os seus divisores
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Digite um número: ");
		int numero = sc.nextInt();

		int i = 1;
		System.out.println("Os divisores de " + numero + " são: ");
		while (i <= numero) {
			if (numero % i == 0) {
				System.out.println(i);
			}
			i++;
		}
		sc.close();
	}

}
