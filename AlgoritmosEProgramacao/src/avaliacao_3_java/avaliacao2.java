package avaliacao_3_java;

import java.util.Scanner;

public class avaliacao2 {
    public static void main(String[] args) {
        // Um vendedor recebe um salário fixo de X reais e uma comissão em
        // relação ao total de vendas. Esta comissão é feita da seguinte forma: 20% se as vendas
        // forem superiores a R$20.000,00, ou caso contrário, 10%. Faça um programa que peça
        // para o usuário digitar o salário fixo do vendedor e o total de vendas ocorridas durante o
        // mês. Após a leitura, mostre na tela o total que o vendedor deverá ganhar.
        // **Utilize o máximo que conseguir de modularização

        Scanner sc = new Scanner(System.in);

        double salario = lerDouble("Informe seu salário base: ", sc);
        double valorVenda = lerDouble("Informe o valor total de venda: ", sc);
        double comissao = calcularComissao(valorVenda);

        exibeValores(salario, comissao);

        sc.close();
    }

    private static void exibeValores(double salario, double comissao) {
        exibeMsg("A comissão é: R$ %.2f\n", comissao);
        exibeMsg("Salário final: R$ %.2f\n", (salario + comissao));
    }

    public static double calcularComissao(double valorVenda) {
    	double taxaComissao;
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

