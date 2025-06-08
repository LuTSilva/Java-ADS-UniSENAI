package avaliacao2_java;

import java.util.Scanner;

public class Avaliacao3 {
	// Enunciado 3: Cadastro de filmes
	// Uma locadora de filmes possui três categorias de filmes:
	// A – romance
	// B – Drama
	// C – Terror
	// Faça um programa que permita ao usuário cadastrar filmes apresentando um menu.
	// Quando o usuário desejar sair, mostre quantos filmes de cada categoria foram
	// cadastrados e o percentual de cada um deles em relação ao total.
	// O programa precisa ter no mínimo os seguintes métodos:
	// ● Escolher menu
	// ● Calcular percentual
	// ● Ler caractere
	// ● Exibir mensagem

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		exibeMenu();
		char opcao = lerChar(sc);
		double contadorA = 0;
		double contadorB = 0;
		double contadorC = 0;
		contabilizador(sc, opcao, contadorA, contadorB, contadorC);
		sc.close();
	}

	public static void contabilizador(Scanner sc, char opcao, double contadorA, double contadorB,
			double contadorC) {
		while (opcao != 'D') {
			exibeMenu();
			switch (opcao) {
			case 'A':
				System.out.println("romance");
				contadorA ++;
				opcao = lerChar(sc);
				break;
			case 'B':
				System.out.println("Drama");
				contadorB++;
				opcao = lerChar(sc);
				break;
			case 'C':
				System.out.println("Terror");
				contadorC++;
				opcao = lerChar(sc);
			default:
				System.out.println("Opção Inválida!");
			}
			exibeResultado(contadorA, contadorB, contadorC);
		}
	}
	public static double contadorGeral(double contadorA, double contadorB, double contadorC) {
		return contadorA + contadorB + contadorC;
	}

	public static void exibeResultado(double contadorA, double contadorB, double contadorC) {
		double contadorGeral = contadorGeral(contadorA, contadorB, contadorC);
		System.out.printf("Filmes cadastrados: %.0f\n", contadorGeral);
		System.out.printf("romance: %.2f\n", ((contadorA / contadorGeral) * 100));
		System.out.printf("Drama: %.2f\n", ((contadorB / contadorGeral) * 100));
		System.out.printf("Terror: %.2f\n", ((contadorC / contadorGeral) * 100));
	}

	public static void exibeMenu() {
		System.out.println("A - romance \nB - Drama \nC - Terror \nD - Sair");
		
	}
	public static char lerChar(Scanner sc) {
		return sc.next().charAt(0);
	}
}
