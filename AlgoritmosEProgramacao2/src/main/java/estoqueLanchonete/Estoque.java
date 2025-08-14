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
public class Estoque {
    private String nome;
    private int quantidade;
    private double precoUnitario;

    public Estoque(String nome, int quantidade, double precoUnitario) {
        this.nome = nome;
        this.quantidade = quantidade;
        setPrecoUnitario(precoUnitario);
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        if (precoUnitario >= 0) {
            this.precoUnitario = precoUnitario;
        } else {
            System.out.println("Preço unitário não pode ser negativo.");
        }
    }

    public void entradaEstoque(int quantidade) {
        if (quantidade > 0) {
            this.quantidade += quantidade;
        } else {
            System.out.println("Quantidade de entrada deve ser positiva.");
        }
    }

    public boolean saidaEstoque(int quantidade) {
        if (quantidade > 0 && quantidade <= this.quantidade) {
            this.quantidade -= quantidade;
            return true;
        } else {
            System.out.println("Saída inválida: quantidade maior que a disponível.");
            return false;
        }
    }

    public double calcularValorTotal() {
        return this.quantidade * this.precoUnitario;
    }
    
}
