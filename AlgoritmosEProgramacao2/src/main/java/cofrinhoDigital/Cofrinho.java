package cofrinhoDigital;
/*
Você foi contratado para criar um Cofrinho Digital para crianças aprenderem a guardar dinheiro.
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

import java.util.Scanner;

public class Cofrinho {
    private String nome;
    private double saldo;
    private double meta;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        Scanner sc = new Scanner(System.in);
        while (saldo < 0) {
            System.out.print("Saldo não pode ser negativo. Digite novamente: ");
            saldo = sc.nextDouble();
        }
        this.saldo = saldo;
    }

    public double getMeta() {
        return meta;
    }

    public void setMeta(double meta) {
        Scanner sc = new Scanner(System.in);
        while (meta < this.saldo) {
            System.out.print("A meta não pode ser menor que o saldo atual. Digite novamente: ");
            meta = sc.nextDouble();
        }
        this.meta = meta;
    }
    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            System.out.println("Depósito realizado com sucesso! Saldo atual: R$ " + this.saldo);
        } else {
            System.out.println("Valor de depósito inválido. Deve ser positivo.");
        }
    }
    public void retirar(double valor) {
        if (valor > 0 && valor <= this.saldo) {
            this.saldo -= valor;
            System.out.println("Retirada realizada com sucesso! Saldo atual: R$ " + this.saldo);
        } else if (valor > this.saldo) {
            System.out.println("Saldo insuficiente para a retirada.");
        } else {
            System.out.println("Valor de retirada inválido. Deve ser positivo.");
        }
    }
    public void metaAtingida() {
        if (this.saldo >= this.meta) {
            System.out.println("""
                               Parabéns!
                               A meta de R$ """ + this.meta + " foi atingida com sucesso!");
        } else {
            System.out.println("A meta de R$ " + this.meta + " ainda não foi atingida. \n"+
            "Saldo atual: R$ " + this.saldo);
        }
    }
    public void alterarMeta(double novaMeta) {
        if (novaMeta >= this.saldo) {
            this.meta = novaMeta;
            System.out.println("Meta alterada com sucesso! Nova meta: R$ " + this.meta);
        } else {
            System.out.println("""
                               A nova meta não pode ser menor que o saldo atual
                               (R$ """ + this.saldo + ").");
        }
    }
    public int menu(Scanner sc) {
        System.out.println("\nMenu:");
        System.out.println("1. Depositar dinheiro");
        System.out.println("2. Retirar dinheiro");
        System.out.println("3. Alterar meta");
        System.out.println("4. Verificar se a meta foi atingida");
        System.out.println("0. Sair");
        return lerInt("Escolha uma opção: ", sc);
    }
    static int lerInt(String msg, Scanner sc) {
        System.out.print(msg);
        return sc.nextInt();
    }
}
