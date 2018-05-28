/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integracaobd;

/**
 *
 * @author Jefer
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexaoBD {
	String DATABASE = "cineclub";
    String LOGIN = "Saito";
    String SENHA = "}5KtN2w/";
    String URL = "jdbc:sqlserver://picineclub.database.windows.net:1433;databasename="+DATABASE;
    String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    Connection con = null;
    PreparedStatement st = null; 
    ResultSet rs = null;
    
    public boolean getConnection() {
    	try {
    		Class.forName(DRIVER);
    		con = DriverManager.getConnection(URL, LOGIN, SENHA);
    		System.out.println("Conectado ao BD");
    		return true;
    	}
    	catch(ClassNotFoundException erro) {
    		System.out.println("BD não encontrado");
    		return false;
    	}
    	catch(SQLException erro) {
    		System.out.println(erro.toString());
    		return false;
    	}
    }
    
    public void close() {
    	try {if(rs!=null) rs.close();} catch(SQLException erro) {}
    	try {if(st!=null) st.close();} catch(SQLException erro) {}
    	try {if(con!=null) con.close(); System.out.println("Desconectou!");} catch(SQLException erro) {} 
    }
}
