package matematicaEProgramacao;

import java.util.Scanner;

public class exercicio02CalculoMedia {
//	Uma escola quer automatizar o processo de avaliação. 
//	Crie um sistema que receba 3 notas, calcule a média e diga se o aluno foi:
//	Aprovado (média ≥ 7)
//	Recuperação (média entre 5 e 6.9)
//	Reprovado (média < 5)
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		double soma = 0;
		soma = somador(soma, sc);
		double media = soma / 3;
		
		validador(media);
		
		sc.close();
	}

	public static double somador(double soma, Scanner sc) {
		double nota;
		for(int i = 1; i <= 3; i++) {
			System.out.println("Informe o valor da Nota " + i + ":");
			nota = sc.nextDouble();
			soma += nota;
		}
		return soma;
	}

	public static void validador(double media) {
		if (media >= 7) {
			System.out.println("Aprovado!");
		} else if (media < 0) {
			System.out.println("Valores inválidos!");
		} else if (media < 5) {
			System.out.println("Reprovado!");
		} else {
			System.out.println("Em Recuperação!");
		}
	}

}
