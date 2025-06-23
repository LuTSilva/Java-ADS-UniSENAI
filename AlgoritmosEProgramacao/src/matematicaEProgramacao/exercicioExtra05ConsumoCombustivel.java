package matematicaEProgramacao;

import java.util.Scanner;

public class exercicioExtra05ConsumoCombustivel {
    // Um carro percorre 12 km com 1 litro de gasolina. 
    // Crie um programa que leia a distância digitada pelo usuário e 
    // informe quantos litros ele vai precisar.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double distancia = lerDouble("Informe a distância (KM): ", sc);
        double consumoPorLitro = 12;

        double autonomia = calcularAutonomia(distancia, consumoPorLitro);

        System.out.printf("Serão necessários %.2f litros.\n", autonomia);
        sc.close();
    }
    public static double calcularAutonomia(double distancia, double consumoPorLitro) {
        return distancia / consumoPorLitro;
    }
    public static double lerDouble(String msg, Scanner sc) {
        System.out.print(msg);
        return sc.nextDouble();
    }
}
