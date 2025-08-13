package encapsulamento;

public class ContaBancariaMain {
    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria("Luan", 10000);

        conta.depositar(800);
        conta.sacar(300);

        exibeMsg("Titular " + conta.getTitular());
        exibeMsg("Saldo " + conta.getSaldo());
    }

    static void exibeMsg(String msg) {
        System.out.println(msg);
    }
}
