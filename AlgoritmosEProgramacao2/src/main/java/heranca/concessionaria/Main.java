package heranca.concessionaria;
/*
Um sistema de concessionária precisa cadastrar veículos. Existem carros e motos, mas ambos compartilham algumas informações em comum (marca e ano).

O que deve ser feito:
Crie a classe base Veiculo com atributos:
marca (String)
ano (int).

Crie classes filhas:
Carro → possui atributo adicional portas (int).
Moto → possui atributo adicional cilindradas (int).

Crie métodos:
exibirInformacoes() em cada classe, exibindo os dados específicos.

No programa principal:
Crie um carro e uma moto, preenchendo os atributos.
Exiba as informações de ambos.
*/

public class Main {
    public static void main(String[] args) {
        Veiculo carro = new Carro("Toyota", 2020, 4);
        Veiculo moto = new Moto("Honda", 2019, 150);

        carro.exibirInformacoes();
        System.out.println();
        moto.exibirInformacoes();
    }
    
}
