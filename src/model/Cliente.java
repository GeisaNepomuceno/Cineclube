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
	private String sexo; 
	
	public void mostrar() {
		System.out.println("["+codigo+","+nome+","+endereco+","+cidade+","+bairro+","+cep+","+rg+","+cpf+","+dataNasc+","+telefone+","+email+","+celular+","+sexo+","+nome+"]");
	}
	
	public Cliente() {
		
	}

	public Cliente(int codigo, String nome, String endereco, String cidade, String bairro, int cep, String rg,
			String cpf, String dataNasc, int telefone, String email, int celular, String sexo) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.endereco = endereco;
		this.cidade = cidade;
		this.bairro = bairro;
		this.cep = cep;
		this.rg = rg;
		this.cpf = cpf;
		this.dataNasc = dataNasc;
		this.telefone = telefone;
		this.email = email;
		this.celular = celular;
		this.sexo = sexo;
	}

	@Override
	public String toString() {
		return "Cliente [codigo=" + codigo + ", nome=" + nome + ", endereco=" + endereco + ", cidade=" + cidade
				+ ", bairro=" + bairro + ", cep=" + cep + ", rg=" + rg + ", cpf=" + cpf + ", dataNasc=" + dataNasc
				+ ", telefone=" + telefone + ", email=" + email + ", celular=" + celular + ", sexo=" + sexo + "]";
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCelular() {
		return celular;
	}

	public void setCelular(int celular) {
		this.celular = celular;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

}
