package exercicios_estrutura_de_controle_switch;

import java.util.Scanner;

public class Exercicio04 {
	/*
	 * Classificação de Notas: Dada uma nota de 0 a 10, 
	 * utilize switch para classificar a nota em conceitos 
	 * ('Excelente', 'Bom', 'Regular', 'Insuficiente'). 
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Digite a nota (0 a 10): ");
		double nota = sc.nextDouble();
		String conceito;

		switch ((int) nota) {
			case 10:
			case 9:
				conceito = "Excelente";
				break;
			case 8:
			case 7:
				conceito = "Bom";
				break;
			case 6:
			case 5:
				conceito = "Regular";
				break;
			case 4:
			case 3:
			case 2:
			case 1:
			case 0:
				conceito = "Insuficiente";
				break;
			default:
				conceito = "Nota inválida!";
		}
		System.out.println("Conceito: " + conceito);
		sc.close();
	}

}
