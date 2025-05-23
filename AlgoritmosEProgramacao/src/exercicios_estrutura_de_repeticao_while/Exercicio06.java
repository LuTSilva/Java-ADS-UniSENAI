package exercicios_estrutura_de_repeticao_while;

import java.util.Scanner;

public class Exercicio06 {
	/*
	 * Contador de Vogais: 
	 * Mostre um menu com as opções 1 – digitar palavra e 2 – sair. 
	 * Na opção 1 leia uma palavra e conte quantas vogais ela possui. 
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		int opcao = 0;
		String palavra;
		int contador = 0;
		while (opcao != 2) {
			System.out.println("Menu: \n"
			+ "Escolha uma opção: \n"
			+ "1 - Digitar palavra \n"
			+ "2 - Sair");
			opcao = sc.nextInt();
			
			if (opcao == 1) {
				System.out.print("Digite uma palavra: ");
				palavra = sc.next();
				
				for (int i = 0; i < palavra.length(); i++) {
					char letra = palavra.charAt(i);
					if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u' ||
						letra == 'A' || letra == 'E' || letra == 'I' || letra == 'O' || letra == 'U') {
						contador++;
					}
				}
				System.out.println("A palavra \"" + palavra + "\" possui " + contador + " vogais.");
				contador = 0; // Resetar contador para a próxima palavra
			} else if (opcao != 2) {
				System.out.println("Opção inválida. Tente novamente.");
			}
		}
		System.out.println("Saindo do programa...");
		sc.close();
	}

}
