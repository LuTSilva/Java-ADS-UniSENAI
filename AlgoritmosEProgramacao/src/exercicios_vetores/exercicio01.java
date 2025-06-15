package exercicios_vetores;

import java.util.Scanner;

public class exercicio01 {
//	Exercício 1 - Faça um programa que o usuário informe 5 cores e
//	armazene em um vetor.
//	Por exemplo:
//	Preto – Branco – Azul – Vermelho – Amarelo
//	Após o cadastro, o programa deve exibir as cores na ordem inversa:
//	Amarelo – Vermelho – Azul – Branco – Preto

static String[] cores = new String[5];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		cadastrarCores(sc);
		exibirCoresInverso();
		sc.close();
		
	}
	public static void cadastrarCores(Scanner sc) {
		exibeMsg("Informe 5 cores:");
		for (int i = 0; i < cores.length; i++) {
			exibeMsg("Cor " + (i + 1) + ": ");
			cores[i] = sc.nextLine();
		}
	}
	public static void exibirCoresInverso() {
		exibeMsg("Cores na ordem inversa:");
		for (int i = cores.length - 1; i >= 0; i--) {
			exibeMsg(cores[i]);
		}
	}
	public static void exibeMsg(String msg) {
		System.out.println(msg);
	}
	public static void exibeMsg(String msg, Object... args) {
		System.out.printf(msg, args);
		System.out.println();
	}
}
