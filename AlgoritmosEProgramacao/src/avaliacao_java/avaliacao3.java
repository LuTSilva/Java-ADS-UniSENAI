package avaliacao_java;

import java.util.Scanner;

public class avaliacao3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String menu = "A - romance \nB - Drama \nC - Terror \nD - Sair";
		System.out.println(menu);
		char opcao = sc.next().charAt(0);
		double contadorGeral = 0;
		double contadorA = 0;
		double contadorB = 0;
		double contadorC = 0;
		while (opcao != 'D') {
			System.out.println(menu);
			switch (opcao) {
			case 'A':
				System.out.println("romance");
				contadorGeral ++;
				contadorA ++;

				System.out.println("Informe a próxima opção: ");
				opcao = sc.next().charAt(0);
				break;
			case 'B':
				System.out.println("Drama");
				contadorGeral++;
				contadorB++;

				System.out.println("Informe a próxima opção: ");
				opcao = sc.next().charAt(0);
				break;
			case 'C':
				System.out.println("Terror");
				contadorGeral++;
				contadorC++;

				System.out.println("Informe a próxima opção: ");
				opcao = sc.next().charAt(0);
			default:
				System.out.println("Opção Inválida!");
			}
			System.out.printf("Filmes cadastrados: %.0f\n", contadorGeral);
			System.out.printf("romance: %.2f\n", ((contadorGeral - (contadorB + contadorC)) / contadorGeral) * 100);
			System.out.printf("Drama: %.2f\n", ((contadorGeral - (contadorA + contadorC)) / contadorGeral) * 100);
			System.out.printf("Terror: %.2f\n", ((contadorGeral - (contadorA + contadorB)) / contadorGeral) * 100);
		}
		sc.close();
	}

}
