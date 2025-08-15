package pizza;

public class PizzaSalgada extends Pizza {
    void preparar(){
        System.out.printf("Preparando pizza, %s ... com muito queijo \n", this.sabor);
    }
}
