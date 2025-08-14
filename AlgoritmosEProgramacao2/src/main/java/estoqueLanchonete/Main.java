package estoqueLanchonete;
/*
 * Uma lanchonete quer controlar seu estoque de produtos.
Cada produto tem:
Nome
Quantidade em estoque
Preço unitário

Regras:
A quantidade só pode ser alterada por métodos de entrada e saída de estoque.
Não permitir saída maior que a quantidade disponível.
O preço unitário pode ser alterado, mas não pode ser negativo.

Criar método para calcular o valor total em estoque.
 */
public class Main {
    public static void main(String[] args) {
        
        Estoque produto1 = new Estoque("Hambúrguer", 50, 12.50);
        System.out.println("Produto: " + produto1.getNome());
        System.out.println("Quantidade em estoque: " + produto1.getQuantidade());
        System.out.println("Preço unitário: R$ " + produto1.getPrecoUnitario());

        // Entrada de estoque
        produto1.entradaEstoque(20);
        System.out.println("Quantidade após entrada: " + produto1.getQuantidade());

        // Tentando saída de estoque
        if (produto1.getQuantidade() >= 30) {
            produto1.saidaEstoque(30);
            System.out.println("Quantidade após saída: " + produto1.getQuantidade());
        } else {
            System.out.println("Não é possível realizar a saída, quantidade insuficiente.");
        }

        // Calculando valor total em estoque
        double valorTotal = produto1.calcularValorTotal();
        System.out.println("Valor total em estoque: R$ " + valorTotal);
    }
}
