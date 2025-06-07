package exercicios_metodos;

import java.util.Scanner;

public class Exercicio01 {
	public static void main(String[] args) {
		// 1 - Calculadora Simples: Implemente métodos para as 4 operações básicas e um
		// menu onde o usuário pode escolher qual operação deseja realizar até que saia
		// da aplicação.

		Scanner sc = new Scanner(System.in);
		int opcao;
		
		do {
			opcao = menu(sc);
			switch(opcao) {
			case 1 -> System.out.printf("Resultado: %.2f%n", 
			soma(lerDouble("Numero 1: ", sc), lerDouble("Numero 2: ", sc)));
			case 2 -> System.out.printf("Resultado: %.2f%n", 
			subtracao(lerDouble("Numero 1: ", sc), lerDouble("Numero 2: ", sc)));
			case 3 -> System.out.printf("Resultado: %.2f%n", 
			multiplicacao(lerDouble("Numero 1: ", sc), lerDouble("Numero 2: ", sc)));
			case 4 -> System.out.printf("Resultado: %.2f%n", 
			divisao(lerDouble("Numero 1: ", sc), lerDouble("Numero 2: ", sc)));
			case 5 -> System.out.println("Saindo da calculadora...");
			default -> System.out.println("Opção Inválida!");
			}
		} while (opcao !=5);
		sc.close();
	}

	public static double soma(double a, double b) {
		return a + b;
	}

	public static double subtracao(double a, double b) {
		return a - b;
	}

	public static double multiplicacao(double a, double b) {
		return a * b;
	}

	public static double divisao(double a, double b) {
		if (b == 0) {
			System.out.println("Erro: Divisão por zero não é permitida.");
			return Double.NaN; // Retorna NaN (Not a Number) para indicar erro
		}
		return (double) a / b;
	}

	public static int menu(Scanner sc) {
		System.out.println("Escolha uma operação: \n"
				+ "1 - Soma \n"
				+ "2 - Subtração \n"
				+ "3 - Multiplicação \n"
				+ "4 - Divisão \n"
				+ "5 - Sair \n");
		return sc.nextInt();
	}
	
	public static double lerDouble(String msg, Scanner sc) {
		System.out.print(msg);
		return sc.nextDouble();
	}
}