package exercicios_estrutura_de_repeticao_do_while;

import java.util.Scanner;

public class Exercicio04 {
	/*
	 * Calculadora: Exiba um menu de operações (soma, subtração, multiplicação, divisão)
	 *  e permita múltiplas operações até que o usuário escolha "sair".
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		String menu = "1 - Soma \n"
				+ "2 - Subtração \n"
				+ "3 - Multiplicação \n"
				+ "4 - Divisão \n"
				+ "5 - Sair";
		
		int op = 0;
		
		do {
			System.out.println(menu);
			op = sc.nextInt();
			switch(op) {
			case 1:
				System.out.println("Informe o primeiro numero: ");
				int n1 = sc.nextInt();
				System.out.println("Informe o segundo numero: ");
				int n2 = sc.nextInt();
				System.out.println("A soma é " + (n1 + n2));
				break;
			
			case 2:
				System.out.println("Informe o primeiro numero: ");
				n1 = sc.nextInt();
				System.out.println("Informe o segundo numero: ");
				n2 = sc.nextInt();
				System.out.println("A subtração é " + (n1 - n2));
				break;
			case 3:
				System.out.println("Informe o primeiro numero: ");
				n1 = sc.nextInt();
				System.out.println("Informe o segundo numero: ");
				n2 = sc.nextInt();
				System.out.println("A multiplicação é " + (n1 * n2));
				break;
			case 4:
				System.out.println("Informe o primeiro numero: ");
				n1 = sc.nextInt();
				System.out.println("Informe o segundo numero: ");
				n2 = sc.nextInt();
				System.out.println("A divisão é " + (n1 / n2));
				break;
			}
		} while (op != 5);
		
		sc.close();
	}

}
