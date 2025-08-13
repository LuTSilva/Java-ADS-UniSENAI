package org.example;

public class Main {
    public static void main(String[] args) {

        Pessoa pessoa =  new Pessoa();
        pessoa.nome = "Matheus";
        pessoa.idade = 22;
        pessoa.altura = 1.90;
        pessoa.peso = 110.10;
        pessoa.codigo = 1;
        pessoa.salario = 15200.00;
        pessoa.cansaco = true;
        pessoa.andar();
    }
}