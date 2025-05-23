package exercicios_estrutura_de_repeticao_do_while;

import java.util.Scanner;

public class Exercicio03 {
	/*
	 * Cálculo Contínuo de Fatorial: 
	 * Permita calcular o fatorial de vários números até que o usuário deseje parar,
	 * respondendo "não" para a continuação. 
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in, "UTF-8");
		
		int numero;
		int fatorial;
		String continuar;

		do {
			System.out.println("Informe um número para calcular o fatorial: ");
			numero = sc.nextInt();
			
			fatorial = 1;
			for (int i = 1; i <= numero; i++) {
				fatorial *= i;
			}
			
			System.out.println("O fatorial de " + numero + " é: " + fatorial);
			
			System.out.println("Deseja calcular o fatorial de outro número? informe 'nao' para parar: ");
			continuar = sc.next().trim();
			
		} while (!continuar.equalsIgnoreCase("nao" ));
		System.out.println("Programa encerrado.");
		sc.close();
	}

}
