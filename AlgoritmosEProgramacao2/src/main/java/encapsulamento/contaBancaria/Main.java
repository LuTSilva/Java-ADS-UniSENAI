package encapsulamento.contaBancaria;

public class Main {
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
    public static void main(String[] args){

        ContaBancaria conta = new ContaBancaria();
        conta.depositar(1000);
        conta.sacar(1500);
        conta.sacar(200);

    }
}
