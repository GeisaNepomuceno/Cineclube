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
	
	public String salvar(Cliente c) {//METODO INSERIR OU ATUALIZAR
		sql = "INSERT INTO cliente(id_cliente,nome,cpf,rg,datanascimento,telefone,email,endereco,cidade,cep,bairro,celular,sexo,id_funcionario) "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
						bd.getConnection();
						bd.st = bd.con.prepareStatement(sql);
                        bd.st.setInt(1, c.getCodigo());
                        bd.st.setString(2, c.getNome());
                        bd.st.setString(3, c.getCpf());
                        bd.st.setString(4, c.getRg());
                        bd.st.setString(5, c.getDataNasc());
                        bd.st.setString(6, c.getTelefone());
                        bd.st.setString(7, c.getEmail());
                        bd.st.setString(8, c.getEndereco());
                        bd.st.setString(9, c.getCidade());
                        bd.st.setString(10, c.getCep());
                        bd.st.setString(11, c.getBairro());
                        bd.st.setString(12, c.getCelular());
                        bd.st.setString(13, c.getSexo());
                        bd.st.setInt(14, c.getCodfuncionario());
                        
                        bd.st.executeUpdate();
			
			men = "Cliente cadastrado com sucesso!";
		}
		catch (SQLException erro) {
				int pos = erro.toString().indexOf("PRIMARY KEY");
				if(pos>=0) { 
					sql = "update cliente set id_cliente=?, nome=?, endereco=?, cidade=?, bairro=?, cep=?, rg=?, cpf=?,"
							+ "datanascimento=?, telefone=?, email=?, celular=?, sexo=?, id_funcionario=? "+
				          "where id_cliente = ?";
					try {
						
						bd.st.setInt(1, c.getCodigo());
						bd.st.setString(2, c.getNome());
						bd.st.setString(3, c.getEndereco());
						bd.st.setString(4, c.getCidade());
						bd.st.setString(5, c.getBairro());
						bd.st.setString(6, c.getCep());
						bd.st.setString(7, c.getRg());
						bd.st.setString(8, c.getCpf());
						bd.st.setString(9, c.getDataNasc());
						bd.st.setString(10, c.getTelefone());
						bd.st.setString(11, c.getEmail());
						bd.st.setString(12, c.getCelular());
						bd.st.setString(13, c.getSexo());	
						bd.st.setInt(14, c.getCodfuncionario());
						bd.st.setInt(15, c.getCodigo());
						bd.st.executeUpdate();
						men = "Cliente alterado com sucesso!";
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
	
	public String excluir(int codigo) { //METODO DELETE
		
		sql = "delete from cliente where id_cliente = ?";
		
		try {
			
			bd.getConnection(); 
			bd.con.prepareStatement(sql); 
			bd.st.setInt(1, codigo);
			
			int r = bd.st.executeUpdate(); 
			
			if (r==1) {
				
				men = "Excluido com sucesso!";		
				
			} else {
				
				men = "Cliente nao encontrado!";
			}
			
		} catch (Exception e) {
			
			men = "Falha! " + e.toString();
		}
		finally {
			bd.close();
		}
		
		return men;
		
	}
	
	public Cliente localizar(int codigo) {//METODO SELECT
		
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
	
	public List<Cliente> getClientes() {//METODO LISTAR TODOS OS CLIENTES (LISTA)
		
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
		

			