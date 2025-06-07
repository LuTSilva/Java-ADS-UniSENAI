package atividade_desconto;

import java.util.Scanner;

public class exercicio15 {
	public static void main(String[] args) {
		// 15. Implemente uma lógica em Java que leia um valor de desconto percentual
		// e exiba a mensagem “Desconto agressivo!” somente se o valor for superior a 50%.
		// Caso contrário, exiba “Desconto normal.”
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Informe o desconto percentual: ");
		double desconto = sc.nextDouble();
		
		if (desconto > 50) {
			System.out.print("Desconto agressivo!");
		} else if (desconto < 0) {
			System.out.println("Desconto inválido!");
		} else if (desconto == 0) {
			System.out.println("Sem desconto!");
		} else {
			System.out.print("Desconto normal!");
		}

		sc.close();
	}
}
