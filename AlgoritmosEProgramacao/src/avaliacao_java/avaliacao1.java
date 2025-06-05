package avaliacao_java;

import java.util.Scanner;

public class avaliacao1 {
	// Faça um programa que leia 3 notas e o percentual de frequência de um aluno. 
	// Após, mostre se o aluno está aprovado ou não. 
	// Para o aluno ser aprovado precisa que a média seja superior ou igual a 6.0 
	// e que o percentual de frequência seja superior ou igual a 75%.
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Insira a primeira nota: ");
		double nota1 = sc.nextDouble();
		System.out.println("Insira a segunda nota: ");
		double nota2 = sc.nextDouble();
		System.out.println("Insira a terceira nota: ");
		double nota3 = sc.nextDouble();
		
		double media = (nota1 + nota2 + nota3) / 3;
		int frequencia = 0;
		
		if (media >= 6) {
			System.out.println("Informe a porcentagem de Frequência: ");
			frequencia = sc.nextInt();
			if (frequencia >= 75) {
				System.out.println("Aprovado!");
			} else {
				System.out.println("Reprovado!");
			}
		} else {
			System.out.println("Reprovado!");
		}
		sc.close();
	}
}
