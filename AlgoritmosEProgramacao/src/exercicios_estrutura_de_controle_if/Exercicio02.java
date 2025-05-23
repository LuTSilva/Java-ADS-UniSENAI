package exercicios_estrutura_de_controle_if;

import java.util.Scanner;

public class Exercicio02 {
	/*
	 * Calculadora de Reajuste Salarial: 
	 * Implemente um programa que aplique um reajuste de 30% para salários inferiores a R$5.000,00. 
	 * Solicite o salário e exiba o valor reajustado. 
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Informe o Salário: ");
		double salario = sc.nextDouble();
		
		if (salario < 5000 && salario > 0) {
			System.out.println("Salário reajustado em 30%!");
			salario *= 1.3;
			
		} else if (salario >= 5000){
			System.out.println("Salário não será reajustado!");
			
		} else {
			System.out.println("Salário Inválido!");
			salario = 0;
		}
		System.out.printf("Salário Final: R$ %.2f", salario);
		
		sc.close();

	}

}
