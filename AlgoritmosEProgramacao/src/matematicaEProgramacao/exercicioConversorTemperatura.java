package matematicaEProgramacao;

import java.util.Scanner;

public class exercicioConversorTemperatura {
//	Um aluno vai viajar para o Canadá e precisa entender como converter temperaturas. 
//	Vocês devem criar um sistema que converta Celsius para Fahrenheit e Kelvin, 
//	e também permita o caminho inverso.
	public static void main(String[] args) {
		iniciarConversor();
	}

	public static double lerDouble(String msg, Scanner sc) {
		System.out.print(msg + ": ");
		return sc.nextDouble();
	}

	public static void exibirMenu() {
		System.out.println("Menu de Conversão de Temperaturas:");
		System.out.println("1 - Celsius para Fahrenheit");
		System.out.println("2 - Fahrenheit para Celsius");
		System.out.println("3 - Celsius para Kelvin");
		System.out.println("4 - Kelvin para Celsius");
		System.out.println("5 - Sair");
	}

	public static void paraCelsius(String nome, Scanner sc) {
	    double temperatura = lerDouble("Temperatura em " + nome, sc);

	    if (nome.equals("Fahrenheit")) {
	        System.out.printf("%.2f graus Celsius%n", (temperatura - 32) * 5 / 9);
	    } else if (nome.equals("Kelvin")) {
	        System.out.printf("%.2f graus Celsius%n", (temperatura - 273.15));
	    }
	}

	public static void paraOutro(String nome, Scanner sc) {
	    double temperatura = lerDouble("Temperatura em Celsius", sc);

	    if (nome.equals("Fahrenheit")) {
	        System.out.printf("%.2f graus Fahrenheit%n", (temperatura * 9 / 5) + 32);
	    } else if (nome.equals("Kelvin")) {
	        System.out.printf("%.2f Kelvin%n", (temperatura + 273.15));
	    }
	}

	public static int escolheMenu(Scanner sc) {
		exibirMenu();
		System.out.print("Escolha uma opção: ");
		return sc.nextInt();
	}

	public static void realizarConversao(int op, Scanner sc) {
		switch (op) {
		case 1 -> paraOutro("Fahrenheit", sc);
		case 2 -> paraCelsius("Fahrenheit", sc);
		case 3 -> paraOutro("Kelvin", sc);
		case 4 -> paraCelsius("Kelvin", sc);
		case 5 -> System.out.println("Finalizado!");
		default -> System.out.println("Opção inválida.");
		// feito usando lambda
		}
	}

	public static void iniciarConversor() {
		Scanner sc = new Scanner(System.in);
		int op = 0;
		while (op != 5) {
			op = escolheMenu(sc);
			realizarConversao(op, sc);
		} ;
		sc.close();
	}
}
