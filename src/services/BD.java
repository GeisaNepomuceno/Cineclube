package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BD {
	
	private final String DATABASE = "cineclube";
	private final String LOGIN = "Geisa";
	private final String SENHA = "e#ELu3:*";
	private final String URL = "jdbc:sqlserver://picineclube.database.windows.net:1433;databasename="+DATABASE;
	private final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public Connection con = null;
	public PreparedStatement st = null; 
	public  ResultSet rs = null;
	
	public boolean getConnection() {
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, LOGIN, SENHA);
			System.out.println("Conectou");
			return true;
		}
		catch(ClassNotFoundException erro) {
			System.out.println("Driver não encontrado");
			return false;
		}
		catch(SQLException erro) {
			System.out.println(erro.toString());
			return false;
		}	
	}
	
	public void close() {
		try { if(rs!=null) rs.close(); } catch(SQLException erro) {}
		try { if(st!=null) st.close(); } catch(SQLException erro) {}
		try { 
			if(con!=null) {
				con.close();
				System.out.println("Desconectou");
			}
		} 
		catch(SQLException erro) {}
	}
	
	public static void main(String[] args) {
		BD bd = new BD();
		bd.getConnection();
		bd.close();
	}
}
