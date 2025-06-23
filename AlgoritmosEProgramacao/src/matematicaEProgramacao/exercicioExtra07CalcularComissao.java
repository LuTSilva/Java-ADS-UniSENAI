package matematicaEProgramacao;

import java.util.Scanner;

public class exercicioExtra07CalcularComissao {
    // Um funcionário recebe comissão de 12% sobre suas vendas. 
    // Crie um programa que receba o valor de venda e calcule a comissão. 


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double valorVenda = lerDouble("Informe o valor da venda: ", sc);
        double comissao = calcularComissao(valorVenda);
        exibeMsg("A comissão é: R$ %.2f", comissao);
        sc.close();
    }

    public static double calcularComissao(double valorVenda) {
        double taxaComissao = 0.12; // 12%
        return valorVenda * taxaComissao;
    }

    public static void exibeMsg(String msg, Object... args) {
        System.out.printf(msg, args);
    }
    public static double lerDouble(String msg, Scanner sc) {
        System.out.print(msg);
        return sc.nextDouble();
    }
}
