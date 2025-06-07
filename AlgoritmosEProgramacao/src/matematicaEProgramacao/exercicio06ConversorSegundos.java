package matematicaEProgramacao;

import java.util.Scanner;

public class exercicio06ConversorSegundos {
    // Um grupo quer criar um sistema que transforma segundos digitados pelo usuário em 
    // horas, minutos e segundos para praticar lógica e conversão
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int segundos = lerInt("Digite a quantidade de segundos: ", sc);
        System.out.println(calculador(segundos));
        sc.close();
    }
    public static int lerInt(String msg, Scanner sc) {
        System.out.print(msg);
        return sc.nextInt();
    }
    public static String calculador(int segundos) {
        int horas = segundos / 3600;
        int minutos = (segundos % 3600) / 60;
        int restanteSegundos = segundos % 60;
        return String.format("%d segundos equivalem a %d horas, %d minutos e %d segundos.", 
                             segundos, horas, minutos, restanteSegundos);
    }
}
