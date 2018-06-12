package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import services.BD;

public class ProdutoDAO{

	private String sql, men;
	private BD bd;
	
	public ProdutoDAO() {
		bd = new BD();
	}
	
	public String salvar(Produto p) {
		sql = "insert into produtos values(?,?,?,?)";
		try {
			bd.getConnection();
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, p.getCodigo());
			bd.st.setString(2, p.getNome());
			bd.st.setDouble(3, p.getPreco());
			bd.st.setInt(4, p.getEstoque());
			bd.st.executeUpdate();
			men = "Produto gravado com sucesso!";
		}
		catch(SQLException erro) {
			int pos = erro.toString().indexOf("PRIMARY KEY");
			if(pos>=0) { //inicio da alteração
				sql = "update produtos set nome=?, preco=?, estoque=? "+
			          "where codigo = ?";
				try {
					bd.st = bd.con.prepareStatement(sql);
					bd.st.setString(1, p.getNome());
					bd.st.setDouble(2, p.getPreco());
					bd.st.setInt(3, p.getEstoque());
					bd.st.setInt(4, p.getCodigo());					
					bd.st.executeUpdate();
					men = "Produto alterado com sucesso!";
				}
				catch(SQLException e) {
					men = "Falha na alteração!";
				}
			}
		}
		finally {
			bd.close();
		}	
		return men;
	}
	
	public String excluir(int codigo) {
		
		sql = "delete from produtos where codigo = ?";
		try {
			
			bd.getConnection(); // conexï¿½o com o banco
			bd.st = bd.con.prepareStatement(sql);
			
			// nï¿½mero um ï¿½ para ser o primeiro parametro, da esquerda para a direita.
			// esse parametro 1 server como referencia do parametro lï¿½ em cima, do cï¿½digo, ou seja,
			// esse parametro vai no lugar da interrogaï¿½ï¿½o
			bd.st.setInt(1,  codigo); 
			int r = bd.st.executeUpdate(); // retorna a quantidade de linhas que ele excluiu
			
			if (r == 1) {
				
				men = "Produto excluÃ­do com sucesso";
			} else {
				
				men = "Produto nÃ£o encontrado!";
			}
			
		} catch (Exception e) {

			men = "Falha na exlusÃ£o" + e.toString();
		} finally {
			bd.close();
		}
		
		return men;
	}
	
	public Produto localizar(int codigo) {
		
		sql = "select * from produtos where codigo = ?";

		// Criando o produto
		Produto p = new Produto();
		
		try {
			
			bd.getConnection(); // conexï¿½o com o banco
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1,  codigo); 
			bd.rs = bd.st.executeQuery(); // rs um objeto em memï¿½ria que representa uma tabela com os dados do select, a primeira linha ï¿½ o header da coluna
			
			
			// Ou retorna um produto ou um objeto nulo
			if (bd.rs.next()) { // Copia banco no objeto produto
				
				p.setCodigo(bd.rs.getInt("codigo")); // transferindo do banco para o objeto
				p.setNome(bd.rs.getString("nome"));
				p.setPreco(bd.rs.getDouble("preco"));
				p.setEstoque(bd.rs.getInt("estoque"));
			} else {
				
				p = null;
			}

		} catch (Exception e) {

			p = null;
		} finally {
			bd.close();
		}
		
		return p;
	}
	
	public List<Produto> getProdutos() {
		
		List<Produto> lista = new ArrayList<Produto>(); // Criar uma lista de produtos
		
		// ler o banco do comeï¿½o ao fim
		sql = "select * from produtos";
		
		try {
			
			bd.getConnection(); // conexï¿½o com o banco
			bd.st = bd.con.prepareStatement(sql);
			bd.rs = bd.st.executeQuery(); // rs um objeto em memï¿½ria que representa uma tabela com os dados do select, a primeira linha ï¿½ o header da coluna
			
			while (bd.rs.next()) {
				
				Produto p = new Produto();
				
				p.setCodigo(bd.rs.getInt("codigo")); // transferindo do banco para o objeto
				p.setNome(bd.rs.getString("nome"));
				p.setPreco(bd.rs.getDouble("preco"));
				p.setEstoque(bd.rs.getInt("estoque"));
				
				lista.add(p); // adicionando o produto na lista
			}

		} catch (Exception e) {

			lista = null;
		} finally {
			bd.close();
		}
		
		return lista;
	}
}
