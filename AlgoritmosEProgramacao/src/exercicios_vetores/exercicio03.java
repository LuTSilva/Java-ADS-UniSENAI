package exercicios_vetores;

import java.util.Scanner;

public class exercicio03 {
// Exercício 3 - Faça um algoritmo e um programa que leia nome e salário
// de N funcionários de uma empresa e armazene todos na memória (utilize vetores).
// Após o cadastro de todos os dados, 
// altere o salário dos funcionários conforme a seguinte regra:
// Até R$ 400,00 + 25%
// Até R$ 600,00 + 20%
// Até R$ 800,00 + 15%
// Demais + 10 %
// Após exiba todos os nomes, 
// o salário antes da alteração e o salário após a alteração.

static String[] nomes;
static double[] salarios;
static double[] salariosFinais;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = lerInt("Quantos funcionários deseja cadastrar? ", sc);
		instanciaVetor(n);
        cadastrarFuncionario(n, sc);
		exibeMsg("\nFuncionários e seus salários:");
		atualizaSalario(n, sc);
		sc.close();
	}
	public static void instanciaVetor(int n) {
		nomes = new String[n];
		salarios = new double[n];
		salariosFinais = new double[n];
	}
	public static void atualizaSalario(int n, Scanner sc) {
		for (int i = 0; i < n; i++) {
			salariosFinais[i] = calcularNovoSalario(salarios[i]);
			
			exibeMsg("Nome: %s, Salário Antigo: %.2f, Salário Novo: %.2f%n", nomes[i], salarios[i], salariosFinais[i]);
		}
	}
	public static double calcularNovoSalario(double salario) {
		if (salario <= 400.00) {
			return salario * 1.25; // + 25%
		} else if (salario <= 600.00) {
			return salario * 1.20; // + 20%
		} else if (salario <= 800.00) {
			return salario * 1.15; // + 15%
		} else {
			return salario * 1.10; // + 10%
		}
	}
    public static void cadastrarFuncionario(int n, Scanner sc) {
        for (int i = 0; i < n; i++) {		
            sc.nextLine(); // Consumir a quebra de linha pendente
            nomes[i] = lerString("Informe o nome do funcionário " + (i + 1) + ": ", sc);
            salarios[i] = lerDouble("Informe o salário de " + nomes[i] + ": ", sc);
        }
    }
	public static void exibeMsg(String msg) {
		System.out.println(msg);
	}
	public static void exibeMsg(String msg, Object... args) {
		System.out.printf(msg + "%n", args);
	}

	public static String lerString(String msg, Scanner sc) {
		System.out.print(msg);
		return sc.nextLine();
	}
	public static double lerDouble(String msg, Scanner sc) {
		System.out.print(msg);
		while (!sc.hasNextDouble()) { // Verifica se a entrada é um número válido
			sc.next(); // descarta a entrada inválida
			System.out.print("Entrada inválida. " + msg);
		}
		return sc.nextDouble();
	}
	public static int lerInt(String msg, Scanner sc) {
		System.out.print(msg);
		while (!sc.hasNextInt()) { // Verifica se a entrada é um número válido
			sc.next(); // descarta a entrada inválida
			System.out.print("Entrada inválida. " + msg);
		}
		return sc.nextInt();
	}

}
