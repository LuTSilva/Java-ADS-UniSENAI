package heranca.sistemaEscolar;

public class Professor extends Pessoa {
    private String disciplina;
    private double salario;

    public Professor (String nome, int idade, String disciplina, double salario){
        this.nome = nome;
        this.idade = idade;
        this.disciplina = disciplina;
        this.salario = salario;
    }
    void exibirDados(){
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Disciplina: " + disciplina);
        System.out.println("Salário: " + salario);
    }
}
