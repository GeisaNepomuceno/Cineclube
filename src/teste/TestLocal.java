package teste;

import integracaobd.*;

public class TestLocal {

	public static void main(String[] args) {
		BDLocal bd = new BDLocal();
		bd.getConnection();
		bd.close();
	}
}
