package bilhetesOnibus;

import java.util.Scanner;

public class Bilhetes {
    String passageiro;
    double saldo;

    private static int contadorBilhetes = 0;
    private final int numeroBilhete;
    private final double TARIFA = 4.50;

    public Bilhetes(String passageiro) {
        this.passageiro = passageiro;
        this.saldo = 0.0;
        this.numeroBilhete = ++contadorBilhetes;
    }
    public int getNumeroBilhete() {
        return numeroBilhete;
    }
    public String getPassageiro() {
        return passageiro;
    }
    public double getSaldo() {
        return saldo;
    }
    public double getTarifa() {
        return this.TARIFA;
    }
    public void adicionarSaldo(double valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido. O saldo deve ser positivo.");
        } else {
            this.saldo += valor;
            System.out.println("Saldo adicionado com sucesso. Novo saldo: R$ " + this.saldo);
        }
    }
    public boolean utilizarBilhete() {
        if (this.saldo < TARIFA) {
            System.out.println("Saldo insuficiente para realizar a viagem. Saldo atual: R$ " + this.saldo);
            return false;
        } else {
            this.saldo -= TARIFA;
            System.out.println("Viagem realizada com sucesso. Saldo restante: R$ " + this.saldo);
            return true;
        }
    }
    public void consultarSaldo() {
        System.out.println("Saldo atual do bilhete " + this.numeroBilhete + ": R$ " + this.saldo);
    }
    
}
