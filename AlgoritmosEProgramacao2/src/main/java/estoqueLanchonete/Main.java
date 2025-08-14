package estoqueLanchonete;

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
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String nome = lerString("Informe o nome do produto: ", sc);
        int quantidade = lerInt("Informe a quantidade em estoque: ", sc);
        double precoUnitario = lerDouble("Informe o preço unitário: ", sc);

        Estoque produto = new Estoque(nome, quantidade, precoUnitario);

        menu(sc, produto);

        sc.close();
    }

    private static void menu(Scanner sc, Estoque produto) {
        int opcao;
        do {
            exibirMsg("\n--- Menu ---");
            exibirMsg("1. Entrada de estoque");
            exibirMsg("2. Saída de estoque");
            exibirMsg("3. Alterar preço unitário");
            exibirMsg("4. Mostrar dados do produto");
            exibirMsg("5. Calcular valor total em estoque");
            exibirMsg("0. Sair");
            opcao = lerInt("Escolha uma opção: ", sc);

            switch (opcao) {
                case 1 -> {
                    produto.entradaEstoque(lerInt("Quantidade para entrada: ", sc));
                    exibirMsg("Quantidade atual: " + produto.getQuantidade());
                }
                case 2 -> {
                    produto.saidaEstoque(lerInt("Quantidade para saída: ", sc));
                    exibirMsg("Quantidade atual: " + produto.getQuantidade());
                }
                case 3 -> {
                    produto.setPrecoUnitario(lerDouble("Novo preço unitário: ", sc));
                    exibirMsg("Preço atualizado: R$ " + produto.getPrecoUnitario());
                }
                case 4 -> {
                    exibirMsg("Produto: " + produto.getNome());
                    exibirMsg("Quantidade em estoque: " + produto.getQuantidade());
                    exibirMsg("Preço unitário: R$ " + produto.getPrecoUnitario());
                }
                case 5 -> {
                    double valorTotal = produto.calcularValorTotal();
                    exibirMsg("Valor total em estoque: R$ " + valorTotal);
                }
                case 0 -> exibirMsg("Saindo...");
                default -> exibirMsg("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private static int lerInt(String msg, Scanner sc) {
        exibirMsg(msg);
        while (!sc.hasNextInt()) {
            exibirMsg("Valor inválido. Tente novamente.");
            sc.next();
            exibirMsg(msg);
        }
        return sc.nextInt();
    }

    private static double lerDouble(String msg, Scanner sc) {
        exibirMsg(msg);
        while (!sc.hasNextDouble()) {
            exibirMsg("Valor inválido. Tente novamente.");
            sc.next();
            exibirMsg(msg);
        }
        return sc.nextDouble();
    }

    private static String lerString(String msg, Scanner sc) {
        exibirMsg(msg);
        return sc.nextLine();
    }

    private static void exibirMsg(String msg) {
        System.out.println(msg);
    }
}
