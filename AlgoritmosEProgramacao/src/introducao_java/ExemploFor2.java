package introducao_java;

import javax.swing.JOptionPane;

public class ExemploFor2 {

	public static void main(String[] args) {
		
		for(int i=0;i<10;i++) {
			String nome = JOptionPane.showInputDialog("Nome:");
			double soma = 0;
			double media = 0;
			for(int j=0;j<3;j++) {
				double n = Double.parseDouble(JOptionPane.showInputDialog("N"+(j+1)));
				soma += n;
				media = soma / 3;
			}
			JOptionPane.showMessageDialog(null, nome + " media: " + media);
		}
	}
}
