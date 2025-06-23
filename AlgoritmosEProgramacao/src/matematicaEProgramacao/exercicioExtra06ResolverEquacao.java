package matematicaEProgramacao;

public class exercicioExtra06ResolverEquacao {
    // Resolva a equação 5x + 3 = 2x + 18 com entrada do valor final via teclado. 

    public static void main(String[] args) {

        int a = 5;  // Coeficiente de x no lado esquerdo
        int b = 3;  // Termo constante no lado esquerdo
        int c = 2;  // Coeficiente de x no lado direito
        int d = 18; // Termo constante no lado direito

        calcularEquacao(a, b, c, d);

    }
    public static void calcularEquacao(int a, int b, int c, int d) {
        // Isolando x -> ax - cx = d - b
        double x = (d - b) / (double) (a - c);
        exibeMsg("O valor de x é: " + x);
    }
    public static void exibeMsg(String msg) {
        System.out.println(msg);
    }
}

