package exercicios_estrutura_de_repeticao_do_while;

import java.util.Scanner;

public class Exercicio01 {
	/*
	 * Leitor de Números até Limite: 
	 * Continue pedindo números ao usuário 
	 * até que a soma dos números digitados ultrapasse 100. 
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		int numero;
		int soma = 0;
		do {
			System.out.println("Informe um número: ");
			numero = sc.nextInt();
			
			soma += numero;
			
		} while (soma <= 100);
		System.out.println("A soma dos números informados é: " + soma);
		System.out.println("A soma ultrapassou 100, programa encerrado.");
		sc.close();
				
	}

}
