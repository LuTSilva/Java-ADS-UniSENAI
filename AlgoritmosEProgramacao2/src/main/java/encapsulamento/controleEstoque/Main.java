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
