package exercicios_estrutura_de_controle_if;

import java.util.Scanner;

public class Exercicio04 {
	/*
	 * Resultado do Aluno: Solicite nome e três notas de um aluno. 
	 * Calcule a média e informe se está aprovado, em recuperação ou reprovado 
	 * (média >= 7,0 | entre 4,5 e 6,9 | <4,5, respectivamente). 
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Insira a primeira nota");
		double nota1 = sc.nextDouble();
		System.out.println("Insira a segunda nota");
		double nota2 = sc.nextDouble();
		System.out.println("Insira a terceira nota");
		double nota3 = sc.nextDouble();
		double media = (nota1 + nota2 + nota3) / 3;
		
		if (media >= 7) {
			System.out.println("Aprovado!");
		} else if (media >= 4.5) {
			System.out.println("Em Recuperação!");
		} else {
			System.out.println("Reprovado!");
		}
		
		sc.close();

	}

}
