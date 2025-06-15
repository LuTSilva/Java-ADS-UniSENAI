package exercicios_vetores;
import java.util.Scanner;
public class exercicio04 {
// Exercício 4
// Faça um programa que leia 20 números reais e armazene em um vetor.
// Após faça um processamento onde os valores que sejam menores que
// a média dos números serão trocados pela média calculada

static double[] numeros = new double[20];
static double media = 0.0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		cadastrarNumeros(sc);
		exibirNumeros();
		substituirMenoresQueMedia();
		sc.close();
	}
	public static double lerDouble(String msg, Scanner sc) {
		System.out.print(msg);
		while (!sc.hasNextDouble()) { // Verifica se a entrada é um número válido
			sc.next(); // descarta a entrada inválida
			System.out.print("Entrada inválida. " + msg);
		}
		return sc.nextDouble();
	}
	public static void exibeMsg(String msg) {
		System.out.println(msg);
	}
	public static void calcularMedia() {
		double soma = 0.0;
		for (double numero : numeros) {
			soma += numero;
		}
		media = soma / numeros.length;
	}
	public static void cadastrarNumeros(Scanner sc) {
		exibeMsg("Informe 20 números reais:");
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = lerDouble("Número " + (i + 1) + ": ", sc);
		}
		calcularMedia();
	}
	public static void substituirMenoresQueMedia() {
		for (int i = 0; i < numeros.length; i++) {
			if (numeros[i] < media) {
				numeros[i] = media;
			}
		}
		exibeMsg("Números após substituição:");
		for (double numero : numeros) {
			exibeMsg(String.valueOf(numero));
		}
	}
	public static void exibirNumeros() {
		exibeMsg("Números informados:");
		for (double numero : numeros) {
			exibeMsg(String.valueOf(numero));
		}
	}

}
