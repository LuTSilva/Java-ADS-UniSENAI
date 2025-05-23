package exercicios_estrutura_de_repeticao_while;

import java.util.Scanner;

public class Exercicio03 {
	/*
	 * Jogo de Adivinhação: 
	 * Crie um jogo onde o usuário deve adivinhar um número entre 1 e 100. 
	 * Informe após cada tentativa se o número é maior ou menor 
	 * até que ele acere o número. 
	 * Dica: pesquise sobre a classe Random para sortear um número para ser adivinhado.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		int numeroAleatorio = (int) (Math.random() * 100) + 1; // Gera um número aleatório entre 1 e 100
		int palpite = 0;
		int tentativas = 0;
		System.out.println("Bem-vindo ao jogo de adivinhação!");
		System.out.println("Tente adivinhar o número entre 1 e 100.");

		while (palpite != numeroAleatorio) {
			System.out.print("Digite seu palpite: ");
			palpite = sc.nextInt();
			tentativas++;
			
			if (palpite < numeroAleatorio) {
				System.out.println("O número é maior. Tente novamente.");
			} else if (palpite > numeroAleatorio) {
				System.out.println("O número é menor. Tente novamente.");
			} else {
				System.out.println("Parabéns! Você adivinhou o número " + numeroAleatorio 
				+ " em " + tentativas + " tentativas!");
			}
		}
		System.out.println("Obrigado por jogar!");
		sc.close();
	}

}
