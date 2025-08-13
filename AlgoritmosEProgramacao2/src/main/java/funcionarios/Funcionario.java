package funcionarios;

import java.util.Scanner;

public class Funcionario {
    int codFuncionario;
    String nmFuncionario;
    double salario;
    String cpfFuncionario;
    String cargoFuncionario;


    void intervalo(){
        System.out.printf("Já está na hora do " +
                "funcionario sair para o intervalo \n");
    }


    void salarioAumento(){
        if (salario <= 3000){
            System.out.printf("O %s terá um aumento de 10%%", this.nmFuncionario);
        } else if (salario >= 5000){
            System.out.println("Será descontado do funcionario 10% do salário");
        }
    }
    void calculaBonus(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Recebeu aumento nos ultimos 12 meses?\n 'S' ou 'N' ");
        char op =  sc.next().toUpperCase().charAt(0);
        if(op == 'N'){
            salario += salario * 0.1;
        }
        System.out.println("Salário atualizado: " + salario);
        sc.close();
    }
}
