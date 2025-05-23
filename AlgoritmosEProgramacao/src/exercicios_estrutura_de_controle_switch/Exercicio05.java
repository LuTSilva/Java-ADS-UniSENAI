package exercicios_estrutura_de_controle_switch;

import java.util.Scanner;

public class Exercicio05 {
	/*
	 * Reconhecimento de Dia da Semana: 
	 * Leia um número de 1 a 7 e exiba qual o dia correspondente da semana (domingo a sábado). 
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Digite um número de 1 a 7: ");
		int dia = sc.nextInt();
		String diaDaSemana = "";

		switch (dia) {
			case 1:
				diaDaSemana = "Domingo";
				break;
			case 2:
				diaDaSemana = "Segunda-feira";
				break;
			case 3:
				diaDaSemana = "Terça-feira";
				break;
			case 4:
				diaDaSemana = "Quarta-feira";
				break;
			case 5:
				diaDaSemana = "Quinta-feira";
				break;
			case 6:
				diaDaSemana = "Sexta-feira";
				break;
			case 7:
				diaDaSemana = "Sábado";
				break;
			default:
				System.out.println("Número inválido.");
		}

		if (!diaDaSemana.isEmpty()) {
			System.out.println("O dia correspondente é: " + diaDaSemana);
		}
		sc.close();
	}

}
