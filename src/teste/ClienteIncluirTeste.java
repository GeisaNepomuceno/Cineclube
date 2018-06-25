package teste;

import javax.swing.JOptionPane;


import model.Cliente;
import model.ClienteDAO;

public class ClienteIncluirTeste {
	public static void main(String[] args) {
		Cliente c = new Cliente("FOIII CARALHOOOOO", "111.111.111-11", "11.111.111-1", "11-11-1998", "(11)1111-1111", "saito@gmail.com", "Rua 1", "Cidade1", "11111-111", "Bairro 1", "(11)11111-1111", "M");
		ClienteDAO dao = new ClienteDAO();
		
		JOptionPane.showMessageDialog(null, dao.salvar(c));
	}
}
