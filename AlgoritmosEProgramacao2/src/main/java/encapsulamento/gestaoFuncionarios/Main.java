package encapsulamento.gestaoFuncionarios;

public class Main {
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
    public static void main(String[] args){

        Funcionario funcionario1 = new Funcionario("João", "Desenvolvedor", 3000);
        Funcionario funcionario2 = new Funcionario("Maria", "Gerente", -1500);
        Funcionario funcionario3 = new Funcionario("José", "Analista", 2500);

        System.out.println(funcionario1.exibirDados());
        System.out.println(funcionario2.exibirDados());
        System.out.println(funcionario3.exibirDados());

        funcionario1.aumentarSalario(10);
        funcionario2.aumentarSalario(-5);
        funcionario3.aumentarSalario(10);

        System.out.println(funcionario1.exibirDados());
        System.out.println(funcionario2.exibirDados());
        System.out.println(funcionario3.exibirDados());
    }
}
