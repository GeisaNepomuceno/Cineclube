package teste;

import javax.swing.JOptionPane;

import model.ProdutoDAO;

public class ProdutoExcluirTeste {

	public static void main(String[] args) {

		ProdutoDAO dao = new ProdutoDAO();
		JOptionPane.showMessageDialog(null, dao.excluir(2));

	}

}
