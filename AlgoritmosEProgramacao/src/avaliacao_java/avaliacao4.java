package avaliacao_java;

import java.util.Scanner;
	// Utilizando a estrutura de repetição “FOR”, crie um programa em Java que leia 
	// a altura (em cm) de N pessoas. No final, exiba a média das alturas

public class avaliacao4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Informe o número N: ");
		int n = sc.nextInt();
		int altura = 0;
		int soma = 0;
		
		for (int i = 1; i <= n; i++) {
			System.out.println("Informe a próxima altura (em cm): ");
			altura = sc.nextInt();
			soma += altura;
		}
		System.out.println("Media: " + (soma / n));
		
		sc.close();
	}

}
