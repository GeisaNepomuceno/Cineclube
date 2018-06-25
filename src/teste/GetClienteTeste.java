/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.util.List;
import model.Cliente;
import model.ClienteDAO;

/**
 *
 * @author Jefer
 */
public class GetClienteTeste {
    public static void main(String[] args) {
		ClienteDAO dao = new ClienteDAO();
		
		List<Cliente> lista = dao.getClientes();
		
//		JOptionPane.showMessageDialog(null, lista.toString());
		
		for(Cliente c: lista) {
			c.mostrar();
		}
	}
}
