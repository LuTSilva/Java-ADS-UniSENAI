package avaliacao2_java;

import java.util.Scanner;

public class Avaliacao1 {
	// Enunciado 1: Cálculo da Média com Modularização
	// Escreva um programa em Java que leia N números inteiros digitados pelo usuário e
	// após o usuário informar todos os N números exiba:
	// ● A soma dos números
	// ● A média aritmética dos números
	// O programa precisa ter no mínimo os seguintes métodos:
	// ● Ler número inteiro
	// ● Exibir mensagem final
	// ● Calcular a média
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = lerInt("Informe o numero N: ", sc);
		int soma = somatorio (n, sc);
		exibeMsg("Média dos números informados: " + calculaMedia(soma, n));
		
		
	}
	public static int lerInt(String msg, Scanner sc) {
        System.out.print(msg);
        return sc.nextInt();
    }
	public static void exibeMsg(String msg) {
        System.out.println(msg);
    }
	public static int somatorio(int n, Scanner sc) {
		int numero;
		int soma = 0;
		
		for (int i = 1; i <= n; i++) {
			numero = lerInt("Informe o próximo numero para calcular a média: ", sc);
			soma += numero;
		}
		return soma;
	} 
	public static int calculaMedia (int somatorio, int n) {
		return somatorio / n;
	}
	
}
