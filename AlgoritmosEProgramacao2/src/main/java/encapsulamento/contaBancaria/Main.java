package encapsulamento.contaBancaria;

public class Main {
    public static void main(String[] args){

        ContaBancaria conta = new ContaBancaria();
        conta.depositar(1000);
        conta.sacar(1500);
        conta.sacar(200);

    }
}
