package model;

public class Plano {
	private String descricao;
	private String preco;
	private int codfuncionario, codplano;
	
	public Plano() {
		
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public int getCodfuncionario() {
		return codfuncionario;
	}

	public void setCodfuncionario(int codfuncionario) {
		this.codfuncionario = codfuncionario;
	}

	public int getCodplano() {
		return codplano;
	}

	public void setCodplano(int codplano) {
		this.codplano = codplano;
	}

	public Plano(String descricao, String preco, int codfuncionario, int codplano) {
		super();
		this.descricao = descricao;
		this.preco = preco;
		this.codfuncionario = codfuncionario;
		this.codplano = codplano;
	}
	
	
}