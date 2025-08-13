package bilhetesOnibus;

import java.util.Scanner;

/*
 * Uma empresa de transporte quer criar um sistema simples para controlar bilhetes de ônibus.
Cada bilhete tem:

Número do bilhete (inteiro, gerado automaticamente)

Nome do passageiro

Saldo disponível

Tarifa fixa da passagem (R$ 4,50)

Regras:

O saldo e o número do bilhete não podem ser alterados diretamente por código externo.

O sistema deve permitir:

Adicionar saldo ao bilhete.

Utilizar o bilhete (diminuindo o saldo ao pagar a passagem).

Consultar saldo.

Se o saldo for menor que o valor da tarifa, a viagem não pode ser realizada e o sistema deve avisar.

Desafio para os alunos
Criar uma classe BilheteOnibus com atributos privados.

Usar métodos públicos para manipular os atributos (get e set apenas onde fizer sentido).

Implementar validações dentro dos métodos, por exemplo:

Não permitir adicionar saldo negativo.

Não permitir viagem se não houver saldo suficiente.

Criar uma classe Main para testar.
 */
public class Bilhetes {
    String passageiro;
    double saldo;

    private static int contadorBilhetes = 0;
    private final int numeroBilhete;
    static final double TARIFA = 4.50;

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
        return TARIFA;
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
    @Override
    public String toString() {
        return "Bilhete{" +
                "numeroBilhete=" + numeroBilhete +
                ", passageiro='" + passageiro + '\'' +
                ", saldo=" + saldo +
                '}';
    }
    
}
