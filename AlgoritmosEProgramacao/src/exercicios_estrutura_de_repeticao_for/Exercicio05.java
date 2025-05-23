package exercicios_estrutura_de_repeticao_for;

import java.util.Scanner;

public class Exercicio05 {
	/*
	 *  Soma de Pares e Ímpares: 
	 *  Solicite N números do usuário e calcule a soma de números pares
	 *   e a soma de ímpares separadamente. 
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Informe a quantidade de números que deseja informar: ");
		int n = sc.nextInt();
		int somaPares = 0;
		int somaImpares = 0;
		for (int i = 1; i <= n; i++) {
			System.out.println("Informe o número " + i + ": ");
			int numero = sc.nextInt();
			if (numero % 2 == 0) {
				somaPares += numero;
			} else {
				somaImpares += numero;
			}
		}
		System.out.println("A soma dos números pares é: " + somaPares);
		System.out.println("A soma dos números ímpares é: " + somaImpares);
		sc.close();
	}

}
