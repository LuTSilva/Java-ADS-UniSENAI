package exercicios_vetores;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class exercicio05_array {
// Exercício 5
// Criar um programa java que cadastre o nome, preço e o estoque de N
// mercadorias Utilizar menu
// 1 - cadastrar (máximo 50 mercadorias).
// 2 - Qual a mercadoria com maior preço.
// 3 - Qual mercadoria com menor preço.
// 4 - Qual a mercadoria com maior estoque.
// 5 - Qual mercadoria com menor estoque.
static List<String> nomes = new ArrayList<>();
static List<Double> precos = new ArrayList<>();
static List<Integer> estoques = new ArrayList<>();
static int count = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int op;
		do {
			op = menu(sc);
			switch (op) {
				case 1 -> cadastrarMercadoria(sc);
				case 2 -> exibeMsg("Mercadoria com maior preço: " + mercadoriaMaiorPreco());
				case 3 -> exibeMsg("Mercadoria com menor preço: " + mercadoriaMenorPreco());
				case 4 -> exibeMsg("Mercadoria com maior estoque: " + mercadoriaMaiorEstoque());
				case 5 -> exibeMsg("Mercadoria com menor estoque: " + mercadoriaMenorEstoque());
				case 6 -> exibeMsg("Finalizando");
				default -> exibeMsg("Opção inválida");
			}
		} while (op != 6);
		
		sc.close();
	}
	public static void cadastrarMercadoria(Scanner sc) {
		if (nomes.size() < 50) { // .size() retorna o número de elementos na lista
			sc.nextLine(); // Consumir a quebra de linha pendente
			String nome = lerString("Informe o nome da mercadoria: ", sc);
			double preco = lerDouble("Informe o preço da mercadoria: ", sc);
			int estoque = lerInt("Informe o estoque da mercadoria: ", sc);
			count++;
			
			nomes.add(nome);
			precos.add(preco);
			estoques.add(estoque);
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
	public static String mercadoriaMaiorPreco() {
		if (precos.isEmpty()) return "Nenhuma mercadoria cadastrada.";
		double maiorPreco = precos.get(0);
		String nomeMaiorPreco = nomes.get(0);
		for (int i = 1; i < precos.size(); i++) {
			if (precos.get(i) > maiorPreco) {
				maiorPreco = precos.get(i);
				nomeMaiorPreco = nomes.get(i);
			}
		}
		return nomeMaiorPreco + " - R$" + maiorPreco;
	}
public static String mercadoriaMenorPreco() {
		if (precos.isEmpty()) return "Nenhuma mercadoria cadastrada.";
		double menorPreco = precos.get(0);
		String nomeMenorPreco = nomes.get(0);
		for (int i = 1; i < precos.size(); i++) {
			if (precos.get(i) < menorPreco) {
				menorPreco = precos.get(i);
				nomeMenorPreco = nomes.get(i);
			}
		}
		return nomeMenorPreco + " - R$" + menorPreco;
	}
public static String mercadoriaMaiorEstoque() {
		if (estoques.isEmpty()) return "Nenhuma mercadoria cadastrada.";
		int maiorEstoque = estoques.get(0);
		String nomeMaiorEstoque = nomes.get(0);
		for (int i = 1; i < estoques.size(); i++) {
			if (estoques.get(i) > maiorEstoque) {
				maiorEstoque = estoques.get(i);
				nomeMaiorEstoque = nomes.get(i);
			}
		}
		return nomeMaiorEstoque + " - Estoque: " + maiorEstoque;
	}
public static String mercadoriaMenorEstoque() {
		if (estoques.isEmpty()) return "Nenhuma mercadoria cadastrada.";
		int menorEstoque = estoques.get(0);
		String nomeMenorEstoque = nomes.get(0);
		for (int i = 1; i < estoques.size(); i++) {
			if (estoques.get(i) < menorEstoque) {
				menorEstoque = estoques.get(i);
				nomeMenorEstoque = nomes.get(i);
			}
		}
		return nomeMenorEstoque + " - Estoque: " + menorEstoque;
	}
}
