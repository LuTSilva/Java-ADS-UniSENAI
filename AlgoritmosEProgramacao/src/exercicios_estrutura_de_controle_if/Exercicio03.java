package exercicios_estrutura_de_controle_if;

import java.util.Scanner;

public class Exercicio03 {
	/*
	 * Identificação do Maior Número: Leia dois números reais e exiba o maior deles
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Informe o primeiro numero: ");
		double numero1 = sc.nextDouble();
		System.out.println("Informe o segundo numero: ");
		double numero2 = sc.nextDouble();
		double maior;
		
		if (numero1 > numero2) {
			maior = numero1;
		} else {
			maior = numero2;
		}
		

		System.out.println("O maior número é: " + maior);
		sc.close();
	}

}
