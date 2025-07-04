package avaliacao_3_java;

import java.util.Scanner;

public class avaliacao4 {
	public static void main(String[] args) {
		// Faça um programa que leia o salário e número de dependentes de um
		// funcionário. Sabendo que funcionários recebem um abono de R$100.00 por
		// dependente, mostre ao final o valor a receber.
		// **Utilize o máximo que conseguir de modularização

		iniciaPrograma();
	}
	public static void iniciaPrograma() {
		Scanner sc = new Scanner(System.in);
		double salario = lerDouble("Informe o salário base: ", sc);
		int dependentes = lerInt("Informe o numero de dependentes: ", sc);
		double salFinal = calculaSalario(salario, dependentes);
		
		exibeMsg("O Salário final é: %.2f\n", salFinal);
		sc.close();
	}
	public static double calculaSalario(double salario, int dependentes) {
		double salFinal = salario + (dependentes * 100);
		return salFinal;
	}
   public static void exibeMsg(String msg, Object... args) {
        System.out.printf(msg, args);
    }
    public static double lerDouble(String msg, Scanner sc) {
        System.out.print(msg);
        return sc.nextDouble();
    }
    public static int lerInt(String msg, Scanner sc) {
		System.out.print(msg);
		return sc.nextInt();
	}
}
