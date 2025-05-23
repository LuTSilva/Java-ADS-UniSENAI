package exercicios_estrutura_de_controle_if;

import java.util.Scanner;

public class Exercicio13 {
	/*
	 * Hospedagem: Um hotel cobra R$100,00 por diária mais a taxa de serviço. 
	 * A taxa de serviço é cobrada de acordo com a seguinte tabela: 
	 * R$5,00 por diária, se o número de diárias for maior que 15; 
	 * R$6,00 por diária, se o número de diárias for de 10 a 14;
	 * R$8,00 por diária, se o número de diárias for menor que 10. 
	 * Faça um programa para ler o nome do hóspede e o número de dias que este permaneceu no hotel,
	 * e após mostre o valor que o hóspede deverá pagar ao hotel.
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Informe o Nome: ");
		String nome = sc.nextLine();
		System.out.println("Informe os Dias: ");
		int dias = sc.nextInt();
		double valor = 100 * dias;
		double taxa;
		if(dias > 15) {
			taxa = 5 * dias;
		} else {
			if (dias >= 10) {
				taxa = 6 * dias;
			} else {
				taxa = 8 * dias;
			}
		}
		
		System.out.printf(nome + "\n Valor a pagar: R$ %.2f", (taxa + valor));
		sc.close();

	}

}
