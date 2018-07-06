/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import integracaobd.BDLocal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import services.BD;

/**
 *
 * @author Jefer
 */
public class SessaoDAO {
        private String sql, men;
	private BDLocal bd;
	
	public SessaoDAO() {
		bd = new BDLocal();
	}
	
	public String salvar(Sessao p) {
		sql = "insert into sessao(id_sessao, animacao, duracao, data, id_funcionario, id_filme)" 
				+ "values(?,?,?,?,?,?)";
		try {
			bd.getConnection();
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, p.getCodigo());
			bd.st.setString(2, p.getAnimacao());
			bd.st.setString(3, p.getDuracao());
            bd.st.setString(4, p.getData());
            bd.st.setString(5, p.getIdFuncionario());
            bd.st.setString(6, p.getIdFilme());
			
			bd.st.executeUpdate();
			men = "Sessao gravada com sucesso!";
		}
		catch(SQLException erro) {
			int pos = erro.toString().indexOf("PRIMARY KEY");
			if(pos>=0) { //inicio da alteracao
				sql = "update sessao set animacao=?, duracao=?, data=?, id_funcionario=?, id_filme=? "+
			          "where id_sessao = ?";
				try {
					bd.st = bd.con.prepareStatement(sql);
					bd.st.setString(1, p.getAnimacao());
                    bd.st.setString(2, p.getDuracao());
                    bd.st.setString(3, p.getData());
                    bd.st.setString(4, p.getIdFuncionario());
                    bd.st.setString(5, p.getIdFilme());	
                    bd.st.setInt(6, p.getCodigo());
                                        
					bd.st.executeUpdate();
					men = "Sessao alterada com sucesso!";
				}
				catch(SQLException e) {
					men = "Falha na altera√ß√£o!";
				}
			}
		}
		finally {
			bd.close();
		}	
		return men;
	}
	
	public String excluir(int codigo) {
		
		sql = "delete from sessao where id_sessao = ?";
		try {
			
			bd.getConnection(); // conexao com o banco
			bd.st = bd.con.prepareStatement(sql);
			
			// numero um e para ser o primeiro parametro, da esquerda para a direita.
			// esse parametro 1 server como referencia do parametro la em cima, do codigo, ou seja,
			// esse parametro vai no lugar da interrogacao
			bd.st.setInt(1,  codigo); 
			int r = bd.st.executeUpdate(); // retorna a quantidade de linhas que ele excluiu
			
			if (r == 1) {
				
				men = "Sess„o deletada!";
			} else {
				
				men = "Sessao n„o encontrada!";
			}
			
		} catch (Exception e) {

			men = "Falha na exclus√£o" + e.toString();
		} finally {
			bd.close();
		}
		
		return men;
	}
	
	public Sessao localizar(int codigo) {
		
		sql = "select * from sessao where id_sessao = ?";

		// Criando o produto
		Sessao p = new Sessao();
		
		try {
			
			bd.getConnection(); // conexao com o banco
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1,  codigo); 
			bd.rs = bd.st.executeQuery(); // rs um objeto em memoria que representa uma tabela com os dados do select, a primeira linha e o header da coluna
			
			
			// Ou retorna um produto ou um objeto nulo
			if (bd.rs.next()) { // Copia banco no objeto produto
				
				p.setCodigo(bd.rs.getInt("id_sessao")); // transferindo do banco para o objeto
				p.setAnimacao(bd.rs.getString("animacao"));
				p.setDuracao(bd.rs.getString("duracao"));
                p.setData(bd.rs.getString("data"));
                p.setIdFuncionario(bd.rs.getString("id_funcionario"));
                p.setIdFilme(bd.rs.getString("id_filme"));
                                
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
}
