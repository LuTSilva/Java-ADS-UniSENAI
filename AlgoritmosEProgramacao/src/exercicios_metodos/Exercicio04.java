package exercicios_metodos;

import java.util.Scanner;

public class Exercicio04 {
    //  4 - Crie um validador de senhas que:
    // Receba duas senhas.
    // Verifique se ambas são iguais
    // Verifique se a senha atende ao comprimento mínimo de 10 caracteres.
    // Verifique se a senha tem um @
    // Imprima uma mensagem indicando se a senha passou ou não pelos critérios de segurança
    public static void main(String[] args) {
        solicitarSenhas();
    }
    public static String lerSenha(String msg, Scanner sc) {
        System.out.print(msg + ": ");
        return sc.nextLine();
    }
    public static boolean validarTamanho(String senha) {
        return senha.length() >= 10;
    }
    public static boolean validarIgualdade(String senha1, String senha2) {
        return senha1.equals(senha2);
    }
    public static boolean validarArroba(String senha) {
        return senha.contains("@");
    }
    public static String validarSenha(String senha1, String senha2) {
        if (!validarIgualdade(senha1, senha2)) {
            return "As senhas não são iguais.";
        }
        if (!validarTamanho(senha1)) {
            return "A senha deve ter pelo menos 10 caracteres.";
        }
        if (!validarArroba(senha1)) {
            return "A senha deve conter o caractere '@'.";
        }
        return "Senha válida!";
    }
    public static void exibirResultado(String resultado) {
        System.out.println(resultado);
    }
    public static void solicitarSenhas() {
        Scanner sc = new Scanner(System.in);
        String senha1 = lerSenha("Digite a primeira senha", sc);
        String senha2 = lerSenha("Digite a segunda senha", sc);
        String resultado = validarSenha(senha1, senha2);
        exibirResultado(resultado);
        sc.close();
    }
    public static String lerString(String msg, Scanner sc) {
        System.out.print(msg);
        return sc.nextLine();
    }
}
