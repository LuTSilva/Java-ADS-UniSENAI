package cofrinhoDigital;

import java.util.Scanner;
/*
 * Você foi contratado para criar um Cofrinho Digital para crianças aprenderem a guardar dinheiro.
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

        // Definir meta antes de depositar
        double meta;
        while (true) {
            System.out.print("Defina uma meta de economia: ");
            meta = sc.nextDouble();
            if (meta < 0) {
            System.out.println("Meta inválida. Deve ser positiva.");
            } else {
            cofre.setMeta(meta);
            break;
            }
        }

        double valor;
        while (true) {
            System.out.print("Digite um valor para depositar no cofre: ");
            valor = sc.nextDouble();
            if (valor < 0) {
            System.out.println("Valor inválido. O depósito deve ser positivo.");
            } else {
            cofre.depositar(valor);
            System.out.println("Saldo atual: R$ " + cofre.getSaldo());
            }

            System.out.print("Deseja depositar mais? (s/n): ");
            String opcao = sc.next();
            if (!opcao.equalsIgnoreCase("s")) {
            break;
            }
        }

        // Perguntar se deseja alterar a meta
        System.out.print("Deseja alterar a meta? (s/n): ");
        String alterarMeta = sc.next();
        if (alterarMeta.equalsIgnoreCase("s")) {
            while (true) {
            System.out.print("Informe a nova meta de economia: ");
            double novaMeta = sc.nextDouble();
            if (novaMeta < cofre.getSaldo()) {
                System.out.println("A meta não pode ser menor que o saldo atual (R$ " + cofre.getSaldo() + ").");
            } else {
                cofre.setMeta(novaMeta);
                break;
            }
            }
        }

        if (cofre.getSaldo() >= cofre.getMeta()) {
            System.out.println("Parabéns! Você atingiu sua meta de economia!");
        } else {
            System.out.println("Você ainda não atingiu sua meta. Continue economizando!");
        }
    }
}
