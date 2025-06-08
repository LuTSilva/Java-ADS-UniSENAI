package matematicaEProgramacao;

import java.util.Scanner;

public class exercicio11CalculadorAreaEPerimetro {
    // Um cliente deseja saber quanto de grama comprar para cobrir seu terreno
    // e quanto de cerca precisará para contorná-lo. O terreno é retangular.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double comprimento = lerDouble("Digite o comprimento do terreno (em metros)", sc);
        if (comprimento <= 0) {
            System.out.println("Comprimento deve ser maior que zero.");
            sc.close();
            return;
        }
        double largura = lerDouble("Informe a largura do terreno (em metros)", sc);
        if (largura <= 0) {
            System.out.println("Largura deve ser maior que zero.");
            sc.close();
            return;
        }

        double area = calcularArea(comprimento, largura);
        double perimetro = calcularPerimetro(comprimento, largura);

        System.out.printf("Área do terreno: %.2f m²%n", area);
        System.out.printf("Perímetro do terreno: %.2f m%n", perimetro);
        sc.close();
    }
    public static double calcularArea(double comprimento, double largura) {
        return comprimento * largura;
    }
    public static double calcularPerimetro(double comprimento, double largura) {
        return 2 * (comprimento + largura);
    }
    public static double lerDouble(String msg, Scanner sc) {
        System.out.print(msg + ": ");
        return sc.nextDouble();
    }
}
