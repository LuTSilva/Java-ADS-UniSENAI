package cofrinhoDigital;

import java.util.Scanner;
/*
 Você foi contratado para criar um Cofrinho Digital para crianças 
aprenderem a guardar dinheiro.
O cofrinho deve ter:
Nome do dono
Saldo (não pode ser negativo)
Meta de economia (valor que a criança quer atingir)

Regras:
O saldo não pode ser alterado diretamente.
É possível depositar dinheiro e retirar (somente se tiver saldo suficiente).
A meta pode ser alterada, mas não pode ser menor que o saldo atual.
Criar método que diga se a meta foi atingida.
 */
public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Cofrinho cofre = new Cofrinho();

        System.out.print("Digite o nome do dono do cofre: ");
        cofre.setNome(sc.nextLine());

        cofre.setSaldo(lerDouble("Digite o saldo inicial do cofre: ", sc));
        cofre.setMeta(lerDouble("Digite a meta de economia do cofre: ", sc));
        sc.nextLine();
        
        int op;
        do {
            op = cofre.menu(sc);
            sc.nextLine(); // Limpar o buffer do scanner
            
            switch (op) {
                case 1 -> {
                    double deposito = lerDouble("Digite o valor a ser depositado: ", sc);
                    cofre.depositar(deposito);
                }
                case 2 -> {
                    double retirada = lerDouble("Digite o valor a ser retirado: ", sc);
                    cofre.retirar(retirada);
                }
                case 3 -> {
                    double novaMeta = lerDouble("Digite a nova meta de economia: ", sc);
                    cofre.alterarMeta(novaMeta);
                }
                case 4 -> {
                    cofre.metaAtingida();
                }
                case 0 -> {
                    System.out.println("Saindo...");
                    return;
                }
                default -> System.out.println("Opção inválida, tente novamente.");
            }
        }  while (op != 5);
        sc.close();
    } 
    static double lerDouble(String msg, Scanner sc) {
        System.out.print(msg);
        return sc.nextDouble();
    }
}
