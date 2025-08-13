package produtos;

public class Produto {
    String nome;
    double preco;
    double quantidadeEstoque;
    String unidadeMedida;

    void mostraInformacoes() {
        System.out.println("Nome do produto: " + nome);
        System.out.println("Preço do produto: R$ " + preco);
        System.out.println("Quantidade em estoque: " + quantidadeEstoque + " " + unidadeMedida);
    }

    void calculaPreco() {
        if (preco <= 10) {
            preco = preco * 1.10;
        }
    }
}
