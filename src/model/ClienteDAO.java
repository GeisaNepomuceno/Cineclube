package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import integracaobd.BD;

public class ClienteDAO {
	
	private String men, sql; 
	private BD bd; 
	
	public ClienteDAO() {
		bd = new BD();
	}
	
	public String salvar(Cliente c) {
		sql = "insert into cliente values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			bd.getConnection();
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, c.getCodigo());
			bd.st.setString(2, c.getNome());
			bd.st.setString(3, c.getEndereco());
			bd.st.setString(4, c.getCidade());
			bd.st.setString(5, c.getBairro());
			bd.st.setInt(6, c.getCep());
			bd.st.setString(7, c.getRg());
			bd.st.setString(8, c.getCpf());
			bd.st.setString(9, c.getDataNasc());
			bd.st.setInt(10, c.getTelefone());
			bd.st.setString(11, c.getEmail());
			bd.st.setInt(12, c.getCelular());
			bd.st.setString(13, c.getSexo());
			
			men = "Cliente cadastrado com sucesso!";
		}
		catch (SQLException erro) {
				int pos = erro.toString().indexOf("PRIMARY KEY");
				if(pos>=0) { //inicio da alteração
					sql = "update cliente set nome=?, endereco=?, cidade=?, bairro=?, cep=?, cpf=?, rg=?, datanascimento=?, telefone=?, email=?, celular=?, sexo=? "+
				          "where id_cliente = ?";
					try {
						
						bd.st.setString(1, c.getNome());
						bd.st.setString(2, c.getEndereco());
						bd.st.setString(3, c.getCidade());
						bd.st.setString(4, c.getBairro());
						bd.st.setInt(5, c.getCep());
						bd.st.setString(6, c.getRg());
						bd.st.setString(7, c.getCpf());
						bd.st.setString(8, c.getDataNasc());
						bd.st.setInt(9, c.getTelefone());
						bd.st.setString(10, c.getEmail());
						bd.st.setInt(11, c.getCelular());
						bd.st.setString(12, c.getSexo());	
						bd.st.setInt(13, c.getCodigo());
						bd.st.executeUpdate();
						men = "Cliente alterado com sucesso!";
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
		
		sql = "delete from cliente where id_cliente = ?";
		
		try {
			
			bd.getConnection(); 
			bd.con.prepareStatement(sql); 
			bd.st.setInt(1, codigo);
			
			int r = bd.st.executeUpdate(); 
			
			if (r==1) {
				
				men = "Excluído com sucesso!";		
				
			} else {
				
				men = "Cliente não encontrado!";
			}
			
		} catch (Exception e) {
			
			men = "Falha na exclusão" + e.toString();
		}
		finally {
			bd.close();
		}
		
		return men;
		
	}
	
	public Cliente Localizar(int codigo) {
		
		sql = "select * from cliente where id_cliente = ?";
		
		Cliente c = new Cliente();
		
		try {
			
			bd.getConnection();
			bd.con.prepareStatement(sql);
			bd.st.setInt(1, codigo);
			bd.rs = bd.st.executeQuery();
			
			if(bd.rs.next()) {
				c.setCodigo(bd.rs.getInt("codigo"));
				c.setNome(bd.rs.getString("nome"));
				c.setEndereco(bd.rs.getString("endereco"));
				c.setCidade(bd.rs.getString("cidade"));
				c.setBairro(bd.rs.getString("bairro"));
				c.setCep(bd.rs.getInt("cep"));
				c.setRg(bd.rs.getString("rg"));
				c.setCpf(bd.rs.getString("cpf"));
				c.setDataNasc(bd.rs.getString("data_nascimento"));
				c.setTelefone(bd.rs.getInt("telefone"));
				c.setEmail(bd.rs.getString("email"));
				c.setCelular(bd.rs.getInt("celular"));
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
		
		// ler o banco do começo ao fim
		sql = "select * from cliente";
		
		try {
			
			bd.getConnection(); // conexao com o banco
			bd.st = bd.con.prepareStatement(sql);
			bd.rs = bd.st.executeQuery(); // rs um objeto em memï¿½ria que representa uma tabela com os dados do select, a primeira linha ï¿½ o header da coluna
			
			while (bd.rs.next()) {
				
				Cliente c = new Cliente();
				
				c.setCodigo(bd.rs.getInt("codigo"));
				c.setNome(bd.rs.getString("nome"));
				c.setEndereco(bd.rs.getString("endereco"));
				c.setCidade(bd.rs.getString("cidade"));
				c.setBairro(bd.rs.getString("bairro"));
				c.setCep(bd.rs.getInt("cep"));
				c.setRg(bd.rs.getString("rg"));
				c.setCpf(bd.rs.getString("cpf"));
				c.setDataNasc(bd.rs.getString("data_nascimento"));
				c.setTelefone(bd.rs.getInt("telefone"));
				c.setEmail(bd.rs.getString("email"));
				c.setCelular(bd.rs.getInt("celular"));
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
		

			