package introducao_java;

import java.util.Scanner;

public class ExemploMedia {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Insira o Nome: ");
		String nome = sc.nextLine();
		System.out.println("Insira a primeira nota: ");
		double n1 = sc.nextDouble();
		System.out.println("Insira a Segunda nota: ");
		double n2 = sc.nextDouble();
		System.out.println("Insira a Terceira nota: ");
		double n3 = sc.nextDouble();
		double media = (n1 + n2 + n3) / 3;
		
		if (media >= 7) {
			System.out.println(nome + " ESTÁ APROVADO(A)");
		}else if(media < 3) {
			System.out.println(nome + " ESTÁ REPROVADO(A)");
		}else {
			System.out.println(nome + " ESTÁ EM RECUPERAÇÃO");
		}
		
//		int qtTotal = sc.nextInt();
//		int qtFaltas = sc.nextInt();
//		double pcFreq = ((qtTotal - qtFaltas) / qtTotal);
		
		
		
		sc.close();
	}
}
