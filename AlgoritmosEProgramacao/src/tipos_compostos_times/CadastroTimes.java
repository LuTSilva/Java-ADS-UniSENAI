package tipos_compostos_times;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroTimes {

	static List<Time> times = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int op = 0;
		do {
			op = menu(sc);
			if (op == 1) cadastraTime(sc);
			if (op == 2) buscaTime(sc);
			if (op == 3) exibeTimeMaisGols();
		} while (op != 4);
		
		sc.close();

	}
	static void cadastraTime(Scanner sc) {
		sc.nextLine();
		Time t = new Time();
		t.nome = lerString("Nome do Time: ", sc);
		t.pais = lerString("Nome do País: ", sc);
		t.gols = lerInt("Quantidade de Gols: ", sc);
		times.add(t);
	}
	
	static void buscaTime(Scanner sc) {
		sc.nextLine();
		String nmBusca = lerString("Qual time deseja buscar? ", sc);
		for (Time t : times) {
			if(t.nome.equalsIgnoreCase(nmBusca)) {
				mostraDados(t);
				return;
			}
		}
	}
	static int menu(Scanner sc) {
		String m = "1 - Cadastrar \n"
				+ "2 - Buscar \n"
				+ "3 - Time com mais gols \n"
				+ "4 - Sair \n";
		return lerInt(m, sc);
	}
	static void exibeTimeMaisGols() {
		Time mais = times.get(0);
		for (Time t : times) {
			if (t.gols > mais.gols) {
				mais = t;
			}
		}
		System.out.println("Time com mais gols:");
		mostraDados(mais);
	}
	static void mostraDados(Time t) {
		String msg = "Nome do Time: " + t.nome + "\n"
				+ "País: " + t.pais + "\n"
				+ "Quantidade de gols: " + t.gols;
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
