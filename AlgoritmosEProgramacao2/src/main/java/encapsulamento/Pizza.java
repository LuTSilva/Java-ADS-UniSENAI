package encapsulamento;

import java.util.ArrayList;

public class Pizza {
    private ArrayList<String> ingredientes = new ArrayList<>();

    public void adicionarIngrediente(String ingrediente){
        if (ingrediente != null && !ingrediente.isEmpty()){
            ingredientes.add(ingrediente);
        } else {
            System.out.println("Informe um valor diferente de null ou vazio!");
        }
    }
    public void mostrarPizza(){
        System.out.printf("Pizza com %s", ingredientes);
    }
}
