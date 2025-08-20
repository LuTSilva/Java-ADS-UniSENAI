package poliformismo.veiculo;

public class VeiculoMain {
    public static void main(String[] args){

        Veiculo[] veiculos = {new Carro(), new Moto()};

        for(Veiculo v: veiculos){
            v.mover();
        }
    }
}
