package encapsulamento.gestaoFuncionarios;

public class Funcionario {
    private String nome;
    private String cargo;
    private double salario;

    public Funcionario(String nome, String cargo, double salario){
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
    }
    public void aumentarSalario(double salario){
        this.salario += salario;
    }
    public String exibirDados(){
        return "Nome: %s, Cargo: %s, Salário: %.2f%n";
    }
}
