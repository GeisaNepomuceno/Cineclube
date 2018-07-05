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
	
	public String salvar(Filme c) {//METODO INSERIR OU ATUALIZAR
		sql = "INSERT\r\n" + 
				"	INTO filme(id_filme,nome,datalancamento,diretor,tempo,genero,classificacao,descricao,id_funcionario)\r\n" + 
				"VALUES\r\n" + 
				"	(?,?,?,?,?,?,?,?,?)";
		
		try {
			bd.getConnection();
			bd.st = bd.con.prepareStatement(sql);
                        bd.st.setInt(1, c.getCodfilme());
                        bd.st.setString(2, c.getNome());
                        bd.st.setString(3, c.getDataLancamento());
                        bd.st.setString(4, c.getDiretor());
                        bd.st.setString(5, c.getTempo());
                        bd.st.setString(6, c.getGenero());
                        bd.st.setString(7, c.getClassificacao());
                        bd.st.setString(8, c.getDescricao());
                        bd.st.setInt(9, c.getCodfuncionario());
                        
                        

			bd.st.executeUpdate();
			
			men = "Filme cadastrado com sucesso!";
		}
		catch (SQLException erro) {
				int pos = erro.toString().indexOf("PRIMARY KEY");
				if(pos>=0) { 
					sql = "UPDATE\r\n" + 
							"	filme\r\n" + 
							"SET\r\n" + 
							"	(id_filme=?,nome=?,datalancamento=?,diretor=?,tempo=?,genero=?,classificacao=?,descricao=?,id_funcionario=?)\r\n" + 
							"WHERE\r\n" + 
							"	id_filme=?";
					try {
						
						bd.st.setInt(1, c.getCodfilme());
                        bd.st.setString(2, c.getNome());
                        bd.st.setString(3, c.getDataLancamento());
                        bd.st.setString(4, c.getDiretor());
                        bd.st.setString(5, c.getTempo());
                        bd.st.setString(6, c.getGenero());
                        bd.st.setString(7, c.getClassificacao());
                        bd.st.setString(8, c.getDescricao());
                        bd.st.setInt(9, c.getCodfuncionario());
                        bd.st.setInt(10, c.getCodfilme());
						bd.st.executeUpdate();
						men = "Filme alterado com sucesso!";
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
	
public String excluir(int codigo) { //METODO DELETE
		
		sql = "delete from filme where id_filme = ?";
		
		try {
			
			bd.getConnection(); 
			bd.con.prepareStatement(sql); 
			bd.st.setInt(1, codigo);
			
			int r = bd.st.executeUpdate(); 
			
			if (r==1) {
				
				men = "Excluido com sucesso!";		
				
			} else {
				
				men = "Filme nao encontrado!";
			}
			
		} catch (Exception e) {
			
			men = "Falha! " + e.toString();
		}
		finally {
			bd.close();
		}
		
		return men;		
	}

public Filme localizar(int codigo) {//METODO SELECT
	
	sql = "select * from filme where id_filme = ?";
	
	Filme c = new Filme();
	
	try {
		
		bd.getConnection();
		bd.con.prepareStatement(sql);
		bd.st.setInt(1, codigo);
		bd.rs = bd.st.executeQuery();
		
		if(bd.rs.next()) {		
			c.setCodfilme(bd.rs.getInt("Código filme"));
			c.setNome(bd.rs.getString("nome"));
			c.setDataLancamento(bd.rs.getString("Data de lançamento"));
			c.setDiretor(bd.rs.getString("Diretor"));
			c.setTempo(bd.rs.getString("Tempo de duração"));
			c.setGenero(bd.rs.getString("Gênero"));
			c.setClassificacao(bd.rs.getString("Classificação"));
			c.setDescricao(bd.rs.getString("Descrição"));
			c.setCodfuncionario(bd.rs.getInt("Código funcionário"));
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

public List<Filme> getFilmes() {//METODO LISTAR TODOS OS CLIENTES (LISTA)
	
	List<Filme> lista = new ArrayList<Filme>(); // Criar uma lista de produtos
	
	// ler o banco do comeï¿½o ao fim
	sql = "select * from filme";
	
	try {
		
		bd.getConnection(); // conexao com o banco
		bd.st = bd.con.prepareStatement(sql);
		bd.rs = bd.st.executeQuery(); // rs um objeto em memï¿½ria que representa uma tabela com os dados do select, a primeira linha ï¿½ o header da coluna
		
		while (bd.rs.next()) {			
			Filme c = new Filme();
			
			c.setCodfilme(bd.rs.getInt("Código filme"));
			c.setNome(bd.rs.getString("nome"));
			c.setDataLancamento(bd.rs.getString("Data de lançamento"));
			c.setDiretor(bd.rs.getString("Diretor"));
			c.setTempo(bd.rs.getString("Tempo de duração"));
			c.setGenero(bd.rs.getString("Gênero"));
			c.setClassificacao(bd.rs.getString("Classificação"));
			c.setDescricao(bd.rs.getString("Descrição"));
			c.setCodfuncionario(bd.rs.getInt("Código funcionário"));
			
			lista.add(c); // adicionando o produto na lista
		}

	} 
	catch (Exception e) {	lista = null;} 
	finally {bd.close();}
	
	return lista;
}
	
}
