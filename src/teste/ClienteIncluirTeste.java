package teste;

import javax.swing.JOptionPane;

import com.sun.security.ntlm.Client;

import model.Cliente;
import model.ClienteDAO;

public class ClienteIncluirTeste {
	public static void main(String[] args) {
		Cliente c = new Cliente("Saito", "puta que pariu", "inferno", "sei la", "13334030", "596754474", "07274410512", "24-02-1999", "1999999999", "foda-se@gmail.com", "1999999999", "f");
		ClienteDAO dao = new ClienteDAO();
		
		JOptionPane.showMessageDialog(null, dao.salvar(c));
	}
}
