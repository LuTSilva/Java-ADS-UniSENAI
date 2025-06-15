package exercicios_vetores;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class exercicio06 {
// Exercício 6
// Faça um algoritmo para cadastro de nomes e telefones de pessoas e
// que apresente o seguinte menu (com as respectivas funcionalidades):
// 1 - Cadastrar contato
// 2 - Buscar contato por nome
// 3 - Buscar contato por telefone
// 4 - Sair
// Observação: Caso não exista o contato buscado, deve ser apresentada
// uma mensagem indicando a inexistência.
static List<String> nomes = new ArrayList<>();
static List<String> telefones = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int op;
		do {
			op = menu(sc);
			switch (op) {
				case 1 -> cadastrarContato(sc);
				case 2 -> buscarContatoPorNome(sc);
				case 3 -> buscarContatoPorTelefone(sc);
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
		System.out.println("1 - Cadastrar contato");
		System.out.println("2 - Buscar contato por nome");
		System.out.println("3 - Buscar contato por telefone");
		System.out.println("4 - Sair");
		return lerInt("Escolha uma opção: ", sc);
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
	public static void cadastrarContato(Scanner sc) {
		sc.nextLine(); // Consumir a quebra de linha pendente
		String nome = lerString("Digite o nome do contato: ", sc);
		nome = normalizarNome(nome); // Normaliza o nome para armazenamento
		String telefone = lerString("Digite o telefone do contato: ", sc);
		telefone = normalizarTelefone(telefone); // Normaliza o telefone para armazenamento
		nomes.add(nome);
		telefones.add(telefone);
		exibeMsg("Contato cadastrado com sucesso!");
	}
	public static void buscarContatoPorNome(Scanner sc) {
		sc.nextLine(); // Consumir a quebra de linha pendente
		String nome = lerString("Digite o nome do contato a ser buscado: ", sc);
		nome = normalizarNome(nome); // Normaliza o nome para comparação
		int index = nomes.indexOf(nome);
		if (index != -1) {
			exibeMsg("Contato encontrado: " + nomes.get(index) + " - " + telefones.get(index));
		} else {
			exibeMsg("Contato não encontrado.");
		}
	}
	public static void buscarContatoPorTelefone(Scanner sc) {
		sc.nextLine(); // Consumir a quebra de linha pendente
		String telefone = lerString("Digite o telefone do contato a ser buscado: ", sc);
		telefone = normalizarTelefone(telefone); // Normaliza o telefone para comparação
		int index = telefones.indexOf(telefone);
		if (index != -1) {
			exibeMsg("Contato encontrado: " + nomes.get(index) + " - " + telefones.get(index));
		} else {
			exibeMsg("Contato não encontrado.");
		}
	}
	public static String normalizarTelefone(String telefone) {
		return telefone.trim().replaceAll("[^\\d]", "");
		// \\d corresponde a qualquer dígito, e [^\\d] remove tudo que não for dígito
		// O método replaceAll remove espaços, parênteses, traços e outros caracteres não numéricos
	}
	public static String normalizarNome(String nome) {
		return nome.trim().toLowerCase().replaceAll("\\s+", "");
		// trim() remove espaços no início e no final
		// toLowerCase() converte o nome para minúsculas
		// replaceAll("\\s+", "") remove todos os espaços internos
	}
}
