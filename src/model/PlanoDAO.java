package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import integracaobd.BDLocal;

public class PlanoDAO {
	
	private String men, sql;
	private BDLocal bd;
	
	public PlanoDAO() {
		bd = new BDLocal();
	}
	
	public String salvar(Plano p) {
		sql = "INSERT\r\n" + 
				"	INTO plano(id_plano,descricao,preco,id_funcionario)\r\n" + 
				"VALUES\r\n" + 
				"	(?,?,?,?)";
		
		try {
			bd.getConnection();
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, p.getCodplano());
			bd.st.setString(2, p.getDescricao());
			bd.st.setString(3, p.getPreco());
			bd.st.setInt(4, p.getCodfuncionario());
			bd.st.executeUpdate();
			
			men = "Plano cadastrado com sucesso!";
		}
		catch(SQLException erro) {
			int pos = erro.toString().indexOf("PRIMARY KEY");
			if(pos>=0) { //inicio da alteraï¿½ï¿½o
				sql = "update plano set id_funcionario=?,descricao=?,preco=?,id_funcionario=?";
				try {
					bd.getConnection();
					bd.st = bd.con.prepareStatement(sql);
					bd.st.setInt(1, p.getCodplano());
					bd.st.setString(2, p.getDescricao());
					bd.st.setString(3, p.getPreco());
					bd.st.setInt(4, p.getCodfuncionario());
					bd.st.executeUpdate();
					
					men = "Atualizado com sucesso!";
				}
				catch(SQLException e) {
					men = "ERRO! "+ e.toString();
				}
					
		}
	}		
		finally {bd.close();}
		
		return men;		
	}
	
	public String excluir(int codigo) {
		
		sql = "delete from plano where id_plano = ?";
		
		try {
			
			bd.getConnection(); 
			bd.con.prepareStatement(sql); 
			bd.st.setInt(1, codigo);
			
			int r = bd.st.executeUpdate(); 
			
			if (r==1) {
				
				men = "Excluido com sucesso!";		
				
			} else {
				
				men = "Cliente não encontrado!";
			}	
		} catch (Exception e) {
			
			men = "Falha na exclusão " + e.toString();
		}
		
		finally {
			bd.close();
		}
		return men;	
	}
	
public Plano localizar(int codigo) {
		
		sql = "select * from plano where id_plano = ?";
		
		Plano p = new Plano();
		
		try {
			
			bd.getConnection();
			bd.con.prepareStatement(sql);
			bd.st.setInt(1, codigo);
			bd.rs = bd.st.executeQuery();
			
			if(bd.rs.next()) {
				
				p.setCodplano(bd.rs.getInt("Código plano"));
				p.setDescricao(bd.rs.getString("Descrição"));
				p.setPreco(bd.rs.getString("Preço"));
				p.setCodfuncionario(bd.rs.getInt("Código funcionario"));
					
			}
			
			else {
				p = null;
			}
		} catch (Exception e) {
			p = null;
		}
		
		finally {
			bd.close();
		}
		
		return p;
	}

public List<Plano> getPlanos() {
	
	List<Plano> lista = new ArrayList<Plano>(); // Criar uma lista de produtos
	
	// ler o banco do comeï¿½o ao fim
	sql = "select * from plano";
	
	try {
		
		bd.getConnection(); // conexao com o banco
		bd.st = bd.con.prepareStatement(sql);
		bd.rs = bd.st.executeQuery(); // rs um objeto em memï¿½ria que representa uma tabela com os dados do select, a primeira linha ï¿½ o header da coluna
		
		while (bd.rs.next()) {
			
			Plano p = new Plano();
			
			p.setCodplano(bd.rs.getInt("Código plano"));
			p.setDescricao(bd.rs.getString("Descrição"));
			p.setPreco(bd.rs.getString("Preço"));
			p.setCodfuncionario(bd.rs.getInt("Código funcionario"));
			
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
