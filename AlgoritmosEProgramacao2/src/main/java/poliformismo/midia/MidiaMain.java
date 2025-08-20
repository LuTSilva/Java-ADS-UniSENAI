package poliformismo.midia;

public class MidiaMain {
    public static void main(String[] args) {
        Midia[] playlist = {new Musica(), new Video(), new Podcast()};

        for(Midia midia : playlist){
            midia.reproduzir();
        }
    }
}
