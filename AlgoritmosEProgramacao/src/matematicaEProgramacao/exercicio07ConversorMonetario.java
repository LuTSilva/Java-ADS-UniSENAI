package matematicaEProgramacao;

import java.util.Scanner;

public class exercicio07ConversorMonetario {
// Uma pessoa vai viajar para outro país e precisa converter o valor em reais (R$) para 
// dólares (US$), euros (€) e outras moedas. 
// O sistema deve permitir digitar a cotação e fazer o cálculo automaticamente
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double reais = lerDouble("Informe a quantia em Reais para conversão: ", sc);
        double cotacao = lerDouble("Informe a cotação da moeda estrangeira: ", sc);
        double moedaEstrangeira = converterMoeda(reais, cotacao);
        exibirResultado(moedaEstrangeira);

        sc.close();
    }
    public static double lerDouble(String msg, Scanner sc) {
        System.out.print(msg + ": ");
        return sc.nextDouble();
    }
    public static boolean validarCotacao(double cotacao) {
        return cotacao > 0;
    }
    public static double converterMoeda(double reais, double cotacao) {
        if (validarCotacao(cotacao)) {
            return reais / cotacao;
        } else {
            System.out.println("Cotação inválida! Deve ser maior que zero.");
            return -1; // Retorna -1 para indicar erro
        }
    }
    public static void exibirResultado(double moedaEstrangeira) {
        if (moedaEstrangeira >= 0) {
            System.out.printf("Valor convertido: %.2f%n", moedaEstrangeira);
        } else {
            System.out.println("Erro na conversão.");
        }
    }
}
