package heranca.pizza;

public class PizzaDoce extends Pizza {
    void preparar(){
        System.out.printf("preparando pizza %s ... com cobertura extra \n", this.sabor);
    }
}
