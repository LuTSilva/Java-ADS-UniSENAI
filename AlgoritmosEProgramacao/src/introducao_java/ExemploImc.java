package introducao_java;

import java.util.Locale;

import javax.swing.JOptionPane;

public class ExemploImc {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		String nome = JOptionPane.showInputDialog("Nome: ");
		double peso = Double.parseDouble(JOptionPane.showInputDialog("Peso: "));
		double altura = Double.parseDouble(JOptionPane.showInputDialog("Altura: "));
		
		double imc = peso / (altura * altura);
		
		JOptionPane.showMessageDialog(null, "Bem vindo(a) " + nome + "\nImc: " + imc);
	}

}
