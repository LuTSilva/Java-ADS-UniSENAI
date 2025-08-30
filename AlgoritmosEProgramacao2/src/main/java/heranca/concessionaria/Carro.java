package heranca.concessionaria;

public class Carro extends Veiculo {
    private int portas;

    Carro(String marca, int ano, int portas) {
        this.marca = marca;
        this.ano = ano;
        this.portas = portas;
    }

    @Override
    void exibirInformacoes(){
        System.out.println("Marca: " + marca);
        System.out.println("Ano: " + ano);
        System.out.println("Portas: " + portas);
    }
}
