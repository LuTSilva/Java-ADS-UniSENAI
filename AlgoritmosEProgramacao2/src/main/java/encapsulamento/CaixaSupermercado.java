package encapsulamento;

public class CaixaSupermercado {
    private double totalCompra;

    public void adicionarProduto(double preco){
        if (preco > 0){
            totalCompra += preco;
        } else {
            System.out.println("O valor informado é inválido!");
        }
    }
    public double getTotalCompra() {
        return totalCompra;
    }
}
