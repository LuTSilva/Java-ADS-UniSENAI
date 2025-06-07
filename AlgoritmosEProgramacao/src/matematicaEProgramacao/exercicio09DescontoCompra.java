package matematicaEProgramacao;

import java.util.Scanner;

public class exercicio09DescontoCompra {
    // Um e-commerce quer mostrar o valor final com desconto aplicado, 
    // baseado em cupons de 10%, 20% ou 30%.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op;
        do { 
            menu();
            op = sc.nextInt();
            aplicarDesconto(sc, op);

        } while (op != 5);
        sc.close();
    }
    public static void aplicarDesconto(Scanner sc, int op) {
        switch (op) {
            case 1 -> calcularDesconto(10, sc);
            case 2 -> calcularDesconto( 20, sc);
            case 3 -> calcularDesconto( 30, sc);
            case 4 -> descontoPersonalizado(sc);
            case 5 -> System.out.println("Saindo do programa...");
            default -> System.out.println("Opção inválida. Tente novamente.");
        }
    }
    public static void calcularDesconto(double percentual, Scanner sc) {
        double valor = lerDouble("Digite o valor do produto", sc);
        double desconto = valor * (percentual / 100);
        double valorFinal = valor - desconto;
        System.out.printf("Desconto: R$ %.2f%n", desconto);
        System.out.printf("Valor final: R$ %.2f%n", valorFinal);
    }
    public static double lerDouble(String msg, Scanner sc) {
        System.out.print(msg + ": ");
        return sc.nextDouble();
    }
    public static void menu() {
        System.out.println("Menu de Descontos:");
        System.out.println("1 - Aplicar desconto de 10%");
        System.out.println("2 - Aplicar desconto de 20%");
        System.out.println("3 - Aplicar desconto de 30%");
        System.out.println("4 - Aplicar desconto personalizado");
        System.out.println("5 - Sair");
        System.out.print("Escolha uma opção: ");
    }
    public static void descontoPersonalizado(Scanner sc) {
        System.out.print("Informe o percentual de desconto: ");
        double percentual = sc.nextDouble();
        if (percentual < 0 || percentual >= 100) {
            System.out.println("Percentual inválido! Deve ser entre 0 e 99,99%.");
            return;
        }
        calcularDesconto(percentual, sc);
    }

}
