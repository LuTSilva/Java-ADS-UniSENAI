package exercicios_estrutura_de_controle_if;

import java.util.Scanner;

public class Exercicio07 {
	/*
	 * Análise de Temperatura: 
	 * Crie um algoritmo que leia a temperatura atual. 
	 * Se abaixo de 18°C, exiba "Frio", entre 18°C e 26°C mostre "Agradável", acima disso "Quente". 
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Informe a temperatura atual: ");
		double temp = sc.nextDouble();
		
		if (temp < 18) {
			System.out.println("Frio");
		} else if (temp <= 26) {
			System.out.println("Agradável");
		} else {
			System.out.println("Quente");
		}
		
		
		
		sc.close();

	}

}
