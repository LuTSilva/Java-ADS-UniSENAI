package heranca.animaisEstimacao;

public class Gato extends Animal {
    public void miar() {
        System.out.println("Miau!");
    }
    public void exibirInfo() {
        System.out.println("Nome: " + nome + ", Idade: " + idade);
    }
    
}
