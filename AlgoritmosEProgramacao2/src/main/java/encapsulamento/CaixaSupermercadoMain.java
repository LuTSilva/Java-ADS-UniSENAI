package encapsulamento;

public class CaixaSupermercadoMain {
    public static void main(String[] args) {

        CaixaSupermercado caixa = new CaixaSupermercado();
        caixa.adicionarProduto(10.50);
        caixa.adicionarProduto(5.20);

        System.out.printf("Total da compra R$ %.2f", caixa.getTotalCompra());
    }
}
