package matematicaEProgramacao;

import java.util.Scanner;

public class exercicioJurosSimples {
//	Um comerciante deseja fazer um empréstimo para investir em mercadorias. 
//	Ele quer saber quanto pagará de juros e o valor total ao final do prazo. 
//	Vocês devem criar uma aplicação em Java que receba:
//	Valor emprestado
//	Taxa de juros mensal
//	Quantidade de meses
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		double valor = lerDouble("Informe o valor do empréstimo: ", sc);
		double taxa = lerDouble("Informe a Taxa de Juros mensal: ", sc);
		int meses = lerInt("Informe a quantidade de meses: ", sc);
		
		double juros = valor * meses * (taxa / 100);
		double valorFinal = juros + valor; 
		
		
		System.out.printf("o valor do juros é: %.2f\n", juros);
		System.out.printf("o valor final é: %.2f\n", valorFinal);
		
		sc.close();

	}
	public static int lerInt(String msg, Scanner sc) {
        System.out.print(msg);
        return sc.nextInt();
    }
	public static double lerDouble(String msg, Scanner sc) {
        System.out.print(msg);
        return sc.nextDouble();
    }
	
}
