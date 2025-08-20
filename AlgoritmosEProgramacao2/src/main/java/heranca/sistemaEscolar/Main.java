package heranca.sistemaEscolar;
/*
Uma escola deseja informatizar os cadastros de pessoas. 
Cada pessoa pode ser Aluno ou Professor. 
Apesar de terem dados em comum, cada um tem características próprias.

O que deve ser feito:
Crie a classe base Pessoa com atributos:
nome (String)
idade (int).

Crie classes filhas:
Aluno → possui atributos matricula (String) e nota (double).
Professor → possui atributos disciplina (String) e salario (double).

Crie métodos:
exibirDados()em cada classe, exibindo as informações completas.

No programa principal:
Crie 2 alunos e 1 professor.
Exiba os dados de todos no console. 
*/
public class Main {
    public static void main(String[] args){
        Aluno aluno = new Aluno("Pedro", 20, "123", 8.3);
        Professor professor = new Professor("Maria", 42, "Matemática", 3500.00);

        aluno.exibirDados();
        System.out.println();
        professor.exibirDados();
    }
    
}
