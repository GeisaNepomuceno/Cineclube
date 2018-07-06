/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import integracaobd.BDLocal;
import java.sql.SQLException;

/**
 *
 * @author geisa
 */
public class EleicaoDAO {
    private String men, sql; 
	private BDLocal bd; 
	
	public EleicaoDAO() {
		bd = new BDLocal();
	}
	
	public String salvar(Eleicao f) {
		sql = "INSERT INTO eleicao(id_eleicao, descricao, id_funcionario) "
				+ "VALUES(?,?,?)";
		
		try {
			bd.getConnection();
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, f.getId()); //id
			bd.st.setString(2, f.getDescricao()); //nome
			bd.st.setString(3, f.getId_funcionario()); 
			
			bd.st.executeUpdate();
			
			men = "Sessao cadastrada com sucesso!";
		}
		catch (SQLException erro) {
				int pos = erro.toString().indexOf("PRIMARY KEY");
				if(pos>=0) { //inicio da altera��o
					sql = "update eleicao set id_sessao=?, descricao=?, id_funcionario=? "+
				          "where id_eleicao = ?";
					try {
						
						bd.st = bd.con.prepareStatement(sql);
						bd.getConnection();
                                                bd.st = bd.con.prepareStatement(sql);
                                                bd.st.setInt(1, f.getId());
                                                bd.st.setString(2, f.getDescricao()); 
                                                bd.st.setString(3, f.getId_funcionario()); 
                                                bd.st.setInt(4, f.getId());
                                                
                                                
						bd.st.executeUpdate();
						men = "Sessao alterada com sucesso!";
					}
		catch(SQLException e) {
                    men = "Falha na alteracao!";
		}					
                    }
                }
		finally {
            bd.close();
                }
          return men;
        }
	
	public String excluir(int codigo) {
		
		sql = "delete from sessao where id_eleicao = ?";
		
		try {
			
			bd.getConnection(); 
			bd.con.prepareStatement(sql); 
			bd.st.setInt(1, codigo);
			
			int r = bd.st.executeUpdate(); 
			
			if (r==1) {
				
				men = "Excluido com sucesso!";		
				
			} else {
				
				men = "Eleicao nao encontrado!";
			}
			
		} catch (Exception e) {
			
			men = "Falha na exclusao" + e.toString();
		}
		finally {
			bd.close();
		}
		
		return men;
		
	}
	
	public Eleicao localizar(int codigo) {
		
		sql = "select * from eleicao where id_eleicao = ?";
		
		Eleicao c = new Eleicao();
		
		try {
			
			bd.getConnection();
			bd.con.prepareStatement(sql);
			bd.st.setInt(1, codigo);
			bd.rs = bd.st.executeQuery();
			
			if(bd.rs.next()) {
				
				c.setId(bd.rs.getInt("id_eleicao"));
				c.setDescricao(bd.rs.getString("descricao"));
				c.setId_funcionario(bd.rs.getString("id_funcionario"));
				
					
			}
			
			else {
				c = null;
			}
		} catch (Exception e) {
			c = null;
		}
		
		finally {
			bd.close();
		}
		
		return c;
	}
}
