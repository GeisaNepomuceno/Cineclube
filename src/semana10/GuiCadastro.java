package semana10;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class GuiCadastro extends JPanel {
    private JButton btGravar;
    private JButton btLer;
    private JLabel lbCodigo;
    private JLabel lbNome;
    private JTextField tfCodigo;
    private JTextField tfNome;
    private ArquivoTexto arquivoTexto;

    // Por padrão o método construtor já vem com a inicialização dos componentes, atributos e métodos
    // O que será feito, será separar o que é tela de funcionalidade
    // Seguir um padrão
    public GuiCadastro() { 
    	
    	inicializarComponentes();
    	definirEventos();
    	
    }
    
    public void inicializarComponentes() {
		
    	arquivoTexto = new ArquivoTexto();
    	
        //construct components
        btGravar = new JButton ("Gravar");
        btLer = new JButton ("Ler");
        lbCodigo = new JLabel ("Codigo");
        lbNome = new JLabel ("Nome");
        tfCodigo = new JTextField (5);
        tfNome = new JTextField (5);

        //adjust size and set layout
        setPreferredSize (new Dimension (433, 166));
        setLayout (null);

        //add components
        add (btGravar);
        add (btLer);
        add (lbCodigo);
        add (lbNome);
        add (tfCodigo);
        add (tfNome);

        //set component bounds (only needed by Absolute Positioning)
        btGravar.setBounds (20, 130, 100, 20);
        btLer.setBounds (135, 130, 100, 20);
        lbCodigo.setBounds (25, 40, 100, 25);
        lbNome.setBounds (25, 80, 100, 25);
        tfCodigo.setBounds (100, 40, 100, 25);
        tfNome.setBounds (100, 80, 310, 25);
    }
    
    public void definirEventos() {
	
        btGravar.addActionListener(new ActionListener() {
        	
			public void actionPerformed(ActionEvent e) {
			
				String[] linhas = new String[2];
				linhas[0] = tfCodigo.getText();
				linhas[1] = tfNome.getText();
				
				JOptionPane.showMessageDialog(btGravar, arquivoTexto.gravar("C:/Users/1050481723027/Documents/Teste_Java/", linhas[0] + ".txt", linhas));
			}
		});
        
        btLer.addActionListener(new ActionListener() {
        	
			public void actionPerformed(ActionEvent e) {
				
				String[] linhas = arquivoTexto.ler("C:/Users/1050481723027/Documents/Teste_Java/", tfCodigo.getText() + ".txt", 2);

				if (linhas == null) {
					
					JOptionPane.showMessageDialog(btLer, "Não localizado!");
				} else {
					
					tfNome.setText(linhas[1]); // Joga o valor que foi pego no código no campo de nome
				}
			}
		});
    }


    public static void main (String[] args) {
        JFrame frame = new JFrame ("GuiCadastro");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new GuiCadastro());
        frame.pack();
        frame.setVisible (true);
    }
}
