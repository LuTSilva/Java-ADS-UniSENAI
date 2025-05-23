package exercicios_estrutura_de_repeticao_while;

import java.util.Scanner;

public class Exercicio02 {
	/*
	 * Validação de Senhas: 
	 * Solicite uma senha e continue solicitando 
	 * até que uma senha correta "1234" seja digitada. 
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		String senhaCorreta = "1234";
		String senhaInformada;
		System.out.println("Digite a senha: ");
		senhaInformada = sc.nextLine();
		while (!senhaInformada.equals(senhaCorreta)) {
			System.out.println("Senha incorreta. Tente novamente: ");
			senhaInformada = sc.nextLine();
		}
		System.out.println("Senha correta! Acesso permitido.");
		sc.close();
	}

}
