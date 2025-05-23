package avaliacao_java;

import java.util.Scanner;

public class avaliacao2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite o andar desejado, de 1 à 5: ");
		int andar = sc.nextInt();
		String andarSelecionado = "";

		switch (andar) {
			case 1:
				andarSelecionado = "Garagem";
				break;
			case 2:
				andarSelecionado = "Praça de alimentação";
				break;
			case 3:
				andarSelecionado = "Parque";
				break;
			case 4:
				andarSelecionado = "Lojas 1";
				break;
			case 5:
				andarSelecionado = "Lojas 2";
				break;
			default:
				System.out.println("Andar inválido.");
		}

		if (!andarSelecionado.isEmpty()) {
			System.out.println("O Andar selecionado: " + andarSelecionado);
		}
		sc.close();
	}
	

}
