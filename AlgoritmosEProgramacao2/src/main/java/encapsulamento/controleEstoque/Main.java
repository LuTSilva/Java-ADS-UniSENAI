package encapsulamento.controleEstoque;

public class Main {
    public static void main(String[] args) {
        Produto p1 = new Produto("Produto1", 100.00, 2);
        Produto p2 = new Produto("Produto2", 150.00, 1);
        Produto p3 = new Produto("Produto3", 200.00, 1);

        p1.setPreco(200.00);
        p1.setQuantidade(3);

        p1.exibeResultado();
        p2.exibeResultado();
        p3.exibeResultado();
    }
}
