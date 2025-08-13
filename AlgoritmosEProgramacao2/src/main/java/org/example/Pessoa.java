package org.example;

public class Pessoa {

    String nome;
    int idade;
    String cpf;
    double salario;
    double peso;
    double altura;
    int codigo;
    boolean cansaco;

    void andar(){
        if (cansaco == true){
            System.out.printf("O %s precisa descansar", this.nome);
        } else {
            System.out.println("Pode praticar exercicios, como andar");
        }
    }
    void comer(){
        System.out.println("Irei comer uma fruta");
    }
}
