package bilhetesOnibus;

import java.util.Scanner;

/*
 Uma empresa de transporte quer criar um sistema simples para controlar bilhetes de ônibus.
Cada bilhete tem:

Número do bilhete (inteiro, gerado automaticamente)

Nome do passageiro

Saldo disponível

Tarifa fixa da passagem (R$ 4,50)

Regras:

O saldo e o número do bilhete não podem ser alterados diretamente por código externo.

O sistema deve permitir:

Adicionar saldo ao bilhete.

Utilizar o bilhete (diminuindo o saldo ao pagar a passagem).

Consultar saldo.

Se o saldo for menor que o valor da tarifa, a viagem não pode ser realizada e o sistema deve avisar.

Desafio para os alunos
Criar uma classe BilheteOnibus com atributos privados.

Usar métodos públicos para manipular os atributos (get e set apenas onde fizer sentido).

Implementar validações dentro dos métodos, por exemplo:

Não permitir adicionar saldo negativo.

Não permitir viagem se não houver saldo suficiente.

Criar uma classe Main para testar.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bilhetes bilhete1 = new Bilhetes(lerString("Digite o nome do passageiro: ", sc));
        exibeMsg("Número do Bilhete: " + bilhete1.getNumeroBilhete());
        exibeMsg("Passageiro: " + bilhete1.getPassageiro());
        exibeMsg("Saldo Inicial: R$ " + bilhete1.getSaldo());
        exibeMsg("Tarifa da passagem: R$ " + Bilhetes.TARIFA);
        
        double valor;
        String opcao;
        while (true) {
            valor = lerDouble("Digite o valor para adicionar ao saldo: ", sc);
            if (valor < 0) {
            exibeMsg("Valor negativo não permitido. Tente novamente.");
            continue;
            }
            bilhete1.adicionarSaldo(valor);
            exibeMsg("Saldo após adicionar R$ " + valor + ": R$ " + bilhete1.getSaldo());
            System.out.print("Deseja adicionar mais saldo? (s/n): ");
            opcao = sc.next();
            if (!opcao.equalsIgnoreCase("s")) {
            break;
            }
        }

        // Tentando utilizar o bilhete
        if (bilhete1.utilizarBilhete()) {
            exibeMsg("Viagem realizada com sucesso!");
        } else {
            exibeMsg("Saldo insuficiente para realizar a viagem.");
        }

        // Consultando saldo
        exibeMsg("Saldo restante: R$ " + bilhete1.getSaldo());
        sc.close();
    }
        public static double lerDouble(String msg, Scanner sc) {
        System.out.print(msg);
        return sc.nextDouble();
    }
    public static String lerString(String msg, Scanner sc) {
		System.out.print(msg);
		return sc.nextLine();
	}
    public static void exibeMsg(String msg) {
		System.out.println(msg);
	}
}
