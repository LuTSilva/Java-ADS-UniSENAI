package bilhetesOnibus;

import java.util.Scanner;

public class BilheteOnibus {
    String passageiro;
    double saldo;

    private static int contadorBilhetes = 0;
    private final int numeroBilhete;
    private final double TARIFA = 4.50;

    public BilheteOnibus(String passageiro) {
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
    public void conferirSaldo(double valor) {
        if (valor <= 0) {
            exibeMsg("Valor inválido. O saldo deve ser positivo.");
        } else {
            this.saldo += valor;
            exibeMsg("Adicionado R$ " + valor + " ao saldo do bilhete %d.\n", getNumeroBilhete());
        }
    }
    public boolean utilizarBilhete() {
        if (this.saldo < TARIFA) {
            exibeMsg("""
                               Saldo insuficiente para realizar a viagem. 
                               Saldo atual: R$ """ + this.saldo);
            return false;
        } else {
            this.saldo -= TARIFA;
            exibeMsg("""
                
                               Viagem realizada com sucesso. 
                               Saldo restante: R$ """ + this.saldo);
            return true;
        }
    }
    public void consultarSaldo() {
        exibeMsg("Saldo atual do bilhete " + this.numeroBilhete + ": R$ " + this.saldo);
    }
    public void adicionarSaldo(Scanner sc) {
        double valor;
        String opcao = "";
        while (!opcao.equalsIgnoreCase("n")) {
            valor = lerDouble("Digite o valor para adicionar ao saldo: ", sc);
            if (valor < 0) {
            exibeMsg("Valor negativo não permitido. Tente novamente.");
            continue;
            }
            conferirSaldo(valor);
            exibeMsg("\n%s, Deseja adicionar mais saldo? (digite 'n' caso não): ", 
            getPassageiro());
            opcao = sc.next();
            sc.nextLine();
        }
    }
    static double lerDouble(String msg, Scanner sc) {
        System.out.print(msg);
        return sc.nextDouble();
    }
    static void exibeMsg(String msg, Object... args) {
        System.out.printf(msg, args);
    }
    
}
