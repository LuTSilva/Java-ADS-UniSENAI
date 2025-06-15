package exercicios_vetores;

import java.util.Scanner;

public class exercicio02 {
// Exercício 2 - Fazer um programa JAVA que tenha o seguinte menu:
// 1 - Cadastrar Carro
// 2 - Verificar qual a marca e a placa do carro mais novo
// 3 - Buscar a marca e o ano por uma placa específica 
// (o usuário irá informar a placa e o programa vai 
// mostrar os dados caso encontre a respectiva placa).
// 4 - Sair
// Para cadastrar o carro é necessário perguntar 
// a marca, o ano de fabricação e a placa.
// É possível cadastrar no máximo 20 carros.
// Observação - Declarar o vetor com tamanho 20, mas controlar quantos carros 
// foram cadastrados. A opção 1 do menu deve cadastrar um carro por vez

static String[] carros = new String[20];
static int[] anos = new int[20];
static String[] placas = new String[20];
static int contador = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int opcao;
		do {
			opcao = menu(sc);
			switch (opcao) {
				case 1 -> cadastrarCarro(sc);
				case 2 -> verificarCarroMaisNovo();
				case 3 -> buscarPorPlaca(sc);
				case 4 -> exibeMsg("Finalizando o programa.");
				default -> exibeMsg("Opção inválida. Tente novamente.");
			}
		} while (opcao != 4);
		
	}

	public static void cadastrarCarro(Scanner sc) {
		if (contador < 20) {
			carros[contador] = lerString("Informe o nome do " + (contador + 1) + "º carro ", sc);
			anos[contador] = lerInt("Informe o ano de fabricação do carro ", sc);
			placas[contador] = lerString("Informe a placa do carro ", sc);
			contador++;
		} else {
			exibeMsg("Limite de carros cadastrados atingido.");
		}
	}
	public static void verificarCarroMaisNovo() {
		if (contador == 0) {
			exibeMsg("Nenhum carro cadastrado.");
			return;
		}
		int op = 0;
		for (int i = 1; i < contador; i++) {
			if (anos[i] > anos[op]) {
				op = i;
			}
		}
		exibeMsg("Carro mais novo: " + carros[op] + ", Placa: " + placas[op]);
	}
	public static void buscarPorPlaca(Scanner sc) {
		String placa = lerString("Informe a placa do carro que deseja buscar: ", sc);
		for (int i = 0; i < contador; i++) {
			if (placas[i].equalsIgnoreCase(placa)) {
				System.out.println("Marca: " + carros[i] + ", Ano: " + anos[i]);
				return;
			}
		}
		System.out.println("Placa não encontrada.");
	}
	public static int menu(Scanner sc) {
		String msg = "1 - Cadastrar Carro\n"
				+ "2 - Verificar carro mais novo\n"
				+ "3 - Buscar por placa\n"
				+ "4 - Sair\n";
		return lerInt(msg, sc);
	}
	public static void exibeMsg(String msg) {
		System.out.println(msg);
	}
	public static int lerInt(String msg, Scanner sc) {
		System.out.print(msg);
		while (!sc.hasNextInt()) { // Verifica se a entrada é um número válido
			sc.next(); // descarta a entrada inválida
			System.out.print("Entrada inválida. " + msg);
		}
		return sc.nextInt();
	}
	public static String lerString(String msg, Scanner sc) {
		System.out.print(msg);
		sc.nextLine(); // Limpa o buffer
		return sc.nextLine();
	}

}
