package avaliacao2_java;

import java.util.Scanner;

public class Avaliacao1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = lerInt("Informe o numero N: ", sc);
		int soma = somatorio (n, sc);
		exibeMsg("Resultado: " + calculaMedia(soma, n));
		
		
	}
	public static int lerInt(String msg, Scanner sc) {
        System.out.print(msg);
        return sc.nextInt();
    }
	public static void exibeMsg(String msg) {
        System.out.println(msg);
    }
	public static int somatorio(int n, Scanner sc) {
		int numero = 0;
		int soma = 0;
		
		for (int i = 1; i <= n; i++) {
			numero = lerInt("Informe o próximo numero: ", sc);
			soma += numero;
		}
		return soma;
	} 
	public static int calculaMedia (int somatorio, int n) {
		return somatorio / n;
	}
	
}
