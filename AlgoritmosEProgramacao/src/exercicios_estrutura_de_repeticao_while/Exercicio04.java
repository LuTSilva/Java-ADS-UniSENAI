package exercicios_estrutura_de_repeticao_while;

import java.util.Scanner;

public class Exercicio04 {
	/*
	 * Sistema de Repetição de Instruções: 
	 * Implemente um loop contínuo que solicite ao usuário palavras. 
	 * Para cada palavra mostre ela de trás para frente. 
	 * Quando o usuário digitar 'sair' o programa deve ser encerrado. 
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		String palavra;
		System.out.println("Digite uma palavra (ou 'sair' para encerrar): ");
		palavra = sc.nextLine();
		while (!palavra.equalsIgnoreCase("sair")) {
			String palavraInvertida = "";
			for (int i = palavra.length() - 1; i >= 0; i--) {
				palavraInvertida += palavra.charAt(i);
			}
			System.out.println("A palavra \"" + palavra + "\" invertida é: " + palavraInvertida);
			System.out.println("Digite outra palavra (ou 'sair' para encerrar): ");
			palavra = sc.nextLine();
		}
		System.out.println("Programa encerrado.");
		sc.close();
	}
}
