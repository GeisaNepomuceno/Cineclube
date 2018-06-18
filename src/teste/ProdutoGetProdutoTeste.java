package teste;

import java.util.List;

import model.Produto;
import model.ProdutoDAO;

public class ProdutoGetProdutoTeste {

	public static void main(String[] args) {
		ProdutoDAO dao = new ProdutoDAO();
		
		List<Produto> lista = dao.getProdutos();
		
//		JOptionPane.showMessageDialog(null, lista.toString());
		
		for(Produto p: lista) {
			p.mostrar();
		}
	}
}
