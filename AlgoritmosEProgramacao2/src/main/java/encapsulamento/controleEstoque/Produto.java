package encapsulamento.controleEstoque;
/*
Uma loja precisa controlar os produtos disponíveis em seu estoque. Cada produto tem nome, preço e quantidade. 
O gerente deseja poder atualizar apenas o preço e a quantidade dos produtos, nunca o nome.

O que deve ser feito:
Crie a classe Produto com atributos privados:
nome (String)
preco (double)
quantidade (int).

Crie métodos:
Getters para todos os atributos.
Setters apenas para preco e quantidade.
calcularValorTotal() → retorna preco * quantidade.

No programa principal:
Crie 3 produtos com valores iniciais.
Atualize preço e quantidade de pelo menos 1 deles.
Exiba o valor total de cada produto em estoque.

 */

public class Produto {
    private String nome;
    private double preco;
    private int quantidade;

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double calcularValorTotal(){
        return preco * quantidade;
    }

    public void exibeResultado(){
        System.out.printf("Produto: %s, R$: %.2f%n",nome, calcularValorTotal());
    }

    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }
}
