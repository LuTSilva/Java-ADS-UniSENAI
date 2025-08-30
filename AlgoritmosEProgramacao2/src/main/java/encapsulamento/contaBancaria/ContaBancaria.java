package encapsulamento.contaBancaria;
/*
Um banco deseja informatizar o controle das contas de seus clientes. 
Cada conta deve ter um número e um saldo, mas esses dados não podem ser acessados diretamente, apenas por meio de métodos seguros.

O que deve ser feito:
Crie a classe ContaBancaria com os atributos privados:
numeroConta (String)
saldo (double).

Implemente métodos:
depositar(double valor) → soma o valor ao saldo.
sacar(double valor) → subtrai o valor do saldo somente se houver saldo suficiente.
getSaldo() → retorna o saldo atual.

No programa principal (main):
Crie uma conta, deposite R$1000, tente sacar R$1500 (não deve permitir), 
depois saque R$200 e exiba o saldo final.
 */

public class ContaBancaria {
    private String numeroConta;
    private double saldo;

    public String getNumeroConta() {
        return numeroConta;
    }
    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }
    public double getSaldo(){
        return saldo;
    }
    public void setSaldo(double saldo){
        this.saldo = saldo;
    }
    void depositar(double valor){
        this.saldo+=valor;
        System.out.printf("Valor R$ %.2f adicionado com sucesso ao saldo \n", valor);
    }
    void sacar(double valor){
        if (this.saldo>=valor){
            this.saldo-=valor;
            System.out.println("Saque realizado com sucesso! \nSaldo atual: R$ " + this.saldo);
        } else {
            System.out.println("Saldo insuficiente para operação");
            System.out.println("Saldo atual: " + this.saldo);
        }
    }


}
