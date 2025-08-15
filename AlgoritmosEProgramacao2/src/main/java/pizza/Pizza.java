package pizza;

public class Pizza {
    String sabor;
    double preco;

    void preparar(){
        System.out.printf("Preparando pizza, %s..", this.sabor);
    }
}
