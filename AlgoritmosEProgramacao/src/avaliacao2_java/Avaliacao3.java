package avaliacao2_java;

import java.util.Scanner;

public class Avaliacao3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		exibeMenu();
		char opcao = sc.next().charAt(0);
		double contadorGeral = 0;
		double contadorA = 0;
		double contadorB = 0;
		double contadorC = 0;
		contabilizador(sc, opcao, contadorGeral, contadorA, contadorB, contadorC);
		sc.close();
	}

	public static void contabilizador(Scanner sc, char opcao, double contadorGeral, double contadorA, double contadorB,
			double contadorC) {
		while (opcao != 'D') {
			exibeMenu();
			switch (opcao) {
			case 'A':
				System.out.println("romance");
				contadorGeral ++;
				contadorA ++;

				System.out.println("Informe a próxima opção: ");
				opcao = lerChar(sc);
				break;
			case 'B':
				System.out.println("Drama");
				contadorGeral++;
				contadorB++;

				System.out.println("Informe a próxima opção: ");
				opcao = lerChar(sc);
				break;
			case 'C':
				System.out.println("Terror");
				contadorGeral++;
				contadorC++;

				System.out.println("Informe a próxima opção: ");
				opcao = lerChar(sc);
			default:
				System.out.println("Opção Inválida!");
			}
			exibeResultado(contadorGeral, contadorA, contadorB, contadorC);
		}
	}

	public static void exibeResultado(double contadorGeral, double contadorA, double contadorB, double contadorC) {
		System.out.printf("Filmes cadastrados: %.0f\n", contadorGeral);
		System.out.printf("romance: %.2f\n", ((contadorGeral - (contadorB + contadorC)) / contadorGeral) * 100);
		System.out.printf("Drama: %.2f\n", ((contadorGeral - (contadorA + contadorC)) / contadorGeral) * 100);
		System.out.printf("Terror: %.2f\n", ((contadorGeral - (contadorA + contadorB)) / contadorGeral) * 100);
	}

	public static void exibeMenu() {
		System.out.println("A - romance \nB - Drama \nC - Terror \nD - Sair"); ;
		
	}
	public static char lerChar(Scanner sc) {
		return sc.next().charAt(0);
	}
}
