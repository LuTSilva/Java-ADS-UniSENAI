package exercicios_estrutura_de_controle_switch;

import java.util.Scanner;

public class Exercicio10 {
	/*
	 * Reconhecimento de Símbolo Matemático: 
	 * Peça dois números, um caracter matemático (+, -, *, /) e 
	 * informe o nome da operação que ele representa e o resultado da operação.
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Digite o primeiro número: ");
		double num1 = sc.nextDouble();
		System.out.println("Digite o segundo número: ");
		double num2 = sc.nextDouble();
		System.out.println("Escolha a operação desejada: \n"
				+ "+\n"
				+ "-\n"
				+ "*\n"
				+ "/");
		char operacao = sc.next().charAt(0);
		double resultado;
		String nomeOperacao;

		switch (operacao) {
			case '+':
				resultado = num1 + num2;
				nomeOperacao = "Soma";
				break;
			case '-':
				resultado = num1 - num2;
				nomeOperacao = "Subtração";
				break;
			case '*':
				resultado = num1 * num2;
				nomeOperacao = "Multiplicação";
				break;
			case '/':
				if (num2 != 0) {
					resultado = num1 / num2;
					nomeOperacao = "Divisão";
				} else {
					System.out.println("Divisão por Zero não será aceita!");
					sc.close();
					return; // Encerrar o programa se a divisão for inválida
				}
				break;
			default:
				System.out.println("Operação inválida!");
				sc.close();
				return; // Encerrar o programa se a operação for inválida
		}
		System.out.println("Resultado da " + nomeOperacao + ": " + resultado);
		sc.close();
	}

}
