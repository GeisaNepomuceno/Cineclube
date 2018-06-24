/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import javax.swing.JOptionPane;
import model.Cliente;
import model.ClienteDAO;

/**
 *
 * @author Jefer
 */
public class ClienteLocalizar {
        public static void main(String[] args) {
            ClienteDAO dao = new ClienteDAO();
//		JOptionPane.showMessageDialog(null,dao.localizar(1));
		
		Cliente c = dao.localizar(1);
		
		if(c != null){
			JOptionPane.showMessageDialog(null, c.toString());			
		}
          
                else {
			JOptionPane.showMessageDialog(null, "Nao encontrado");
		}
        }

                
}
