package exercicios_estrutura_de_controle_switch;

import java.util.Scanner;

public class Exercicio03 {
	/*
	 * Calculadora Básica: 
	 * Solicite dois números e a operação desejada (soma, subtração, multiplicação, divisão). 
	 * Use switch para realizar a operação e exibir o resultado. 
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Digite o primeiro número: ");
		double num1 = sc.nextDouble();
		System.out.println("Digite o segundo número: ");
		double num2 = sc.nextDouble();
		System.out.println("Escolha a operação desejada: \n"
				+ "1 - Soma\n"
				+ "2 - Subtração\n"
				+ "3 - Multiplicação\n"
				+ "4 - Divisão");
		int operacao = sc.nextInt();
		double resultado;
		
		switch (operacao) {
			case 1:
				resultado = num1 + num2;
				System.out.println("Resultado da soma: " + resultado);
				break;
			case 2:
				resultado = num1 - num2;
				System.out.println("Resultado da subtração: " + resultado);
				break;
			case 3:
				resultado = num1 * num2;
				System.out.println("Resultado da multiplicação: " + resultado);
				break;
			case 4:
				if (num2 != 0) {
					resultado = num1 / num2;
					System.out.println("Resultado da divisão: " + resultado);
				} else {
					System.out.println("Divisão por Zero não será aceita!");
				}
				break;
			default:
				System.out.println("Operação inválida!");
		}
		sc.close();
	}

}
