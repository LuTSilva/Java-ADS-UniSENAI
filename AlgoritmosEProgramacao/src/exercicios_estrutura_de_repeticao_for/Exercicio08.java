package exercicios_estrutura_de_repeticao_for;

import java.util.Scanner;

public class Exercicio08 {
	/*
	 * Números Primos até N: Liste todos os números primos entre 1 e N
	 */
	public static void main(String[] args) {
		// usar for
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Informe o número N: ");
		int n = sc.nextInt();
		System.out.println("Os números primos entre 1 e " + n + " são: ");
		for (int i = 2; i <= n; i++) {
			boolean primo = true;
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					primo = false;
					break;
				}
			}
			if (primo) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
		sc.close();
		
	}

}
