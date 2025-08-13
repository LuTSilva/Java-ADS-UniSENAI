package produtos;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Produto produto = new Produto();

        System.out.print("Digite o nome do produto: ");
        produto.nome = sc.nextLine();

        System.out.print("Digite o preço do produto: ");
        produto.preco = sc.nextDouble();

        System.out.print("Digite a quantidade em estoque: ");
        produto.quantidadeEstoque = sc.nextDouble();

        sc.nextLine();

        System.out.print("Digite a unidade de medida (ex: kg, unidade): ");
        produto.unidadeMedida = sc.nextLine();

        produto.calculaPreco();
        produto.mostraInformacoes();

        sc.close();
    }
}
