package encapsulamento.funcionarios;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Funcionario funcionario = new Funcionario();

        System.out.println("Digite o nome do funcionario:");
        funcionario.nmFuncionario = sc.nextLine();

        System.out.println("Digite o cpf do funcionario:");
        funcionario.cpfFuncionario = sc.nextLine();

        System.out.println("Digite o cargo do funcionario:");
        funcionario.cargoFuncionario = sc.nextLine();

        System.out.println("Digite o salário do Funcionario:");
        funcionario.salario = sc.nextDouble();

        funcionario.codFuncionario = 1;

        System.out.printf("O código do funcionario é %d\n", funcionario.codFuncionario);
        System.out.printf("O nome do funcionario é %s\n", funcionario.nmFuncionario);
        System.out.printf("O cpf do funcionario é %s\n", funcionario.cpfFuncionario);
        System.out.printf("O salário do funcionario é %.2f\n", funcionario.salario);
        System.out.printf("O cargo do funcionario é %s\n", funcionario.cargoFuncionario);

        funcionario.intervalo();
        funcionario.calculaBonus();
        funcionario.salarioAumento();

        sc.close();
    }
}
