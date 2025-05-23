package exercicios_estrutura_de_repeticao_while;

import java.util.Scanner;

public class Exercicio05 {
	/*
	 * Médias de Temperaturas: 
	 * Leia uma série de temperaturas (até que o valor -100 seja digitado) 
	 * e mostre a média. 
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
	
		double temperatura = 0;
		double soma = 0;
		int contador = 0;
		
		while (temperatura != -100) {
			System.out.println(" Insira a próxima temperatura \n Para finalizar informe '-100'");
			temperatura = sc.nextDouble();
			if (temperatura != -100) {
				soma += temperatura;
				contador++;
			}
		}
		
		System.out.println("Media: " + (soma / contador));
		sc.close();
	}

}
