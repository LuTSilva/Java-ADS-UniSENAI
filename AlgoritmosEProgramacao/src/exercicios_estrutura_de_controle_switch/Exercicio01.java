package exercicios_estrutura_de_controle_switch;

import java.util.Scanner;

public class Exercicio01 {

	public static void main(String[] args) {
			/*
	 * Mês por Extenso: Peça ao usuário para inserir um número de 1 a 12 e exiba o mês correspondente. 
	 */

		Scanner sc = new Scanner(System.in);
		System.out.println("Digite um número de 1 a 12: ");
		int mes = sc.nextInt();
		String mesExtenso;
		switch (mes) {
			case 1:
				mesExtenso = "Janeiro";
				break;
			case 2:
				mesExtenso = "Fevereiro";
				break;
			case 3:
				mesExtenso = "Março";
				break;
			case 4:
				mesExtenso = "Abril";
				break;
			case 5:
				mesExtenso = "Maio";
				break;
			case 6:
				mesExtenso = "Junho";
				break;
			case 7:
				mesExtenso = "Julho";
				break;
			case 8:
				mesExtenso = "Agosto";
				break;
			case 9:
				mesExtenso = "Setembro";
				break;
			case 10:
				mesExtenso = "Outubro";
				break;
			case 11:
				mesExtenso = "Novembro";
				break;
			case 12:
				mesExtenso = "Dezembro";
				break;
			default:
				mesExtenso = "Opção inválida!";
		}
		System.out.println("O mês correspondente é: " + mesExtenso);
		sc.close();

	}

}
