package exercicios_estrutura_de_controle_switch;

import java.util.Scanner;

public class Exercicio02 {
	/*
	 * Cálculo de Aumentos por Categoria: 
	 * Implemente um programa que leia uma categoria (de A a E) 
	 * e aplique um aumento salarial específico: A (10%), B (15%), C (20%), D (25%), E (30%). 
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Informe o Salário: ");
		double salario = sc.nextDouble();
		System.out.printf("Informe sua categoria: (A, B, C, D, E) \n");
		char categoria = sc.next().toUpperCase().charAt(0);
		
		switch(categoria) {
		case 'A':
			salario *= 1.1;
			break;
		case 'B':
			salario *= 1.15;
			break;
		case 'C':
			salario *= 1.2;
			break;
		case 'D':
			salario *= 1.25;
			break;
		case 'E':
			salario *= 1.3;
			break;
		default:
			System.out.println("Categoria Inválida!");
			break;
		}
			
		System.out.printf("Salário Final: R$ %.2f", salario);
		sc.close();
	}

}
