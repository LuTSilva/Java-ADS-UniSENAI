package avaliacao2_java;

import java.util.Scanner;

public class Avaliacao5 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		exibeMenu();
		int contadorPositivo = 0;
		int contadorNegativo = 0;
		contador(sc, contadorPositivo, contadorNegativo);
		sc.close();
	}

	public static void contador(Scanner sc, int contadorPositivo, int contadorNegativo) {
		int numero;
		do {
			
			numero = lerInt("Informe um número positivo ou negativo (Informe '0' para sair): ", sc);
			
			if (numero > 0) {
				contadorPositivo++;
			} else {
				contadorNegativo++;
			}
			
		} while (numero != 0);
		exibeResultado(contadorPositivo, contadorNegativo);
	}

	public static void exibeResultado(int contadorPositivo, int contadorNegativo) {
		if (contadorPositivo > 0 || contadorNegativo > 0) {
			exibeMsg("Numeros positivos informados: " + contadorPositivo);
			exibeMsg("Numeros positivos informados: " + (contadorNegativo - 1));
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
	public static void exibeMenu() {
		System.out.println("Informe um número positivo ou negativo (Informe '0' para sair): "); ;
		
	}
}
