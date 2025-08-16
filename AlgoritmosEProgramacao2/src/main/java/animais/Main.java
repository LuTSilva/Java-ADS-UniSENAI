package animais;

public class Main {
    public static void main(String[] args) {

        Cachorro c = new Cachorro();
        c.nome = "Cachorro";
        c.emitirSom();

        Gato g = new Gato();
        g.nome = "Gato";
        g.emitirSom();
    }
}
