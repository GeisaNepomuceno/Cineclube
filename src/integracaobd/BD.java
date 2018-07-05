package integracaobd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BD {
	
	private final String LOGIN = "sa";
	private final String SENHA = "11223344";
	private final String DRIVER ="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private final String DATABASE = "java";
	private final String URL = "jdbc:sqlserver://localhost:1433;databasename="+DATABASE;
	public Connection con = null;
	public PreparedStatement st = null;
	public ResultSet rs = null;
	
	public boolean getConnection() {
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, LOGIN, SENHA);
			System.out.println("Conectado ao bd");
			return true;
		}
		catch(ClassNotFoundException erro) {
			System.out.println("Driver n encontrado");
			return false;
		}
		catch(SQLException erro){
			System.out.println(erro.toString());
			return false;
		}
	}
	
	public void close() {
		try {if(rs!=null) rs.close();} catch(SQLException erro) {}
		try {if(st!=null) st.close();} catch(SQLException erro) {}
		try {if(con!=null) con.close(); System.out.println("Desconectou");} catch(SQLException erro) {}
	}
	
}
