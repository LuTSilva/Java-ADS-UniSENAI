package avaliacao_3_java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class avaliacao1 {
static List<String> nomes = new ArrayList<>();
static double contadorADS = 0;
static double contadorOutros = 0;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int op;
		do {
			op = menu(sc);
			switch (op) {
				case 1 -> cadastrarAluno(sc);
				case 2 -> exibeMsg("Finalizando");
				default -> exibeMsg("Opção inválida");
			}
		listarTodos();
		} while (op != 2);
		sc.close();
	}
	public static int lerInt(String msg, Scanner sc) {
		System.out.print(msg);
		while (!sc.hasNextInt()) {
			sc.next();
			System.out.print("Entrada inválida. " + msg);
		}
		return sc.nextInt();
	}
	public static void exibeMsg(String msg) {
		System.out.println(msg);
	}
	public static void exibeMsg(String msg, Object... args) {
		System.out.printf(msg + "%n", args);
	}
	public static char lerChar(String msg, Scanner sc) {
		System.out.println(msg);
		return sc.next().toUpperCase().charAt(0);
	}

	public static String lerString(String msg, Scanner sc) {
		System.out.print(msg);
		return sc.nextLine();
	}
	public static void cadastrarAluno(Scanner sc) {
		sc.nextLine();
		String nome = lerString("Digite o nome do aluno: ", sc);
		char opcao = lerChar("Digite 'A' caso o aluno curse Análise e Desenvolvimento de Sistemas (ADS), \n"
				+ "digite outra letra caso seja outro curso! ", sc);
		if (opcao != 'A') {
			contadorOutros++;
		} else {
			contadorADS++;		
		}
		nomes.add(nome);
		exibeMsg("Aluno cadastrado com sucesso!");
	}
	public static int menu(Scanner sc) {
		exibeMsg("Menu:");
		exibeMsg("1 - Cadastrar aluno");
		exibeMsg("2 - Sair");
		return lerInt("Escolha uma opção: ", sc);
	}
	public static void listarTodos() {
		exibeMsg("Cursos cadastrados: %.0f\n", (contadorADS + contadorOutros));
		exibeMsg("Alunos que cursam ADS: %.2f\n", ((contadorADS / (contadorADS + contadorOutros)) * 100));
		exibeMsg("Alunos que cursam outros cursos: %.2f\n", ((contadorOutros / (contadorADS + contadorOutros)) * 100));
	}

}
