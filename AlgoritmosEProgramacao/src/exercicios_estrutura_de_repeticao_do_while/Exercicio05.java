package exercicios_estrutura_de_repeticao_do_while;

import java.util.Scanner;

public class Exercicio05 {
	/*
	 * Teste de Palíndromo: 
	 * Solicite palavras ao usuário e informe se são palíndromas, 
	 * até que seja digitada a palavra "fim". 
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		String palavra;
		String palavraInvertida;

		do {
			System.out.println("Informe uma palavra (ou 'fim' para sair): ");
			palavra = sc.nextLine();
			
			if (!palavra.equalsIgnoreCase("fim")) {
				palavraInvertida = new StringBuilder(palavra).reverse().toString();
				
				if (palavra.equalsIgnoreCase(palavraInvertida)) {
					System.out.println("A palavra \"" + palavra + "\" é um palíndromo.");
				} else {
					System.out.println("A palavra \"" + palavra + "\" não é um palíndromo.");
				}
			}
			
		} while (!palavra.equalsIgnoreCase("fim"));
		System.out.println("Programa encerrado.");
		sc.close();
	}

}
