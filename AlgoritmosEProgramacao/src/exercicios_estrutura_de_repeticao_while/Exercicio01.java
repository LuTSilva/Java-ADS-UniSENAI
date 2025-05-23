package exercicios_estrutura_de_repeticao_while;

import java.util.Scanner;

public class Exercicio01 {
	/*
	 * Média de Idades Continuamente: 
	 * Leia uma quantidade indefinida de idades e calcule a média 
	 * até que uma idade negativa seja inserida.
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		int idade;
		int somaIdades = 0;
		int contador = 0;
		System.out.println("Digite a idade (ou uma idade negativa para encerrar): ");
		idade = sc.nextInt();
		while (idade >= 0) {
			somaIdades += idade;
			contador++;
			System.out.println("Digite a idade (ou uma idade negativa para encerrar): ");
			idade = sc.nextInt();
		}
		if (contador > 0) {
			double media = (double) somaIdades / contador;
			System.out.println("A média das idades é: " + media);
		} else {
			System.out.println("Nenhuma idade válida foi inserida.");
		}
		System.out.println("Programa finalizado.");
		sc.close();
	}

}
