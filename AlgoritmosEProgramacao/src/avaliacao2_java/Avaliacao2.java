package avaliacao2_java;

import java.util.Scanner;

public class Avaliacao2 {
	// Enunciado 2: Cálculo de Fatorial
	// Faça um programa que leia um número inteiro não negativo e calcule seu fatorial
	// O programa precisa ter no mínimo os seguintes métodos:
	// ● Ler número inteiro
	// ● Validar se o número é válido (não negativo)
	// ● Exibir mensagem final
	// ● Calcular o fatorial
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int fatorial = 1;
		int numero = lerFatorial(sc);
		validarFatorial(fatorial, numero);
		
		sc.close();
	}
	public static void validarFatorial(int fatorial, int numero) {
		if (numero > 0) {
			fatorial = calcularFatorial(fatorial, numero);
			exibeMsg("O fatorial de " + numero + " é: " + fatorial);
		} else {
			exibeMsg("Numero inválido!");
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
