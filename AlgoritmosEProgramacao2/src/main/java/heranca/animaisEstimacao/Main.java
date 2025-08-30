package heranca.animaisEstimacao;
/*
Um pet shop deseja registrar informações de seus animais. 
Cada animal tem um nome e uma idade, mas cachorros e gatos possuem comportamentos diferentes.

O que deve ser feito:
Crie a classe base Animal com atributos:
nome (String)
idade (int).

Crie classes filhas:
Cachorro → possui método latir() que imprime "Au Au!".
Gato → possui método miar() que imprime "Miau!".

No programa principal:
Crie um cachorro e um gato.
Exiba suas informações e chame seus métodos específicos.
*/
public class Main {
    public static void main(String[] args){
        Gato gato = new Gato();
        gato.nome = "Gato1";
        gato.idade = 2;
        gato.exibirInfo();
        gato.miar();

        Cachorro cachorro = new Cachorro();
        cachorro.nome = "Cachorro1";
        cachorro.idade = 3;
        cachorro.exibirInfo();
        cachorro.latir();
    }
    
}
