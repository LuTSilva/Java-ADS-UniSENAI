package avaliacao_3_java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class avaliacao5 {
static List<String> nomes = new ArrayList<>();
static List<Integer> quantidades = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int op;
		do {
			op = menu(sc);
			switch (op) {
				case 1 -> cadastrar(sc);
				case 2 -> buscarProdutoPorNome(sc);
				case 3 -> listarTodos();
				case 4 -> exibeMsg("Finalizando");
				default -> exibeMsg("Opção inválida");
			}
		} while (op != 4);
	}
	public static String lerString(String msg, Scanner sc) {
		System.out.print(msg);
		return sc.nextLine();
	}
	public static int menu(Scanner sc) {
		System.out.println("Menu:");
		System.out.println("1 - Cadastrar produto");
		System.out.println("2 - Buscar produto por nome");
		System.out.println("3 - Listar produtos com mais de 10 unidades");
		System.out.println("4 - Sair");
		return lerInt("Escolha uma opção: ", sc);
	}
	public static int lerInt(String msg, Scanner sc) {
		System.out.print(msg);
		while (!sc.hasNextInt()) { 
			sc.next(); 
			System.out.print("Entrada inválida. " + msg);
		}
		return sc.nextInt();
	}
	public static void exibeMsg(String msg) {
		System.out.println(msg);
	}
	public static void cadastrar(Scanner sc) {
		sc.nextLine();
		String nome = lerString("Digite o nome do produto: ", sc);
		nome = normalizarNome(nome);
		int quantidade = lerInt("Digite a quantidade do produto: ", sc);
		nomes.add(nome);
		quantidades.add(quantidade);
		exibeMsg("produto cadastrado com sucesso!");
	}
	public static void buscarProdutoPorNome(Scanner sc) {
		sc.nextLine();
		String nome = lerString("Digite o nome do produto a ser buscado: ", sc);
		nome = normalizarNome(nome);
		int index = nomes.indexOf(nome);
		if (index != -1) {
			exibeMsg("produto encontrado: " + nomes.get(index) + " - " + quantidades.get(index));
		} else {
			exibeMsg("produto não encontrado.");
		}
	}
	public static void listarTodos() {
		String msg = "***Produtos***\n";
		for (int i = 0; i<nomes.size(); i++) {
			if (quantidades.get(i) > 10) {
				msg +=(i+1) + ": " + nomes.get(i) + " - " + quantidades.get(i) + "\n";
			}
		}
		exibeMsg(msg);
	}
	public static String normalizarNome(String nome) {
		return nome.trim().toLowerCase().replaceAll("\\s+", "");
	}
}
