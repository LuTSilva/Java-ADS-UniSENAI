package exercicios_metodos;

import java.util.Scanner;

public class Exercicio03 {

	public static void main(String[] args) {
		//  3 - Desenvolva um sistema para monitorar a temperatura de uma sala de servidores. 
		// O sistema deve:
 		// • Perguntar qual é o limite inferior e superior de temperatura.
 		// • Registrar uma única medição de temperatura.
 		// • Informar se a temperatura registrada está dentro dos limites seguros.
 		// • Calcular a diferença da temperatura atual em relação ao valor médio do limite.
 		// • Fornecer um aviso se a temperatura ultrapassar um limite crítico

		Scanner sc = new Scanner(System.in);
		double min = lerDouble("Temperatura mínima", sc);
		double max = lerDouble("Temperatura máxima", sc);
		double atual = lerDouble("Temperatura atual", sc);
		System.out.println(verificaLimite(max, min, atual));
		System.out.println("Diferença em relação à média: " + diferenca(max, min, atual));
		alerta(max, atual);
		
		sc.close();
	}
	public static double lerDouble(String msg, Scanner sc) {
		System.out.print(msg + ": ");
		return sc.nextDouble();
	}
	public static String verificaLimite(double max, double min, double atual) {
		if (atual >= min && atual <= max) 
			return "Está na faixa permitida";
		return "FORA DO LIMITE";
	}
	public static double diferenca(double max, double min, double atual) {
		double media = (max + min) / 2;
		double diferenca = atual - media;
		if (diferenca < 0) {
			diferenca *= -1;
		}
		return diferenca;
	}
	public static void alerta(double max, double atual) {
		if (atual > max + 5) {
			System.out.println("CORRA VAI EXPLODIR");
		}
	}
}
