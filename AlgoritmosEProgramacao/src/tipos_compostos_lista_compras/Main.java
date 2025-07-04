package tipos_compostos_lista_compras;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static List<Compra> compras = new ArrayList<>();
	
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
		exibeMsg("Menu:");
		exibeMsg("1 - Cadastrar produto");
		exibeMsg("2 - Buscar produto por nome");
		exibeMsg("3 - Listar produtos com mais de 10 unidades");
		exibeMsg("4 - Sair");
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
		Compra compra = new Compra();
		compra.nome = lerString("Digite o nome do produto: ", sc);
		compra.nome = normalizarNome(compra.nome);
		compra.quantidade = lerInt("Digite a quantidade do produto: ", sc);
		
		compras.add(compra);
		exibeMsg("produto cadastrado com sucesso!");
	}
	public static void buscarProdutoPorNome(Scanner sc) {
		sc.nextLine();
		String nome = lerString("Digite o nome do produto a ser buscado: ", sc);
		nome = normalizarNome(nome);
		for (Compra compra : compras) {
			if (compra.nome.equalsIgnoreCase(nome)) {
				exibeMsg("Produto encontrado: " + compra.nome + " - " + compra.quantidade);
				return;
			}
		}
		exibeMsg("Produto não encontrado.");
	}
	public static void listarTodos() {
		String msg = "***Produtos***\n";
		if (compras.isEmpty()) {
			msg += "Nenhum produto cadastrado.";
		} else {
			for (Compra compra : compras) {
				if (compra.quantidade > 10){
				msg += compra.nome + " - " + compra.quantidade + "\n";
				}
			}
		}
		exibeMsg(msg);
	}
	public static String normalizarNome(String nome) {
		return nome.trim().toLowerCase().replaceAll("\\s+", "");
	}
}
