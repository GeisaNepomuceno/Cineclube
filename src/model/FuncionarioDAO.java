package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import integracaobd.BDLocal;

public class FuncionarioDAO {
	
	private String men, sql; 
	private BDLocal bd; 
	
	public FuncionarioDAO() {
		bd = new BDLocal();
	}
	
	public String salvar(Funcionario f) {
		sql = "INSERT INTO funcionario(id_funcionario,nome,cpf,rg,datanascimento,telefone,email,endereco,cidade,cep,bairro,celular,sexo) "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			bd.getConnection();
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, f.getCodigo());
			bd.st.setString(2, f.getNome());
			bd.st.setString(3, f.getEndereco());
			bd.st.setString(4, f.getCidade());
			bd.st.setString(5, f.getBairro());
			bd.st.setString(6, f.getCep());
			bd.st.setString(7, f.getRg());
			bd.st.setString(8, f.getCpf());
			bd.st.setString(9, f.getDataNasc());
			bd.st.setString(10, f.getTelefone());
			bd.st.setString(11, f.getEmail());	
			bd.st.setString(12, f.getCelular());
			bd.st.setString(13, f.getSexo());
			bd.st.executeUpdate();
			
			men = "Funcionario cadastrado com sucesso!";
		}
		catch (SQLException erro) {
				int pos = erro.toString().indexOf("PRIMARY KEY");
				if(pos>=0) { //inicio da alteraï¿½ï¿½o
					sql = "update funcionario set id_funcionario=?, nome=?, endereco=?, cidade=?, bairro=?, cep=?, cpf=?, rg=?, datanascimento=?, telefone=?, email=?, celular=?, sexo=? "+
				          "where id_funcionario = ?";
					try {
						
						bd.st = bd.con.prepareStatement(sql);
						bd.st.setInt(1, f.getCodigo());
						bd.st.setString(2, f.getNome());
						bd.st.setString(3, f.getEndereco());
						bd.st.setString(4, f.getCidade());
						bd.st.setString(5, f.getBairro());
						bd.st.setString(6, f.getCep());
						bd.st.setString(7, f.getRg());
						bd.st.setString(8, f.getCpf());
						bd.st.setString(9, f.getDataNasc());
						bd.st.setString(10, f.getTelefone());
						bd.st.setString(11, f.getEmail());	
						bd.st.setString(12, f.getCelular());
						bd.st.setString(13, f.getSexo());
						bd.st.setInt(14, f.getCodigo());
						bd.st.executeUpdate();
						men = "Funcionario alterado com sucesso!";
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
		
		sql = "delete from funcionario where id_funcionario = ?";
		
		try {
			
			bd.getConnection(); 
			bd.con.prepareStatement(sql); 
			bd.st.setInt(1, codigo);
			
			int r = bd.st.executeUpdate(); 
			
			if (r==1) {
				
				men = "Excluido com sucesso!";		
				
			} else {
				
				men = "Funcionario nao encontrado!";
			}
			
		} catch (Exception e) {
			
			men = "Falha na exclusao" + e.toString();
		}
		finally {
			bd.close();
		}
		
		return men;
		
	}
	
	public Funcionario localizar(int codigo) {
		
		sql = "select * from funcionario where id_funcionario = ?";
		
		Funcionario c = new Funcionario();
		
		try {
			
			bd.getConnection();
			bd.con.prepareStatement(sql);
			bd.st.setInt(1, codigo);
			bd.rs = bd.st.executeQuery();
			
			if(bd.rs.next()) {
				
				c.setCodigo(bd.rs.getInt("Código"));
				c.setNome(bd.rs.getString("nome"));
				c.setEndereco(bd.rs.getString("endereco"));
				c.setCidade(bd.rs.getString("cidade"));
				c.setBairro(bd.rs.getString("bairro"));
				c.setCep(bd.rs.getString("cep"));
				c.setRg(bd.rs.getString("rg"));
				c.setCpf(bd.rs.getString("cpf"));
				c.setDataNasc(bd.rs.getString("data_nascimento"));
				c.setTelefone(bd.rs.getString("telefone"));
				c.setEmail(bd.rs.getString("email"));
				c.setCelular(bd.rs.getString("celular"));
				c.setSexo(bd.rs.getString("sexo"));
					
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
	
	public List<Funcionario> getFuncionarios() {
		
		List<Funcionario> lista = new ArrayList<Funcionario>(); // Criar uma lista de funcionarios
		
		// ler o banco do comeï¿½o ao fim
		sql = "select * from funcionario";
		
		try {
			
			bd.getConnection(); // conexao com o banco
			bd.st = bd.con.prepareStatement(sql);
			bd.rs = bd.st.executeQuery(); // rs um objeto em memï¿½ria que representa uma tabela com os dados do select, a primeira linha ï¿½ o header da coluna
			
			while (bd.rs.next()) {
				
				Funcionario c = new Funcionario();
				
				c.setCodigo(bd.rs.getInt("Código"));
				c.setNome(bd.rs.getString("nome"));
				c.setEndereco(bd.rs.getString("endereco"));
				c.setCidade(bd.rs.getString("cidade"));
				c.setBairro(bd.rs.getString("bairro"));
				c.setCep(bd.rs.getString("cep"));
				c.setRg(bd.rs.getString("rg"));
				c.setCpf(bd.rs.getString("cpf"));
				c.setDataNasc(bd.rs.getString("data_nascimento"));
				c.setTelefone(bd.rs.getString("telefone"));
				c.setEmail(bd.rs.getString("email"));
				c.setCelular(bd.rs.getString("celular"));
				c.setSexo(bd.rs.getString("sexo"));
				
				lista.add(c); // adicionando o produto na lista
			}

		} catch (Exception e) {

			lista = null;
		} finally {
			
			bd.close();
		}
		
		return lista;
	}
}
		

			