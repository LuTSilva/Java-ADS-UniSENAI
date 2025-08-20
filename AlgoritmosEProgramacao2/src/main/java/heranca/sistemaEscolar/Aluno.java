package heranca.sistemaEscolar;

public class Aluno extends Pessoa {
    private String matricula;
    private double nota;

    public Aluno(String nome, int idade, String matricula, double nota){
        this.nome = nome;
        this.idade = idade;
        this.matricula = matricula;
        this.nota = nota;
    }

    void exibirDados(){
        System.out.println("Nome: " + nome);
        System.out.println("Idade: "+ idade);
        System.out.println("Matrícula: " + matricula);
        System.out.println("Nota: " + nota);
    }
    
}
