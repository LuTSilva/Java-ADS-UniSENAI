package avaliacao2_java;

import java.util.Scanner;

public class Avaliacao4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num1 = lerInt("Informe o Primeiro numero: ", sc);
		int num2 = lerInt("Informe o Segundo numero: ", sc);
		int num3 = lerInt("Informe o Terceiro numero: ", sc);
		
		exibeMsg("O numero maior é: " + calculaMaior(num1, num2, num3));
		exibeMsg("O numero menor é: " + calculaMenor(num1, num2, num3));
		exibeMsg(validarIgual(num1, num2, num3));;
		
		sc.close();

	}
	public static int calculaMaior(int num1, int num2, int num3) {
		
		if (num1 > num2 && num1 > num3) {return num1; } 
		if (num2 > num3 && num2 > num1) {return num2; } 
		else return num3;
	}
	public static int calculaMenor(int num1, int num2, int num3) {
		
		if (num1 < num2 && num1 < num3) {return num1; } 
		if (num2 < num3 && num2 < num1) {return num2; } 
		else return num3;
	}
	public static boolean verificaIgual(int num1, int num2, int num3) {
		return (num1 == num2 || num1 == num3 || num2 == num3);
	}
	public static String validarIgual(int num1, int num2, int num3) {
		if (!verificaIgual(num1, num2, num3)) {
			return "Nenhum numero igual!";
		}
		return "Número igual encontrado!";
	}
	
	public static void exibeMsg (String msg) {
		System.out.println(msg);
	}
	public static int lerInt(String msg, Scanner sc) {
        System.out.print(msg);
        return sc.nextInt();
    }
}
