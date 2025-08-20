package encapsulamento.gestaoFuncionarios;
    /*
    Uma empresa deseja organizar seus funcionários. Cada funcionário tem um nome, cargo e salário. O salário deve ser protegido contra valores inválidos (como números negativos).

    O que deve ser feito:
    Crie a classe Funcionario com atributos privados:
    nome (String)
    cargo (String)
    salario (double).

    Crie métodos:
    Construtor para inicializar os atributos.
    aumentarSalario(double percentual) → aumenta o salário conforme o percentual informado.
    exibirDados() → retorna os dados do funcionário em formato de string.
    Garanta que o salário nunca seja menor que zero.
    
    No programa principal:
    Crie dois funcionários.
    Aumente o salário de ambos em 10%.
    Exiba os dados antes e depois do aumento.
     */
public class Funcionario {
    private String nome;
    private String cargo;
    private double salario;

    public Funcionario(String nome, String cargo, double salario){
        this.nome = nome;
        this.cargo = cargo;
        if (salario < 0) {
            System.out.println("Salário não pode ser menor que zero. Valor ajustado para 0.");
            this.salario = 0;
        } else {
            this.salario = salario;
        }
    }
    public void aumentarSalario(double percentual){
        if(percentual > 0){
            this.salario += this.salario * (percentual / 100);
        } else {
            System.out.println("Percentual inválido. O aumento deve ser maior que 0.");
        }
    }
    public String exibirDados(){
        return String.format("Nome: %s, Cargo: %s, Salário: %.2f", nome, cargo, salario);
    }
}
