package semana10;

import javax.swing.JOptionPane;

public class TestaAdicionar {

	public static void main(String[] args) {

		ArquivoTexto at = new ArquivoTexto();
		
		String[] linhas = {
				"Hoje e quinta", "Amanha e sexta", "Sabado"
		};
		
		JOptionPane.showMessageDialog(null, at.adicionar("C:/Users/1050481723027/Documents/Teste_Java/", "semana.txt", linhas));
	}

}
