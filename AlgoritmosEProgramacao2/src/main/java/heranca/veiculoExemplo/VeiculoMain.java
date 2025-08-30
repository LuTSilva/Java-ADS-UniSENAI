package heranca.veiculoExemplo;

public class VeiculoMain {
    public static void main(String[] args) {

        Carro carro = new Carro();
        carro.marca = "Honda";
        carro.ano = 2022;
        carro.portas = 4;

        carro.acelerar();

        carro.abrirPortaMala();

        Moto moto = new Moto();
        moto.marca = "Honda";
        moto.ano = 2022;
        moto.empinar();
        moto.acelerar();
    }
}
