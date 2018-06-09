package teste;

import javax.swing.JOptionPane;

import model.Produto;
import model.ProdutoDAO;

public class ProdutoIncluirTeste {

	public static void main(String[] args) {
		Produto p = new Produto(4,"Querosene",4,50);
		ProdutoDAO dao = new ProdutoDAO();
		JOptionPane.showMessageDialog(null,dao.salvar(p));

	}

}
