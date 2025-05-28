package matematicaEProgramacao;

import java.util.Scanner;

public class descontos {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int op;
		
		do {
		System.out.println("Digite o valor do produto: ");
		double valor = sc.nextDouble();
		
		System.out.println("Digite o percentual de desconto: ");
		double desconto = sc.nextDouble();
		
		double valorDesconto = valor * (desconto / 100);
		double valorFinal = valor - valorDesconto;
		
		System.out.printf("Desconto: R$ %.4f\n", valorDesconto);
		System.out.printf("Valor final: R$ %.4f\n", valorFinal);
		System.out.println("Para sair, digite 0");
		op = sc.nextInt();
		
		} while (op != 0);
		
		sc.close();

	}

}
