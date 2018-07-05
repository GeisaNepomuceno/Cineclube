package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import services.BD;

public class PlanoDAO{

	private String sql, men;
	private BD bd;
	
	public PlanoDAO() {
		bd = new BD();
	}
	
	public String salvar(Plano p) {
		sql = "INSERT INTO plano(descricao,preco,id_funcionario) VALUES (?,?,?)";    
		try {
			bd.getConnection();
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setString(1, p.getDescricao());
			bd.st.setDouble(2, p.getPreco());
			bd.st.setInt(3, p.getId_func());
			
	
			bd.st.executeUpdate();
			men = "Produto gravado com sucesso!";
		}
		catch(SQLException erro) {
			int pos = erro.toString().indexOf("PRIMARY KEY");
			if(pos>=0) { //inicio da alteracao
				sql = "update produtos set nome=?, preco=?, estoque=? "+
			          "where codigo = ?";
				try {
					bd.st = bd.con.prepareStatement(sql);
					bd.st.setString(1, p.getDescricao());
					bd.st.setDouble(2, p.getPreco());
					bd.st.setDouble(3, p.getId_func());
					bd.st.executeUpdate();
					men = "Plano alterado com sucesso!";
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
		
		sql = "delete from plano where codigo = ?";
		try {
			
			bd.getConnection(); // conexao com o banco
			bd.st = bd.con.prepareStatement(sql);
			
			// numero um e para ser o primeiro parametro, da esquerda para a direita.
			// esse parametro 1 server como referencia do parametro la em cima, do codigo, ou seja,
			// esse parametro vai no lugar da interrogacao
			bd.st.setInt(1,  codigo); 
			int r = bd.st.executeUpdate(); // retorna a quantidade de linhas que ele excluiu
			
			if (r == 1) {
				
				men = "Produto excluído com sucesso";
			} else {
				
				men = "Produto não encontrado!";
			}
			
		} catch (Exception e) {

			men = "Falha na exlusão" + e.toString();
		} finally {
			bd.close();
		}
		
		return men;
	}
	
	public Plano localizar(int codigo) {
		
		sql = "select * from plano where codigo = ?";

		// Criando o produto
		Plano p = new Plano();
		
		try {
			
			bd.getConnection(); // conexao com o banco
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1,  codigo); 
			bd.rs = bd.st.executeQuery(); // rs um objeto em memoria que representa uma tabela com os dados do select, a primeira linha e o header da coluna
			
			
			// Ou retorna um produto ou um objeto nulo
			if (bd.rs.next()) { // Copia banco no objeto Plano
				
				 // transferindo do banco para o objeto
				p.setDescricao(bd.rs.getString("descricao"));
				p.setPreco(bd.rs.getDouble("preco"));
				
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
	
	public List<Plano> getPlanos() {
		
		List<Plano> lista = new ArrayList<Plano>(); // Criar uma lista de Planos
		
		// ler o banco do come�o ao fim
		sql = "select * from plano";
		
		try {
			
			bd.getConnection(); // conex�o com o banco
			bd.st = bd.con.prepareStatement(sql);
			bd.rs = bd.st.executeQuery(); // rs um objeto em memoria que representa uma tabela com os dados do select, a primeira linha e o header da coluna
			
			while (bd.rs.next()) {
				
				Plano p = new Plano();
				
				p.setDescricao(bd.rs.getString("codigo"));// transferindo do banco para o objeto
				p.setPreco(bd.rs.getDouble("preco"));
				p.setId_func(bd.rs.getInt("id_funcionario"));
				
				lista.add(p); // adicionando o Plano na lista
			}

		} catch (Exception e) {

			lista = null;
		} finally {
			bd.close();
		}
		
		return lista;
	}
}
