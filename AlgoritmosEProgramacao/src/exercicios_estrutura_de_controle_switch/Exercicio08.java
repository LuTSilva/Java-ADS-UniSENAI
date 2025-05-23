package exercicios_estrutura_de_controle_switch;

import java.util.Scanner;

public class Exercicio08 {
	/*
	 * Tipo de Triângulo: 
	 * Solicite três lados de um triângulo. 
	 * Use switch para classificar o triângulo como Equilátero, Isósceles ou Escaleno.
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Digite o primeiro lado do triângulo: ");
		double lado1 = sc.nextDouble();
		System.out.println("Digite o segundo lado do triângulo: ");
		double lado2 = sc.nextDouble();
		System.out.println("Digite o terceiro lado do triângulo: ");
		double lado3 = sc.nextDouble();

		if (lado1 + lado2 > lado3 
		&& lado1 + lado3 > lado2 
		&& lado2 + lado3 > lado1) {
            int tipo;
            
            if (lado1 == lado2 && lado2 == lado3) {
                tipo = 1; // Equilátero
            } else if (lado1 == lado2 || lado1 == lado3 || lado2 == lado3) {
                tipo = 2; // Isósceles
            } else {
                tipo = 3; // Escaleno
            }

            switch (tipo) {
                case 1:
                    System.out.println("O triângulo é Equilátero (todos os lados iguais).");
                    break;
                case 2:
                    System.out.println("O triângulo é Isósceles (dois lados iguais).");
                    break;
                case 3:
                    System.out.println("O triângulo é Escaleno (todos os lados diferentes).");
                    break;
                default:
                    System.out.println("Erro na classificação.");
            }
        } else {
            System.out.println("Os valores inseridos não formam um triângulo válido.");
        }

        sc.close();


		


	}

}
