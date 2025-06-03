package avaliacao2_java;

import java.util.Scanner;

public class Avaliacao2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int fatorial = 1;
		int numero = lerInt("Informe um número para calcular o fatorial: ", sc);
		validarFatorial(fatorial, numero);
		
		sc.close();
	}
	public static void validarFatorial(int fatorial, int numero) {
		if (numero > 0) {
			fatorial = calcularFatorial(fatorial, numero);
			exibeMsg("O fatorial de " + numero + " é: " + fatorial);;
		} else {
			exibeMsg("Numero inválido!");;
		}
	}
	public static int calcularFatorial(int fatorial, int numero) {
		for (int i = 1; i <= numero; i++) {
			fatorial *= i;
		}
		return fatorial;
	}
	public static int lerInt(String msg, Scanner sc) {
        System.out.print(msg);
        return sc.nextInt();
    }
	public static int lerFatorial (Scanner sc) {
		return lerInt("Informe um número para calcular o fatorial: ", sc);
	}
	public static void exibeMsg (String msg) {
		System.out.println(msg);
	}
	
		
	
}
