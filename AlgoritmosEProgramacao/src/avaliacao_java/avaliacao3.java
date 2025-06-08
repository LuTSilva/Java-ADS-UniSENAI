package avaliacao_java;

import java.util.Scanner;

public class avaliacao3 {

	// Uma locadora de filmes possui três categorias de filmes (A – romance, B – Drama, C – Terror). 
	// Faça um programa que permita ao usuário cadastrar filmes utilizando a estrutura “WHILE” e apresentando um menu. 
	// Quando o usuário desejar sair, mostre quantos filmes de cada categoria foram cadastrados 
	// e o percentual de cada um deles em relação ao total
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String menu = "A - romance \nB - Drama \nC - Terror \nD - Sair";
		System.out.println(menu);
		char opcao = sc.next().charAt(0);
		
		int contadorA = 0;
		int contadorB = 0;
		int contadorC = 0;
		
		while (opcao != 'D') {
			System.out.println(menu);
			switch (opcao) {
			case 'A':
				System.out.println("romance");
				contadorA ++;
				opcao = sc.next().charAt(0);
				break;
			case 'B':
				System.out.println("Drama");
				contadorB++;
				opcao = sc.next().charAt(0);
				break;
			case 'C':
				System.out.println("Terror");
				contadorC++;
				opcao = sc.next().charAt(0);
			default:
				System.out.println("Opção Inválida!");
			}
			
			double contadorTotal = contadorA + contadorB + contadorC;
			System.out.printf("Filmes cadastrados: %.0f\n", contadorTotal);
			System.out.printf("romance: %.2f\n", ((contadorA / contadorTotal) * 100));
			System.out.printf("Drama: %.2f\n", ((contadorB / contadorTotal) * 100));
			System.out.printf("Terror: %.2f\n", ((contadorC / contadorTotal) * 100));
		}
		sc.close();
	}

}
