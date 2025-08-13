package encapsulamento;

public class PizzaMain {
    public static void main(String[] args) {

        Pizza pizza = new Pizza();

        pizza.adicionarIngrediente("Mussarela");
        pizza.adicionarIngrediente("Gorgonzola");
        pizza.adicionarIngrediente("Cheddar");
        pizza.adicionarIngrediente("Provolone");
        pizza.mostrarPizza();
    }
}
