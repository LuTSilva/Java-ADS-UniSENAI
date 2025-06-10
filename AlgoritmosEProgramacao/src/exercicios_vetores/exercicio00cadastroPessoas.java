package exercicios_vetores;

import java.util.Scanner;

public class exercicio00cadastroPessoas {
	static String nomes[] = new String[100];
	static int idades[] = new int[100];
	static int count = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int op = 0;
		do {
			op = menu(sc);
			switch (op) {
			case 1 -> cadastrar(sc);
			case 2 -> buscarPosicao(sc);
			case 3 -> listarTodos();
			case 4 -> exibeMsg("Finalizando");
			default -> exibeMsg("Posicao inválida");
			}
		} while (op != 4);
		
		sc.close();
	}
	public static void listarTodos() {
		String msg = "***Pessoas Cadastradas***\n";
		for (int i = 0; i<count; i++) {
			msg +=(i+1) + ": " + nomes[i] + " - " + idades[i] + "\n";
		}
		exibeMsg(msg);
	}
	public static void buscarPosicao(Scanner sc) {
		int pos = lerInt("Qual posição deseja buscar? ", sc);
		if (pos <= count && pos > 0) {
			exibeMsg(nomes[pos-1] + " - " + idades[pos-1]);
		} else {
			exibeMsg("Posição Inválida!");
		}
	}
	public static void cadastrar(Scanner sc) {
		if (count < 100) {
			nomes[count] = lerString("Digite a " + (count +1) + "ª pessoa ", sc);
			idades[count] = lerInt("Idade de " + nomes[count] + " ", sc);
			count++;
		} else {
			exibeMsg("Cadastro ultrapassa o limite de 100 pessoas");
		}
	}
    public static int lerInt(String msg, Scanner sc) {
        System.out.print(msg);
        return sc.nextInt();
    }
    public static void exibeMsg(String msg) {
        System.out.println(msg);
    }
    
    public static String lerString(String msg, Scanner sc) {
        System.out.print(msg);
        sc.nextLine();
        return sc.nextLine();
    }
    public static int menu(Scanner sc) {
    	String msg = "1 - Cadastrar \n"
    			+ "2 - Busca por Posição \n"
    			+ "3 - Listar todos \n"
    			+ "4 - Sair \n";
    	return lerInt(msg, sc);
    }
}
