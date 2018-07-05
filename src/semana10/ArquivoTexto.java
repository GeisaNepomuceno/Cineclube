package semana10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ArquivoTexto {

	/**
	 * Armazena em disco um arquivo texto contendo os dados seguintes
	 * @param path - caminho onde o arquivo será criado
	 * @param fileName - o nome do arquivo, incluindo a extensão. Se o arquivo não existir no caminho especificado, ele será criado
	 * caso contrário, será sobrescrito
	 * @param linhas - as linhas que serão gravas em disco
	 * @return - uma mensagem informando o status da gravação
	 */
	public String gravar(String path, String fileName, String[] linhas) {

		try {
			
			PrintWriter pw = new PrintWriter(path + fileName);
			
			for (int i = 0; i < linhas.length; i++) {
				
				pw.println(linhas[i]);
			}
			
			pw.flush(); // força os dados a sairem do objeto e irem para o arquivo, como se fosse um 'salvar'
			pw.close();
			return "Arquivo gravado com sucesso!";
			
		} catch (IOException e) {
			
			return "Falha ao gravar o arquivo" + e.toString();
		}
	}
	
	
	public String adicionar(String path, String fileName, String[] linhas) {

		try {
			
			// FileWriter: Abre o arquivo com essa classe, se estiver true abre o arquivo e insere no final, sen�o, cria o arquivo
			FileWriter fw = new FileWriter(path + fileName, true); 
			PrintWriter pw = new PrintWriter(fw);
			
			for (int i = 0; i < linhas.length; i++) {
				
				pw.println(linhas[i]);
			}
			
			pw.flush(); // for�a os os dados sairem do objeto e irem para o arquivo, como se fosse um 'salvar'
			pw.close();
			return "Arquivo gravado com sucesso!";
			
		} catch (IOException e) {
			
			return "Falha ao gravar o arquivo" + e.toString();
		}
	}
	
	/**
	 * Realiza a leitura de um arquivo texto de acordo com os dados seguintes
	 * @param path - caminho onde o arquivo se localiza
	 * @param fileName - nome do arquivo, incluindo a extens�o
	 * @param qtdeLinhas - quantiade de linhas a serem lidas a partir do inicio do arquivo
	 * @return - um array contendo as linhas lidas do arquivo
	 */
	public String[] ler(String path, String fileName, int qtdeLinhas) {
		
		String[] linhas = new String[qtdeLinhas];
		
		try {
			
			// A classe abaixo, abre o arquivo para realizar a leitura e � passado a quantidade de linhas que quero
			BufferedReader br = new BufferedReader(new FileReader(path + fileName));
			
			for (int i = 0; i < qtdeLinhas; i++) {
				
				linhas[i] = br.readLine(); // esse m�todo l� uma linha, quando acaba, ele pula o cursor e armazena linha a linha na vari�vel Linhas
			}
			
			br.close();
			return linhas;
			
		} catch (Exception e) {

			System.out.println(e.toString());
			return null;
		}
	}
	
	public void listar(String path, String fileName) {
		
		try {
			
			BufferedReader br = new BufferedReader(new FileReader(path + fileName));
			
			String linha = "";
			
			while ((linha = br.readLine()) != null) {
				
				System.out.println(linha);
			}
			
			br.close();
			
		} catch (Exception e) {

			System.out.println(e.toString());
		}
	}
}
