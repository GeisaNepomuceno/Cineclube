package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import integracaobd.BDLocal;

public class FilmeDAO {
	
	private String men, sql; 
	private BDLocal bd; 
	
	public FilmeDAO() {
		bd = new BDLocal();
	}
	
	public String salvar(Filme f) {
		sql = "INSERT\n" +
"	INTO filme(nome,datalancamento,diretor,tempo,genero,classificacao,descricao,id_funcionario)\n" + "VALUES\n" + "	(?,CONVERT(DATE, ?, 103),?,?,?,?,?,?)";
		
		try {
			bd.getConnection();
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setString(1, f.getNome());
			bd.st.setString(2, f.getDataLancamento());
			bd.st.setString(3, f.getDiretor());
			bd.st.setInt(4, f.getTempo());
			bd.st.setString(5, f.getGenero());
			bd.st.setString(6, f.getClassificacao());
			bd.st.setString(7, f.getDescricao());
			
			
			men = "filme cadastrado com sucesso!";
		}
		catch (SQLException erro) {
				int pos = erro.toString().indexOf("PRIMARY KEY");
				if(pos>=0) { //inicio da alteracao
					sql = "update filme set nome=?, endereco=?, cidade=?, bairro=?, cep=?, cpf=?, rg=?, datanascimento=?, telefone=?, email=?, celular=?, sexo=? "+
				          "where id_filme = ?";
					try {
						
						bd.st = bd.con.prepareStatement(sql);
                                                bd.st.setString(1, f.getNome());
                                                bd.st.setString(2, f.getDataLancamento());
                                                bd.st.setString(3, f.getDiretor());
                                                bd.st.setInt(4, f.getTempo());
                                                bd.st.setString(5, f.getGenero());
                                                bd.st.setString(6, f.getClassificacao());
                                                bd.st.setString(7, f.getDescricao());
						bd.st.executeUpdate();
						men = "filme alterado com sucesso!";
					}
		catch(SQLException e) {
                    men = "Falha na alteração!";
		}
		finally {
                    bd.close();
		}
                                }   
                }
                 return men;
        }
	
            public String excluir(int codigo) {
		
		sql = "delete from filme where id_filme = ?";
		
		try {
			
			bd.getConnection(); 
			bd.con.prepareStatement(sql); 
			bd.st.setInt(13, codigo);
			
			int r = bd.st.executeUpdate(); 
			
			if (r==1) {
				
				men = "Excluido com sucesso!";		
				
			} else {
				
				men = "filme nao encontrado!";
			}
			
		} catch (Exception e) {
			
			men = "Falha na exclusao" + e.toString();
		}
		finally {
			bd.close();
		}
		
		return men;
		
	}
	
	public Filme localizar(int codigo) {
		
		sql = "select * from filme where id_filme = ?";
		
		Filme f = new Filme();
		
		try {
			
			bd.getConnection();
			bd.con.prepareStatement(sql);
			bd.st.setInt(1, codigo);
			bd.rs = bd.st.executeQuery();
			
			if(bd.rs.next()) {
				
                                f.setNome(bd.rs.getString("nome"));
				f.setDataLancamento(bd.rs.getString("datalancamento"));
				f.setDiretor(bd.rs.getString("diretor"));
				f.setTempo(bd.rs.getInt("tempo"));
                                f.setGenero(bd.rs.getString("genero"));
				f.setClassificacao(bd.rs.getString("classificacao"));
				f.setDescricao(bd.rs.getString("descricao"));
					
			}
			
			else {
				f = null;
			}
		} catch (Exception e) {
			f = null;
		}
		
		finally {
			bd.close();
		}
		
		return f;
	}
	
	public List<Filme> getfilmes() {
		
		List<Filme> lista = new ArrayList<Filme>(); // Criar uma lista de filmes
		
		// ler o banco do comeco ao fim
                
		sql = "select * from filme";
		
		try {
			
			bd.getConnection(); // conexao com o banco
			bd.st = bd.con.prepareStatement(sql);
			bd.rs = bd.st.executeQuery(); // rs um objeto em memoria que representa uma tabela com os dados do select, a primeira linha � o header da coluna
			
			while (bd.rs.next()) {
				
				Filme f = new Filme();
				
				
				f.setNome(bd.rs.getString("nome"));
				f.setDataLancamento(bd.rs.getString("datalancamento"));
				f.setDiretor(bd.rs.getString("diretor"));
				f.setTempo(bd.rs.getInt("tempo"));
                                f.setGenero(bd.rs.getString("genero"));
				f.setClassificacao(bd.rs.getString("classificacao"));
				f.setDescricao(bd.rs.getString("descricao"));
				
				lista.add(f); // adicionando o produto na lista
			}

		} catch (Exception e) {

			lista = null;
		} finally {
			
			bd.close();
		}
		
		return lista;
	}
}
		

			