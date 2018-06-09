package teste;

import javax.swing.JOptionPane;

import model.Produto;
import model.ProdutoDAO;

public class ProdutoLocalizarTeste {

	public static void main(String[] args) {
		ProdutoDAO dao = new ProdutoDAO();
//		JOptionPane.showMessageDialog(null,dao.localizar(1));
		
		Produto x = dao.localizar(1);
		
		if (x != null) {
			
			JOptionPane.showMessageDialog(null, x.toString());			
		} else {
			
			JOptionPane.showMessageDialog(null, "Não encontrado");
		}
	}
}
