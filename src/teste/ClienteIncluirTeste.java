package teste;

import javax.swing.JOptionPane;
import model.Cliente;
import model.ClienteDAO;

public class ClienteIncluirTeste {
	public static void main(String[] args) {
		Cliente c = new Cliente(2,"asdsa","aaaaa","aaaaa","aaaaa","aaaaa","asdf","adsf","aaaaa","asd","aaaaa","aaaaa","aaaaa",1);
		ClienteDAO dao = new ClienteDAO();
		
		JOptionPane.showMessageDialog(null, dao.salvar(c));
	}
}
