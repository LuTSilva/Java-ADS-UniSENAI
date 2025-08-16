package encapsulamento.estoqueLanchonete;

import java.util.Scanner;

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
        setQuantidade(quantidade);
        setPrecoUnitario(precoUnitario);
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPrecoUnitario() {
        return this.precoUnitario;
    }
    public void setQuantidade(int quantidade) {
        Scanner sc = new Scanner(System.in);
        while(quantidade < 0) {
            System.err.print("Quantidade não pode ser negativa. Digite novamente: ");
            quantidade = sc.nextInt();
        }
        this.quantidade = quantidade;
    }

    public void setPrecoUnitario(double precoUnitario) {
        Scanner sc = new Scanner(System.in);
        while(precoUnitario <= 0) {
            System.err.print("Preço unitário não pode ser negativo ou zero. Digite novamente: ");
            precoUnitario = sc.nextDouble();
        }
        this.precoUnitario = precoUnitario;
    }

    public void entradaEstoque(int quantidade) {
        if (quantidade > 0) {
            this.quantidade += quantidade;
        } else {
            System.out.println("Quantidade de entrada deve ser positiva.");
        }
    }

    public void saidaEstoque(int quantidade) {
        if (quantidade > 0 && quantidade <= this.quantidade) {
            this.quantidade -= quantidade;
        } else if (quantidade > this.quantidade) {
            System.out.println("Não é possível realizar a saída, quantidade insuficiente.");
        } else {
            System.out.println("Quantidade de saída deve ser positiva.");
        }
    }

    public double calcularValorTotal() {
        return this.quantidade * this.precoUnitario;
    }
    
}
