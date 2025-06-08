package matematicaEProgramacao;

import java.util.Scanner;

public class exercicio12CrescimentoPopulacional {
    // Uma cidade cresce a uma taxa de 2% ao ano. Os alunos devem prever a população daqui a 10 anos

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double populacaoAtual = lerDouble("Informe a população atual", sc);
        double taxaCrescimento = 0.02; // Taxa de crescimento de 2%
        int anos = 10; // Período de 10 anos

        double populacaoFutura = calcularPopulacaoFutura(populacaoAtual, taxaCrescimento, anos);
        System.out.printf("População futura em %d anos: %.0f%n", anos, populacaoFutura);
        sc.close();
    }
    public static double calcularPopulacaoFutura(double populacaoAtual, double taxaCrescimento, int anos) {
        return populacaoAtual * Math.pow(1 + taxaCrescimento, anos);
        // A fórmula é: P = P0 * (1 + r)^t
        // onde P é a população futura, P0 é a população atual, 
        // r é a taxa de crescimento e t é o tempo em anos.
    }
    public static double lerDouble(String msg, Scanner sc) {
        System.out.print(msg + ": ");
        return sc.nextDouble();
    }
}
