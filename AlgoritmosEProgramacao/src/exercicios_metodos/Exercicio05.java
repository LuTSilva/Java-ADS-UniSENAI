package exercicios_metodos;

import java.util.Scanner;

public class Exercicio05 {
    public static void main(String[] args) {
        // 5 - Desenvolva um conversor de moedas que exiba um menu para o usuário:
        // 1 – Real para Dólar
        // 2 – Dólar para Real
        // 3 – Real para Euro
        // 4 – Euro para Real
        // 5 – Sair
        // Para cada operação solicite o valor a ser convertido e exiba a resposta

        iniciarConversor();
    }
    public static double lerDouble(String msg, Scanner sc) {
        System.out.print(msg + ": ");
        return sc.nextDouble();
    }
    public static void exibirMenu() {
        System.out.println("Menu de Conversão de Moedas:");
        System.out.println("1 - Real para Dólar");
        System.out.println("2 - Dólar para Real");
        System.out.println("3 - Real para Euro");
        System.out.println("4 - Euro para Real");
        System.out.println("5 - Real para Yuan");
        System.out.println("6 - Sair");
    }
    public static void paraReal(double cotacao, String nome, Scanner sc) {
        double moeda = lerDouble("Valor em " + nome, sc);
        System.out.printf("%.2f reais%n", (moeda * cotacao));
    }
    public static void paraOutro(double cotacao, String nome, Scanner sc) {
        double reais = lerDouble("Reais", sc);
        System.out.printf("%.2f em %s%n", (reais / cotacao), nome);
    }
    public static int escolheMenu(Scanner sc) {
        exibirMenu();
        System.out.print("Escolha uma opção: ");
        return sc.nextInt();
    }
    public static void realizarConversao(int op, Scanner sc) {
        switch (op) {
            case 1 -> paraOutro(5.67, "Dólar", sc);
            case 2 -> paraReal(5.67, "Dólar", sc);
            case 3 -> paraOutro(6.46, "Euro", sc);
            case 4 -> paraReal(6.46, "Euro", sc);
            case 5 -> paraOutro(0.79, "Yuan", sc);
            default -> System.out.println("Opção inválida.");
            // feito usando lambda
        }
    }
    public static void iniciarConversor() {
        Scanner sc = new Scanner(System.in);
        int op;
        do {
            op = escolheMenu(sc);
            if (op != 6) {
                realizarConversao(op, sc);
            }
        } while (op != 5);
        sc.close();
    }
}