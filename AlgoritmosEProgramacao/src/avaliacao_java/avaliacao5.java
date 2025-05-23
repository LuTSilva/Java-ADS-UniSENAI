package avaliacao_java;

import java.util.Scanner;

public class avaliacao5 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		double saldo = 0;
		int opcao = 0;
		int conta = 0;
		System.out.println("Informe o número da conta: ");
		conta = sc.nextInt();
		System.out.println("Informe o saldo atual da conta: ");
		saldo = sc.nextDouble();

		do {
			System.out.println("Escolha uma opção:");
			System.out.println("1 - Depositar");
			System.out.println("2 - Sacar");
			System.out.println("3 - Sair");
			opcao = sc.nextInt();
			
			switch (opcao) {
				case 1:
					System.out.println("Informe o valor a ser depositado: ");
					double valorDeposito = sc.nextDouble();
					saldo += valorDeposito;
					System.out.printf("Saldo antes do depósito: %.2f\n", saldo - valorDeposito);
					System.out.printf("Saldo após o depósito: %.2f\n", saldo);
					break;
				case 2:
					System.out.println("Informe o valor a ser sacado: ");
					double valorSaque = sc.nextDouble();
					if (valorSaque <= saldo) {
						saldo -= valorSaque;
						System.out.printf("Saldo antes do saque: %.2f\n", saldo + valorSaque);
						System.out.printf("Saldo após o saque: %.2f\n", saldo);
					} else {
						System.out.println("Saldo insuficiente, operação inválida!");
					}
					break;
				case 3:
					System.out.println("Saindo...");
					break;
				default:
					System.out.println("Opção inválida. Tente novamente.");
			}
			
		} while (opcao != 3);
		
		System.out.println("Conta: " + conta);
		System.out.printf("Saldo ao fim das operações: %.2f\n", saldo);
		sc.close();
	}

}
