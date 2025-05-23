package exercicios_estrutura_de_controle_if;

import java.util.Scanner;

public class Exercicio09 {
	/*
	 * Cálculo de Comissão Para Vendedores: 
	 * Leia o valor das vendas de um vendedor. 
	 * Se superior a R$ 20.000,00, aplique comissão de 20%; 
	 * caso contrário, 10%. 
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Informe o valor das vendas: ");
		double valor = sc.nextDouble();
		double comissao;
		
		if (valor > 20000) {
			System.out.println("Comissão 20% aplicada!");
			comissao = valor * 0.2;
		} else if (valor <= 0) {
			System.out.println("Valor inválido! comissão não será aplicada!");
			comissao = 0; valor = 0;
		} else {
			System.out.println("Comissão 10% aplicada!");
			comissao = valor * 0.1;
		}
		
		System.out.printf("Comissão à receber: R$ %.2f", comissao);		
		sc.close();

	}

}
