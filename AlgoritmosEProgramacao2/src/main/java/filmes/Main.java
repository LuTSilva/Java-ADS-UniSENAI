package filmes;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Filme> listaDeFilmes = new ArrayList<>();

        System.out.print("Quantos filmes deseja cadastrar? ");
        int quantidade = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < quantidade; i++) {
            Filme filme = new Filme();

            System.out.println("\nCadastro do filme " + (i + 1));
            System.out.print("Digite o título: ");
            filme.titulo = sc.nextLine();

            System.out.print("Digite o gênero: ");
            filme.genero = sc.nextLine();

            System.out.print("Digite o ano: ");
            filme.ano = sc.nextInt();
            sc.nextLine();

            listaDeFilmes.add(filme);
        }

        System.out.println("\n--- Fichas dos Filmes Cadastrados ---\n");
        for (Filme f : listaDeFilmes) {
            f.exibirFicha();
        }

        sc.close();
    }
}
