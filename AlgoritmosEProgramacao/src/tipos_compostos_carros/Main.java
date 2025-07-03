package tipos_compostos_carros;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import tipos_compostos_times.Time;

public class Main {

	static List<Carro> carros = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int op = 0;
		do {
			op = menu(sc);
			if (op == 1) cadastraCarro(sc);
			if (op == 2) buscaTime(sc);
			if (op == 3) listaPorMarca(sc);
			if (op == 4) listaPorCor(sc);
		} while (op != 5);
		
		sc.close();

	}
	static int menu(Scanner sc) {
		String m = "1 - Cadastrar Carro \n"
				+ "2 - Listar carros por Fabricação \n"
				+ "3 - Listar carros por marca \n"
				+ "4 - Listar carros por cor \n"
				+ "5 - Sair \n";
		return lerInt(m, sc);
	}
	static void cadastraCarro(Scanner sc) {
		sc.nextLine();
		Carro c = new Carro();
		c.nome = lerString("Nome do Carro: ", sc);
		c.marca = lerString("Marca do Carro: ", sc);
		c.cor = lerString("Cor do Carro: ", sc);
		carros.add(c);
	}
	static void listaPorMarca(Scanner sc) {
		sc.nextLine();
		String nmBusca = lerString("Qual marca deseja buscar? ", sc);
		for (Carro c : carros) {
			if(c.marca.equalsIgnoreCase(nmBusca)) {
				mostraDados(c);
				return;
			}
		}
	}
	static void listaPorCor(Scanner sc) {
		sc.nextLine();
		String nmBusca = lerString("Qual cor deseja buscar? ", sc);
		for (Carro c : carros) {
			if(c.cor.equalsIgnoreCase(nmBusca)) {
				mostraDados(c);
				return;
			}
		}
	}
	static void mostraDados(Carro c) {
		String msg = "Nome do Carro: " + c.nome + "\n"
				+ "Marca: " + c.marca + "\n"
				+ "Cor: " + c.cor;
		System.out.println(msg);
	}
	static String lerString(String msg, Scanner sc) {
		System.out.print(msg);
		return sc.nextLine();
	}
	public static int lerInt(String msg, Scanner sc) {
		System.out.print(msg);
		while (!sc.hasNextInt()) {
			sc.next();
			System.out.print("Entrada inválida. " + msg);
		}
		return sc.nextInt();
	}
}
