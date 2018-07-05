package semana10;

public class TestaLer {

	public static void main(String[] args) {

		ArquivoTexto at = new ArquivoTexto();
		
		String[] linhas = at.ler("C:/Users/1050481723027/Documents/Teste_Java/", "semana.txt", 8);
		
		if (linhas != null) {
			for (int i = 0; i < linhas.length; i++) {
				
				System.out.println(linhas[i]);
			}
		} else {
			
			System.out.println("Arquivo não encontrado!");
		}
		
	}

}
