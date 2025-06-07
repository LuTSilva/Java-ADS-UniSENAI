package matematicaEProgramacao;

import java.util.Scanner;
public class exercicio04PrevisaoEstoque {
// Uma papelaria quer prever o estoque necessário para o próximo mês 
// com base nas vendas dos últimos 6 meses

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double vendas = lerDouble("Informe a quantia vendida nos últimos 6 meses: ", sc);
        double mediaMensal = vendas / 6;

        System.out.printf("Previsão de estoque necessário para o próximo mês: %.0f\n", mediaMensal);

        sc.close();
    }
    public static double lerDouble(String msg, Scanner sc) {
        System.out.print(msg);
        return sc.nextDouble();
    }
}