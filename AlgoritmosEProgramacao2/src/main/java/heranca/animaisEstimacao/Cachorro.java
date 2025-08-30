package heranca.animaisEstimacao;

public class Cachorro extends Animal {

    public void latir(){
        System.out.println("Au Au!");
    }

    public void exibirInfo() {
        System.out.println("Nome: " + nome + ", Idade: " + idade);
    }
}
