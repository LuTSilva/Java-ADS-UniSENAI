package exercicios_metodos;

import java.util.Scanner;

public class Exercicio06 {
    
    static Scanner sc = new Scanner(System.in);
    // Cadastro de Funcionários e Cálculo de Salário com Bônus
    // Requisitos do Algoritmo:
    // Solicitar ao usuário as seguintes informações:
    // Nome do funcionário Salário base
    // Percentual de bônus (%)
    // Calcular o salário final utilizando a fórmula: 
    // salarioFinal = salarioBase + (salarioBase * percentualBonus 100)
    // Classificar o funcionário de acordo com o salário final:
    // Se SalárioFinal ≥ 5000, classificar como "Alto salário"
    // Se 3000 ≤ SalárioFinal < 5000, classificar como "Médio salário"
    // Se SalárioFinal < 3000, classificar como "Baixo salário"
    // Exibir todas as informações coletadas, o salário final e a classificação.
    public static void main(String[] args) {
       solicitarInformacoes();
    }
    public static void solicitarInformacoes() {

        String nome = lerString("Digite o nome do funcionário: ");
        double salarioBase = lerDouble("Digite o salário base: ");
        double percentualBonus = lerDouble("Digite o percentual de bônus (%): ");

        exibirInformacoes(nome, salarioBase, percentualBonus, 
        calcularSalarioFinal(salarioBase, percentualBonus), 
        classificarSalario(calcularSalarioFinal(salarioBase, percentualBonus)));

        sc.close();
    }    
    public static void exibirInformacoes(String nome, double salarioBase, double percentualBonus, double salarioFinal, String classificacao) {
        System.out.println("\nInformações do Funcionário:");
        System.out.println("Nome: " + nome);
        System.out.println("Salário Base: R$ " + salarioBase);
        System.out.println("Percentual de Bônus: " + percentualBonus + "%");
        System.out.println("Salário Final: R$ " + salarioFinal);
        System.out.println("Classificação: " + classificacao);
    }
    public static double calcularSalarioFinal(double salarioBase, double percentualBonus) {
        return salarioBase + (salarioBase * percentualBonus / 100);
    }
    public static String classificarSalario(double salarioFinal) {
        if (salarioFinal >= 5000) {
            return "Alto salário";
        } else if (salarioFinal >= 3000) {
            return "Médio salário";
        } else {
            return "Baixo salário";
        }
    }
    public static double lerDouble(String msg){
        System.out.print(msg);
        return sc.nextDouble();
    }
    public static String lerString(String msg) {
        System.out.print(msg);
        return sc.nextLine();
    }
}
