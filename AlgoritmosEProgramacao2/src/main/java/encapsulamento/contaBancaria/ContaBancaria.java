package encapsulamento.contaBancaria;

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
