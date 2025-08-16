package animais;

public class Cachorro extends Animal{
    
    void emitirSom() {
        System.out.printf("O %s late... Au Au \n", this.nome);
    }
}
