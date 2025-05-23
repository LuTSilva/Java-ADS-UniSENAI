package introducao_java;

import javax.swing.JOptionPane;

public class ExemploFor3 {

	public static void main(String[] args) {

		String palavra = JOptionPane.showInputDialog("Palavra:");
		String novaPalavra = "";
		
		for(int i=palavra.length()-1; i>=0; i--) {
		// palavra.length()-1 é devido ao indice não ficar fora dos limites
			novaPalavra += palavra.charAt(i);
		}
		System.out.println(novaPalavra);
		
		if (novaPalavra.equalsIgnoreCase(palavra)) {
		// .equals para comparar duas strings
		// IgnoreCase para considerar mesmo que alguma letra esteja em upper ou lower
			System.out.println("Palíndrome");
		} else {
			System.out.println("Não é");
		}
	}
}
