package exercicios_metodos;

import java.util.Scanner;

public class Exercicio02 {
    public static void main(String[] args) {
        //  2 - Em uma competição, as pessoas são organizadas por categorias, 
        // as quais, são determinadas pela idade: 
        // 5 a 7 anos - Infantil A
        // 8 a 10 anos - Infantil B
        // 11-17 anos - Juvenil
        // Maiores de 18 anos (inclusive) - Adulto
        // Construa um programa para cadastrar nome e idade de N pessoas (somente o 
        // nome e a idade serão informados), e mostre o nome e a categoria

        Scanner sc = new Scanner(System.in);

        String resultado = "";
        int n = lerInt("Quantas pessoas deseja cadastrar? ", sc);
        for (int i = 0; i < n; i++) {
            String nome = lerString("Informe o nome: ", sc);
            int idade = lerInt("Idade de " + nome + ": ", sc);
            resultado += "\n" + nome + " - " + verificaCategoria(idade);
        }
        exibeMsg("Resultado: " + resultado);
        sc.close();
        
    }
    public static String verificaCategoria(int idade) {
        if (idade < 5) return "Idade inválida";
        if (idade <= 7) return "Infantil A";
        if (idade <= 10) return "Infantil B";
        if (idade <= 17) return "Juvenil";
        return "Adulto";
    }

    public static int lerInt(String msg, Scanner sc) {
        System.out.print(msg);
        return sc.nextInt();
    }
    public static void exibeMsg(String msg) {
        System.out.println(msg);
    }
    
    public static String lerString(String msg, Scanner sc) {
        System.out.print(msg);
        return sc.next();
    }
}
