package heranca.concessionaria;

public class Moto extends Veiculo {
    private int cilindrada;

    Moto(String marca, int ano, int cilindrada) {
        this.marca = marca;
        this.ano = ano;
        this.cilindrada = cilindrada;
    }

    @Override
    void exibirInformacoes(){
        System.out.println("Marca: " + marca);
        System.out.println("Ano: " + ano);
        System.out.println("Cilindrada: " + cilindrada);
    }

}
