package avaliacao_3_java;

import java.util.Scanner;

public class avaliacao2 {
	// 
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double salario = lerDouble("Informe seu salário base: ", sc);
        double valorVenda = lerDouble("Informe o valor total de venda: ", sc);
        double comissao = calcularComissao(valorVenda);
        exibeMsg("A comissão é: R$ %.2f\n", comissao);
        exibeMsg("Salário final: R$ %.2f\n", (salario + comissao));
        sc.close();
    }

    public static double calcularComissao(double valorVenda) {
    	double taxaComissao = 0;
    	if (valorVenda > 20000)
    		 taxaComissao= 0.2;
    	else
    		taxaComissao = 0.1;
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

