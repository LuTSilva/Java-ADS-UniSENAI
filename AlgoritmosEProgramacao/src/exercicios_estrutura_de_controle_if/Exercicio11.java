package exercicios_estrutura_de_controle_if;

import java.util.Scanner;

public class Exercicio11 {
	/*
	 * Sistema de Tarifação de Telecomunicações: 
	 * Crie um programa que calcule o custo de uma chamada telefônica. 
	 * Entradas incluem o dia da semana, hora de início e duração da chamada. 
	 * Tarifas variam: dias de semana (8h-18h: R$0,50/min, 18h-8h: R$0,30/min), 
	 * fins de semana (R$0,20/min). Aplique descontos adicionais para chamadas superiores a 60 minutos
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Informe o dia da semana: ");
		String menu = " 1 - Segunda \n 2 - Terca \n 3 - Quarta \n 4 - Quinta \n 5 - Sexta \n 6 - Sabado \n 7 - Domingo";
		System.out.println(menu);
		int dia = sc.nextInt();
		
		System.out.println("Informe a hora de início da ligação, em formato 24 horas: ");
		int hora = sc.nextInt();
		
		System.out.println("Informe a duração da chamada em minutos: ");
		int duracao = sc.nextInt();
		double tarifa;
		
		if (dia > 0 && dia <= 5) {
			System.out.println("Dia de Semana!");
			if (hora >= 7 && hora <=18 ) {
				System.out.println("Tarifa em horário comercial!");
				tarifa = 0.5 * duracao;
			} else {
				System.out.println("Tarifa fora de horário comercial!");
				tarifa = 0.3 * duracao;
			}
		} else if (dia == 6 | dia == 7) {
			if (duracao > 60) {
				System.out.println("Desconto 10% aplicado por ligação longa duração!");
				tarifa = (0.2 * duracao) * 0.9;
			} else {
				System.out.println("Tarifa padrão fim de semana aplicada!");
				tarifa = 0.2 * duracao;
			}
		} else {
			System.out.println("Dia da Semana Inválido!");
			tarifa = 0;
		}
		
		System.out.printf("Tarifa aplicada: R$ %.2f", tarifa);
		sc.close();

	}

}
