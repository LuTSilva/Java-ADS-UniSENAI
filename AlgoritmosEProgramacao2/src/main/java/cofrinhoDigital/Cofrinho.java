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
        this.saldo = saldo;
    }

    public double getMeta() {
        return meta;
    }

    public void setMeta(double meta) {
        this.meta = meta;
    }
    public void depositar(double valor){
        if (valor >0){
            this.saldo+=valor;
        } else {
            System.out.println("Valor inválido para depósito!");
        }
    }
    public void sacar(double valor){
        if (valor >0 && valor <= saldo){
            this.saldo-=valor;
        } else {
            System.out.println("Saldo insuficiente ou valor inválido!");
        }
    }
    public void verificaMeta(){
        if (meta > 0 && meta <= saldo){
            System.out.println("Meta atingida!");
        } else {
            System.out.println("Meta não atingida!");
        }
    }
    public void meta(){
        Scanner sc = new Scanner(System.in);
        while (meta < 0 || meta <= saldo){
            System.out.println("Informe um ");
        }
        sc.close();
    }
    public static double lerDouble(String msg, Scanner sc) {
        System.out.print(msg);
        return sc.nextDouble();
    }
}
