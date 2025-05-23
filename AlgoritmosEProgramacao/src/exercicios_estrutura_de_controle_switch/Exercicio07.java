package exercicios_estrutura_de_controle_switch;

import java.util.Scanner;

public class Exercicio07 {
	/*
	 * Verificação de Número do Mês: 
	 * Dado um mês por extenso, retorne o número correspondente ao mês usando switch.
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Digite o nome do mês: ");
		String mes = sc.nextLine();
		int numeroMes = 0;
		switch (mes.toLowerCase()) {
			case "janeiro":
				numeroMes = 1;
				break;
			case "fevereiro":
				numeroMes = 2;
				break;
			case "março":
				numeroMes = 3;
				break;
			case "abril":
				numeroMes = 4;
				break;
			case "maio":
				numeroMes = 5;
				break;
			case "junho":
				numeroMes = 6;
				break;
			case "julho":
				numeroMes = 7;
				break;
			case "agosto":
				numeroMes = 8;
				break;
			case "setembro":
				numeroMes = 9;
				break;
			case "outubro":
				numeroMes = 10;
				break;
			case "novembro":
				numeroMes = 11;
				break;
			case "dezembro":
				numeroMes = 12;
				break;
			default:
				System.out.println("Mês inválido.");
		}
		
		if (numeroMes != 0) {
			System.out.println("O número do mês " + mes + " é: " + numeroMes);
		}
		sc.close();
	}

}
