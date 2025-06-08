package matematicaEProgramacao;

import java.util.Scanner;

public class exercicio10DivisorDeContas {
    // Um grupo de amigos foi a um restaurante. 
    // Eles querem dividir a conta igualmente e ainda calcular o valor com os 10% de gorjeta.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o valor da conta: ");
        double valorConta = sc.nextDouble();
        if (valorConta <= 0) {
            System.out.println("Valor da conta deve ser maior que zero.");
            sc.close();
            return;
        }
        System.out.print("Digite o número de amigos: ");
        int numeroAmigos = sc.nextInt();
        if (numeroAmigos <= 0) {
            System.out.println("Número de amigos deve ser maior que zero.");
            sc.close();
            return;
        }
        double gorjeta = 0.10; // Gorjeta de 10%
        
        // Calcula o valor da conta com gorjeta
        double valorComGorjeta = valorConta + (valorConta * gorjeta);
        
        // Calcula o valor que cada amigo deve pagar
        double valorPorAmigo = valorComGorjeta / numeroAmigos;

        // Exibe o resultado
        System.out.printf("Valor total da conta: R$ %.2f%n", valorConta);
        System.out.printf("Valor com gorjeta: R$ %.2f%n", valorComGorjeta);
        System.out.printf("Valor por amigo: R$ %.2f%n", valorPorAmigo);
        sc.close();
    }
}
