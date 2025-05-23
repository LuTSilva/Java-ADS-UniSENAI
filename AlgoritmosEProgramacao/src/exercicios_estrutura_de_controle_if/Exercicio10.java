package exercicios_estrutura_de_controle_if;

import java.util.Scanner;

public class Exercicio10 {
	/*
	 * Faixa Etária e Abono: 
	 * Leia a idade de um funcionário. 
	 * Se acima de 60 anos, aplique um abono de R$ 100, senão, R$ 50. 
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Informe a idade: ");
		int idade = sc.nextInt();
		double abono;
		
		if(idade > 60) {
			System.out.println("Idade acima de 60 anos");
			abono = 100;
		} else if (idade < 0) {
			System.out.println("Idade Inválida! Abono não aplicado!");
			abono = 0; idade = 0;
		} else {
			System.out.println("Idade abaixo de 60 anos");
			abono = 50;
		}
		
		System.out.printf("Abono: R$ %.2f", abono);
		sc.close();

	}

}
