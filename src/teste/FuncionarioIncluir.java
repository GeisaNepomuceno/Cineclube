package teste;

import javax.swing.JOptionPane;

import model.Funcionario;
import model.FuncionarioDAO;

public class FuncionarioIncluir {

	public static void main(String[] args) {
		Funcionario c = new Funcionario(1,"dfae","aaaaa","aaaaa","aaaaa","aaaaa","aaaaa","aaaaa","aaaaa","aaaaa","aaaaa","aaaaa","aaaaa");
		FuncionarioDAO dao = new FuncionarioDAO();
		
		JOptionPane.showMessageDialog(null, dao.salvar(c));

	}

}
