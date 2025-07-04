package avaliacao_3_java;

import java.util.Scanner;

public class avaliacao3 {
	public static void main(String[] args) {
		// Faça um algoritmo para ler o saldo atual de uma conta bancária. Após,
		// exiba um menu onde o usuário possa fazer depósitos ou retiradas. Para cada
		// operação exiba o saldo remanescente. Observação: Somente podem ser feitas
		// retiradas se possuir saldo.
		// **Utilize o máximo que conseguir de modularização

		Scanner sc = new Scanner (System.in);

		double saldo = lerDouble("Informe o saldo atual da conta: ", sc);
		operadorBancario(saldo, sc);
		
		sc.close();
	}
	public static void operadorBancario(double saldo, Scanner sc) {
		int opcao;
		do {
			menu();
			opcao = lerInt("Informe a opção desejada: ", sc);
			saldo = operacoesBancarias(saldo, opcao, sc);
		} while (opcao != 3);
	}
	public static void menu() {
		exibeMsg("Escolha uma opção:");
		exibeMsg("1 - Depositar");
		exibeMsg("2 - Sacar");
		exibeMsg("3 - Sair");
	}
	public static double operacoesBancarias(double saldo, int opcao, Scanner sc) {
		switch(opcao) {
			case 1 -> {
				double valorDeposito = lerDouble("Informe o valor a ser depositado: ", sc);
				saldo += valorDeposito;
				exibeMsg("Saldo antes do depósito: %.2f\n", saldo - valorDeposito);
				exibeMsg("Saldo após o depósito: %.2f\n", saldo);
                }
			case 2 -> {
				double valorSaque = lerDouble("Informe o valor a ser sacado: ", sc);
				saldo = validadorSaque(saldo, valorSaque);
                }
			case 3 -> exibeMsg("Saindo...");
			default -> exibeMsg("Opção inválida. Tente novamente.");
		}
		return saldo;
	}
	private static double validadorSaque(double saldo, double valorSaque) {
		if (valorSaque <= saldo) {
			saldo -= valorSaque;
			exibeMsg("Saldo antes do saque: %.2f\n", saldo + valorSaque);
			exibeMsg("Saldo após o saque: %.2f\n", saldo);
		} else {
			exibeMsg("Saldo insuficiente, operação inválida!");
		}
		return saldo;
	}
	public static double lerDouble(String msg, Scanner sc) {
		System.out.print(msg);
		while (!sc.hasNextDouble()) { 
			sc.next(); 
			System.out.print("Entrada inválida. " + msg);
		}
		return sc.nextDouble();
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
}