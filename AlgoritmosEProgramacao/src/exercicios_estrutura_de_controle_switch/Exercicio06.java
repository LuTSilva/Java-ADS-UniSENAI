package exercicios_estrutura_de_controle_switch;

import java.util.Scanner;

public class Exercicio06 {
	/*
	 * Sistema de Mensagens de Estações: 
	 * Insira um número associado a uma estação do ano (1-4) 
	 * e mostre a estação correspondente e uma mensagem. 
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Digite o número da estação do ano (1-4): ");
		int estacao = sc.nextInt();
		String mensagem = "";
		switch (estacao) {
			case 1:
				mensagem = "Verão: Tempo quente e com sol.";
				break;
			case 2:
				mensagem = "Outono: Folhas caindo e clima ameno.";
				break;
			case 3:
				mensagem = "Inverno: Frio e possibilidade de neve.";
				break;
			case 4:
				mensagem = "Primavera: Florescendo e clima agradável.";
				break;
			default:
				System.out.println("Número inválido.");
		}

		if (!mensagem.isEmpty()) {
			System.out.println(mensagem);
		}
		sc.close();
	}

}
