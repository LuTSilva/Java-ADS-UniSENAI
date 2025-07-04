package avaliacao_3_java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class avaliacao5 {
static List<String> nomes = new ArrayList<>();
static List<Integer> quantidades = new ArrayList<>();
	public static void main(String[] args) {
		// Faça um programa para cadastro de uma lista de compras. A lista é composta pelo
		// nome do produto e a quantidade que deve ser comprada. Na lista poderá ter no
		// máximo 100 itens no caso de utilizar vetores ou no caso de utilizar ArrayList não
		// precisa ter limite. Apresente um menu com as opções:
		// 1 – Cadastrar
		// 2 – Buscar por nome e mostrar a quantidade que precisa ser comprada
		// 3 – Listar todos os produtos que necessitam mais de 10 unidades.
		// 4 – Sair
		// Observação: na busca por nome caso o produto não seja encontrado deve exibir uma
		// mensagem avisando o usuário
		// O programa precisa ter no mínimo os seguintes métodos:
		// ● Exibir menu
		// ● Ler uma string
		// ● Ler um inteiro
		// ● Exibir mensagem
		// ● Um método para cada opção do menu (1,2 e 3)

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
