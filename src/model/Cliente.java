package model;

public class Cliente {
	private int codigo;
	private String nome; 
	private String endereco; 
	private String cidade; 
	private String bairro; 
	private int cep; 
	private String rg;
	private String cpf;
	private String dataNasc; 
	private int telefone; 
	private String email; 
	private int celular;
	private char sexo; 
	
	public void mostrar() {
		System.out.println("["+codigo+","+nome+","+endereco+","+cidade+"]");
	}
	
//	public String toString() {
//		return ("["+codigo+","+nome+","+preco+","+estoque+"]");
//	}
//	
//	public Produto() {
//	}
//	
//	public Produto(int codigo, String nome, double preco, int estoque) {
//		this.codigo = codigo;
//		this.nome = nome;
//		this.preco = preco;
//		this.estoque = estoque;
//	}
	
	
}
