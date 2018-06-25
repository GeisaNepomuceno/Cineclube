package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import integracaobd.BDLocal;

public class ClienteDAO {
	
	private String men, sql; 
	private BDLocal bd; 
	
	public ClienteDAO() {
		bd = new BDLocal();
	}
	
	public String salvar(Cliente c) {
		sql = "INSERT INTO funcionario(nome,cpf,rg,datanascimento,telefone,email,endereco,cidade,cep,bairro,celular,sexo) "
				+ "VALUES(?,?,?,	CONVERT(DATE, ?, 103),?,?,?,?,?,?,?,?)";
		
		try {
			bd.getConnection();
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setString(1, c.getNome());
			bd.st.setString(7, c.getCpf());
			bd.st.setString(6, c.getRg());
			bd.st.setString(8, c.getDataNasc());
			bd.st.setString(9, c.getTelefone());
			bd.st.setString(10, c.getEmail());
			bd.st.setString(2, c.getEndereco());
			bd.st.setString(3, c.getCidade());
			bd.st.setString(5, c.getCep());
			bd.st.setString(4, c.getBairro());			
			bd.st.setString(11, c.getCelular());
			bd.st.setString(12, c.getSexo());
			bd.st.executeUpdate();
			
			men = "Cliente cadastrado com sucesso!";
		}
		catch (SQLException erro) {
				int pos = erro.toString().indexOf("PRIMARY KEY");
				if(pos>=0) { //inicio da alteracao
					sql = "update cliente set nome=?, endereco=?, cidade=?, bairro=?, cep=?, cpf=?, rg=?, datanascimento=?, telefone=?, email=?, celular=?, sexo=? "+
				          "where id_cliente = ?";
					try {
						
						bd.st.setString(1, c.getNome());
						bd.st.setString(2, c.getEndereco());
						bd.st.setString(3, c.getCidade());
						bd.st.setString(4, c.getBairro());
						bd.st.setString(5, c.getCep());
						bd.st.setString(6, c.getRg());
						bd.st.setString(7, c.getCpf());
						bd.st.setString(8, c.getDataNasc());
						bd.st.setString(9, c.getTelefone());
						bd.st.setString(10, c.getEmail());
						bd.st.setString(11, c.getCelular());
						bd.st.setString(12, c.getSexo());	
//						bd.st.setInt(13, c.getCodigo());
						bd.st.executeUpdate();
						men = "Cliente alterado com sucesso!";
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
                                
    /**
     *
     * @param codigo
     * @return
     */
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
	
	public Cliente localizar(int codigo) {
		
		sql = "select * from cliente where id_cliente = ?";
		
		Cliente c = new Cliente();
		
		try {
			
			bd.getConnection();
			bd.con.prepareStatement(sql);
			bd.st.setInt(1, codigo);
			bd.rs = bd.st.executeQuery();
			
			if(bd.rs.next()) {
				
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
	
	public List<Cliente> getClientes() {
		
		List<Cliente> lista = new ArrayList<Cliente>(); // Criar uma lista de produtos
		
		// ler o banco do come�o ao fim
		sql = "select * from cliente";
		
		try {
			
			bd.getConnection(); // conexao com o banco
			bd.st = bd.con.prepareStatement(sql);
			bd.rs = bd.st.executeQuery(); // rs um objeto em mem�ria que representa uma tabela com os dados do select, a primeira linha � o header da coluna
			
			while (bd.rs.next()) {
				
				Cliente c = new Cliente();
				
				
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
		

			