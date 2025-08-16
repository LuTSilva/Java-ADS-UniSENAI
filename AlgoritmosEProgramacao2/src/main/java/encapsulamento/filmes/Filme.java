package encapsulamento.filmes;

public class Filme {
    String titulo;
    String genero;
    int ano;

    void exibirFicha() {
        System.out.println("Título: " + titulo);
        System.out.println("Gênero: " + genero);
        System.out.println("Ano: " + ano);
        System.out.println();
    }
}
