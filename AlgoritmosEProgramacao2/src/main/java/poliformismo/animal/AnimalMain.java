package poliformismo.animal;

public class AnimalMain {

    public static void main(String[] args) {
        Animal[] animais = {new Cachorro(), new Gato(), new Passaro()};

        for(Animal animal : animais){
            animal.emitirSom();
        }
    }
}
