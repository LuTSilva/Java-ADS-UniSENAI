package heranca.pizza;

public class Pizzaria {
    public static void main(String[] args) {
        PizzaSalgada frangoCatupiry = new PizzaSalgada();
        frangoCatupiry.sabor = "Frango com Catupiry";
        frangoCatupiry.preco = 100;
        frangoCatupiry.preparar();

        PizzaDoce chocolate = new PizzaDoce();
        chocolate.sabor = "Chocolate";
        chocolate.preco = 10;
        chocolate.preparar();

        double combo = frangoCatupiry.preco + chocolate.preco;
        System.out.printf("O total do combo é %.2f", combo);
    }
}
