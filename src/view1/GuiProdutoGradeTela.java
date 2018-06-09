package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.Produto;
import model.ProdutoDAO;
import services.BD;
import services.TableModel;

public class GuiProdutoGradeTela extends JPanel {
	private JButton btNovo;
	private JButton btSalvar;
	private JButton btBuscar;
	private JLabel lbCodigo;
	private JLabel lbNome;
	private JLabel lbPreco;
	private JLabel lbEstoque;
	private JButton btExcluir;
	private JTextField tfCodigo;
	private JTextField tfNome;
	private JTextField tfPreco;
	private JTextField tfEstoque;
	private ProdutoDAO pdao;
	private Produto p;

	private JTextField tfLocalizar;
	private JTable table;
	private DefaultTableModel model;
	private BD bd;

	public GuiProdutoGradeTela() {
		pdao = new ProdutoDAO();
		p = new Produto();
		bd = new BD();
		bd.getConnection();

		inicializarComponentes();
		definirEventos();
	}

	public void inicializarComponentes() {
		btNovo = new JButton("Novo");
		btSalvar = new JButton("Salvar");
		btBuscar = new JButton("Buscar");
		lbCodigo = new JLabel("Codigo");
		lbNome = new JLabel("Nome");
		lbPreco = new JLabel("Preço Unitario");
		lbEstoque = new JLabel("Estoque");
		btExcluir = new JButton("Excluir");
		tfCodigo = new JTextField(5);
		tfNome = new JTextField(5);
		tfPreco = new JTextField(5);
		tfEstoque = new JTextField(5);
		tfLocalizar = new JTextField(10);

		setPreferredSize(new Dimension(600, 430));
		setLayout(null);

		add(btNovo);
		add(btSalvar);
		add(btBuscar);
		add(lbCodigo);
		add(lbNome);
		add(lbPreco);
		add(lbEstoque);
		add(btExcluir);
		add(tfCodigo);
		add(tfNome);
		add(tfPreco);
		add(tfEstoque);
		add(tfLocalizar);

		btNovo.setBounds(5, 150, 75, 20);
		btSalvar.setBounds(85, 150, 80, 20);
		btBuscar.setBounds(105, 15, 75, 25);
		btExcluir.setBounds(170, 150, 90, 20);

		lbCodigo.setBounds(5, 15, 45, 25);
		lbNome.setBounds(5, 45, 45, 25);
		lbPreco.setBounds(5, 75, 90, 25);
		lbEstoque.setBounds(5, 105, 55, 25);
		tfCodigo.setBounds(55, 15, 45, 25);
		tfNome.setBounds(55, 45, 280, 25);
		tfPreco.setBounds(95, 75, 70, 25);
		tfEstoque.setBounds(60, 105, 35, 25);

		// Componentes relacionados a grade
		table = new JTable();
		atualizarGrade();
		
		JScrollPane scroller = new JScrollPane(table);
		scroller.setBounds(5, 220, 580, 200);
		add(scroller);
	}
	
	public void atualizarGrade() {
		model = TableModel.getModel(bd, "select * from produtos");
		table.setModel(model);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(20);
		table.getColumnModel().getColumn(0).setResizable(false);
		
		table.getColumnModel().getColumn(1).setPreferredWidth(300);
		table.getColumnModel().getColumn(1).setResizable(false);
		
		table.getColumnModel().getColumn(2).setPreferredWidth(30);
		table.getColumnModel().getColumn(2).setResizable(false);
		
		table.getColumnModel().getColumn(3).setPreferredWidth(30);
		table.getColumnModel().getColumn(3).setResizable(false);

		table.getTableHeader().setReorderingAllowed(false);
	}
	
	private void limparCaixas() {

		tfCodigo.setText("");
		tfNome.setText("");
		tfPreco.setText("");
		tfEstoque.setText("");
		tfCodigo.requestFocus(); // Volta para a primeira caixa para dar foco
		
	}

	public void definirEventos() {
		
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				tfCodigo.setText((String) table.getValueAt(table.getSelectedRow(), 0));
				tfNome.setText((String) table.getValueAt(table.getSelectedRow(), 1));
				tfPreco.setText((String) table.getValueAt(table.getSelectedRow(), 2));
				tfEstoque.setText((String) table.getValueAt(table.getSelectedRow(), 3));				
			}
		});

		btNovo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				limparCaixas();
			}
		});

		btBuscar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				p = pdao.localizar(Integer.parseInt(tfCodigo.getText()));
				
				if (p != null) {
					
					tfCodigo.setText("" + p.getCodigo());
					tfNome.setText(p.getNome());
					tfPreco.setText("" + p.getPreco());
					tfEstoque.setText("" + p.getEstoque());
				} else {
					JOptionPane.showMessageDialog(btBuscar, "Produto não encontrado");
					limparCaixas();
				}
			}
		});

		btSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				p = new Produto();
				
				p.setCodigo(Integer.parseInt(tfCodigo.getText()));
				p.setNome(tfNome.getText());
				p.setPreco(Double.parseDouble(tfPreco.getText()));
				p.setEstoque(Integer.parseInt(tfEstoque.getText()));
				
				JOptionPane.showMessageDialog(btSalvar, pdao.salvar(p));
				
				limparCaixas();
				
				atualizarGrade();
			}
		});

		btExcluir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int r = JOptionPane.showConfirmDialog(btExcluir, "Tem certeza?");
				
				if (r == 0) { // significa que o usuário apertou o primeiro botão, o botão sim
					
					JOptionPane.showMessageDialog(btExcluir, pdao.excluir(Integer.parseInt(tfCodigo.getText())));
					
					atualizarGrade();
				}
			}
		});
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("GuiProduto");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new GuiProdutoGradeTela());
		frame.pack();
		frame.setVisible(true);
	}
}
