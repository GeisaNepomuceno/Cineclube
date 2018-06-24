package semana10;

import javax.swing.JOptionPane;

public class TestaGravar {

	public static void main(String[] args) {

		ArquivoTexto at = new ArquivoTexto();
		
		String[] linhas = {
				"Hoje e quinta", "Amanha e sexta"
		};
		
		JOptionPane.showMessageDialog(null, at.gravar("C:/Users/1050481723027/Documents/Teste_Java/", "semana.txt", linhas));
	}

}
