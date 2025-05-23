package exercicios_estrutura_de_repeticao_do_while;

import java.util.Scanner;

public class Exercicio02 {
	/*
	 * Validação de Entradas: 
	 * Peça para o usuário inserir números positivos. 
	 * Pare somente quando um número negativo for fornecido. 
	 * Ao final mostre a soma e a média dos números informados.
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		int numero;
		int soma = 0;
		int contador = 0;
		double media;
		do {
			System.out.println("Informe um número positivo (ou um número negativo para sair): ");
			numero = sc.nextInt();
			
			if (numero >= 0) {
				soma += numero;
				contador++;
			}
			
		} while (numero >= 0);
		if (contador > 0) {
			media = (double) soma / contador;
			System.out.println("A soma dos números informados é: " + soma);
			System.out.println("A média dos números informados é: " + media);
		} else {
			System.out.println("Nenhum número positivo foi informado.");
		}
		sc.close();
		
	}

}
