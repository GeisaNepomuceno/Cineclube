package model;

public class Plano {
//	private int codigo;
	private String descricao;
	private double preco;
	private int id_func; 
	
	public int getId_func() {
		return id_func;
	}

	public void setId_func(int id_func) {
		this.id_func = id_func;
	}

	

	public void mostrar() {
		System.out.println("["+descricao+","+preco+"]");
	}
	
	public String toString() {
		return ("["+preco+","+descricao+"]");
	}
	
	public Plano() {
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Plano(String descricao, double preco) {
		super();
		this.descricao = descricao;
		this.preco = preco;
	}
	
}
	