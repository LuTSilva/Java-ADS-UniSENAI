package matematicaEProgramacao;

import java.util.Scanner;

public class exercicio05ConsumoCombustivel {
    // Um aluno quer planejar uma viagem e saber se o combustível será suficiente. 
    // Eles devem calcular a autonomia e o consumo
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double distancia = lerDouble("Informe a distância (KM): ", sc);
        double consumoPorLitro = lerDouble("Informe o consumo por litro: ", sc);
        double precoPorLitro = lerDouble("Informe o preço por litro: ", sc);

        double autonomia = calcularAutonomia(distancia, consumoPorLitro);
        double custoViagem = calcularCustoViagem(autonomia, precoPorLitro);

        System.out.printf("A autonomia da viagem é de %.2f litros.\n", autonomia);
        System.out.printf("O custo total da viagem será de R$ %.2f.\n", custoViagem);
        sc.close();
    }
    public static double calcularAutonomia(double distancia, double consumoPorLitro) {
        return distancia / consumoPorLitro;
    }
    public static double calcularCustoViagem(double autonomia, double precoPorLitro) {
        return autonomia * precoPorLitro;
    }
    public static double lerDouble(String msg, Scanner sc) {
        System.out.print(msg);
        return sc.nextDouble();
    }
}
