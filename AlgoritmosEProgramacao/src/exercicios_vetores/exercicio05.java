package exercicios_vetores;

import java.util.Scanner;
public class exercicio05 {
// Exercício 5
// Criar um programa java que cadastre o nome, preço e o estoque de N
// mercadorias Utilizar menu
// 1 - cadastrar (máximo 50 mercadorias).
// 2 - Qual a mercadoria com maior preço.
// 3 - Qual mercadoria com menor preço.
// 4 - Qual a mercadoria com maior estoque.
// 5 - Qual mercadoria com menor estoque.
static String[] nomes;
static double[] precos;
static int[] estoques;
static int count = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = lerInt("Quantas mercadorias deseja cadastrar? ", sc);
		instanciaVetor(n);
		processaEntrada(sc);
		
		sc.close();
	}
	private static void processaEntrada(Scanner sc) {
		int op;
		do {
			op = menu(sc);
			switch (op) {
				case 1 -> cadastrarMercadoria(sc);
				case 2 -> preco(true);
				case 3 -> preco(false);
				case 4 -> estoque(true);
				case 5 -> estoque(false);
				case 6 -> exibeMsg("Finalizando");
				default -> exibeMsg("Opção inválida");
			}
		} while (op != 6);
	}
		public static void instanciaVetor(int n) {
		nomes = new String[n];
		precos = new double[n];
		estoques = new int[n];
	}
	public static void cadastrarMercadoria(Scanner sc) {
		if (count < 50) {
			sc.nextLine(); // Consumir a quebra de linha pendente
			nomes[count] = lerString("Informe o nome da mercadoria: ", sc);
			precos[count] = lerDouble("Informe o preço da mercadoria: ", sc);
			estoques[count] = lerInt("Informe o estoque da mercadoria: ", sc);
			count++;
		} else {
			exibeMsg("Limite de mercadorias cadastradas atingido.");
		}
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
	public static void exibeMsg(String msg) {
		System.out.println(msg);
	}
	public static int menu(Scanner sc) {
		System.out.println("Menu:");
		System.out.println("1 - Cadastrar mercadoria");
		System.out.println("2 - Mercadoria com maior preço");
		System.out.println("3 - Mercadoria com menor preço");
		System.out.println("4 - Mercadoria com maior estoque");
		System.out.println("5 - Mercadoria com menor estoque");
		System.out.println("6 - Sair");
		return lerInt("Escolha uma opção: ", sc);
	}
	public static void preco(boolean maior) {
		if (count == 0) {
			exibeMsg("Nenhuma mercadoria cadastrada.");
			return;
		}
		double preco = precos[0];
		String nome = nomes[0];
		for (int i = 1; i < count; i++) {
			if ((maior && precos[i] > preco) || (!maior && precos[i] < preco)) {
				preco = precos[i];
				nome = nomes[i];
			}
		}
		exibeMsg(nome + " - Preço: R$" + preco);
	}
	public static void estoque(boolean maior) {
		if (count == 0) {
			exibeMsg("Nenhuma mercadoria cadastrada.");
			return;
		}
		int estoque = estoques[0];
		String nome = nomes[0];
		for (int i = 1; i < count; i++) {
			if ((maior && estoques[i] > estoque) || (!maior && estoques[i] < estoque)) {
				estoque = estoques[i];
				nome = nomes[i];
			}
		}
		exibeMsg(nome + " - Estoque: " + estoque);
	}
}
