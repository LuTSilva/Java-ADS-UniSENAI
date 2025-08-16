package encapsulamento.bilhetesOnibus;

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
        BilheteOnibus bilhete = new BilheteOnibus(lerString("Digite o nome do passageiro: ", sc));
        detalhesPassageiro(bilhete);
        bilhete.adicionarSaldo(sc);
        bilhete.consultarSaldo();
        bilhete.utilizarBilhete();
        sc.close();
    }

    private static void detalhesPassageiro(BilheteOnibus bilhete) {
        exibeMsg("Confirme os detalhes do bilhete:");
        exibeMsg("----------------------------");
        exibeMsg("Número do Bilhete: " + bilhete.getNumeroBilhete());
        exibeMsg("Passageiro: " + bilhete.getPassageiro());
        exibeMsg("Saldo Inicial: R$ " + bilhete.getSaldo());
        exibeMsg("Tarifa da passagem: R$ " + bilhete.getTarifa());
    }
 
    static String lerString(String msg, Scanner sc) {
		System.out.print(msg);
		return sc.nextLine();
	}
    static void exibeMsg(String msg) {
		System.out.println(msg);
	}
}
