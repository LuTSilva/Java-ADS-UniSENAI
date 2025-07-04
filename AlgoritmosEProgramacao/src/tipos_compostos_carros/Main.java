package tipos_compostos_carros;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Faça um programa que apresente para o usuário um menu com as opções:
1 – Cadastrar Carro
2 – Listar os carros por período de fabricação
3 – Listar carros por marca
4 – Listar carros por cor
5 – Sair
Opção 1: para o cadastro do carro são informados a marca, o ano e a cor.
Opção 2: o usuário deverá informar o ano inicial e o ano final.
Opção 3: o usuário deverá informar a marca.
Opção 4: o usuário deverá escolher a cor.
Para todas as listagens, deve ser informado o percentual dos carros listados em relação ao total
cadastrado.
Somente poderão ser inseridos no cadastro se todos os atributos forem preenchidos */

public class Main {

	static List<Carro> carros = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int op = 0;
		do {
			op = menu(sc);
			if (op == 1) cadastraCarro(sc);
			if (op == 2) listaCarrosAno(sc);
			if (op == 3) lista(true, sc);
			if (op == 4) lista(false, sc);
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
		c.marca = lerString("Marca do Carro: ", sc);
		c.cor = lerString("Cor do Carro: ", sc);
		c.ano = lerInt("Ano do Carro: ", sc);
		carros.add(c);
	}
	static void lista(boolean marca, Scanner sc) {
		sc.nextLine();
		String msg = "Informe a ";
		if (marca) {
			msg += "marca do carro: ";
		} else {
			msg += "cor do carro: ";
		}
		String filtro = lerString(msg, sc);
		
		int cont = 0;
		
		for (Carro c : carros) {
			if ((marca && c.marca.equalsIgnoreCase(filtro)) || 
				(!marca && c.cor.equalsIgnoreCase(filtro))) {
				mostraDados(c);
				cont++;
			}
		}
		
		if (cont > 0) {
			double percentual = (double) cont / carros.size() * 100;
			System.out.printf("Percentual de carros listados: %.2f%%\n", percentual);
		} else {
			exibeMsg("Nenhum carro encontrado com o filtro especificado.");
		}
	}
	static void listaCarrosAno(Scanner sc) {
		sc.nextLine();
		int anoInicial = lerInt("Informe o ano inicial: ", sc);
		int anoFinal = lerInt("Informe o ano final: ", sc);
		for (Carro carro : carros) {
			if (carro.ano >= anoInicial && carro.ano <= anoFinal) {
				mostraDados(carro);
			}
		}
	}	
	static void mostraDados(Carro c) {
		exibeMsg("Marca: " + c.marca);
		exibeMsg("Cor: " + c.cor);
		exibeMsg("Ano: " + c.ano);
		exibeMsg("-------------------------");
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
	public static void exibeMsg(String msg) {
		System.out.println(msg);
	}
}
