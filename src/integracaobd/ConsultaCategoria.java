package integracaobd;

import java.sql.SQLException;

public class ConsultaCategoria {
	public static void main(String[] args) {
		
		BD bd = new BD();
		if(bd.getConnection()) {
			String sql = "select * from categoria";
			try {
				bd.st = bd.con.prepareStatement(sql);
				bd.rs = bd.st.executeQuery();
				bd.rs.next();
				System.out.println(bd.rs.getString("codigo"));
				System.out.println(bd.rs.getString("nome"));
				
				bd.rs.next();
				System.out.println(bd.rs.getString(1));
				System.out.println(bd.rs.getString(2));

			}
			catch(SQLException erro) {
				
			}
		}
		else {
			System.out.println("Falha na conexão");
		}
	}
}
