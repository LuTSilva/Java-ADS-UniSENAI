package avaliacao2_java;

import java.util.Scanner;

public class Avaliacao5 {
// Enunciado 5: Contagem de Positivos e Negativos com Menu
// Escreva um programa com menu interativo (enquanto o usuário quiser) que leia números
// inteiros e:
// ● Conte quantos são positivos
// ● Conte quantos são negativos
// ● Ao final, mostre esses totais
// O programa precisa ter no mínimo os seguintes métodos:
// ● Ler número
// ● Exibir menu
// ● Verificar se é positivo ou negativo (no mesmo método)
// ● Exibir mensagem

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		int contadorPositivo = 0;
		int contadorNegativo = 0;
		contador(sc, contadorPositivo, contadorNegativo);
		sc.close();
	}

	public static void contador(Scanner sc, int contadorPositivo, int contadorNegativo) {
		int numero;
		do {
			numero = menu(sc);
			if (numero >= 0) {
				contadorPositivo++;
			} else {
				contadorNegativo++;
			}
		}while (numero != 0);
		contadorPositivo--;
		exibeResultado(contadorPositivo, contadorNegativo);
	}

	public static void exibeResultado(int contadorPositivo, int contadorNegativo) {
		if (contadorPositivo > 0 || contadorNegativo > 0) {
			exibeMsg("Numeros positivos informados: " + contadorPositivo);
			exibeMsg("Numeros negativos informados: " + contadorNegativo);
		} else {
			exibeMsg("Nenhum número foi informado.");
		}
	}
	
	public static void exibeMsg (String msg) {
		System.out.println(msg);
	}
	public static int lerInt(String msg, Scanner sc) {
        System.out.print(msg);
        return sc.nextInt();
    }
	public static int menu(Scanner sc) {
		return lerInt("Informe um número inteiro, ou Informe '0' para sair: ", sc);
		
	}
}
