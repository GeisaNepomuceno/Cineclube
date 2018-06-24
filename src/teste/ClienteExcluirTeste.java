/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import javax.swing.JOptionPane;
import model.ClienteDAO;

/**
 *
 * @author Jefer
 */
public class ClienteExcluirTeste {
    
    public static void main(String[] args) {

		ClienteDAO dao = new ClienteDAO();
		JOptionPane.showMessageDialog(null, dao.excluir(2));

	}
    
}
