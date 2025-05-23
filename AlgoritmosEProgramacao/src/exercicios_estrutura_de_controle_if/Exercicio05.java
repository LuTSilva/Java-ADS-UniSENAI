package exercicios_estrutura_de_controle_if;

import java.util.Scanner;

public class Exercicio05 {
	/*
	 * Classificação Etária com Mensagens Personalizadas: 
	 * Dado nome e idade de uma pessoa, classifique-a como 
	 * "Criança" (idade <= 12), "Adolescente" (12 < idade <= 20) ou "Adulta" (idade > 20)
	 *  e exiba uma mensagem personalizada.
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Informe a idade: ");
		int idade = sc.nextInt();
		
		if (idade <= 12) {
			System.out.println("Criança");
		} else if (idade <= 20) {
			System.out.println("Adolescente");
		} else {
			System.out.println("Adulta");
		}
		
		sc.close();
	}

}
