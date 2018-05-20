package semana10;

import javax.swing.JOptionPane;

public class TestaGravar {

	public static void main(String[] args) {

		ArquivoTexto at = new ArquivoTexto();
		
		String[] linhas = {
				"Hoje é quinta", "Amanhã é sexta"
		};
		
		JOptionPane.showMessageDialog(null, at.gravar("C:/Users/1050481723027/Documents/Teste_Java/", "semana.txt", linhas));
	}

}
