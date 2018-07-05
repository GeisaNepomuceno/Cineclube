package model;

public class Cliente {
	private int codigo;
	private String nome; 
	private String endereco; 
	private String cidade; 
	private String bairro; 
	private String cep; 
	private String rg;
	private String cpf;
	private String dataNasc; 
	private String telefone; 
	private String email; 
	private String celular;
	private String sexo; 
	
	
	public Cliente() {
		
	}


//	@Override
//	public String toString() {
//		return "Cliente [codigo=" + codigo + ", nome=" + nome + ", endereco=" + endereco + ", cidade=" + cidade
//				+ ", bairro=" + bairro + ", cep=" + cep + ", rg=" + rg + ", cpf=" + cpf + ", dataNasc=" + dataNasc
//				+ ", telefone=" + telefone + ", email=" + email + ", celular=" + celular + ", sexo=" + sexo + "]";
//	}
        public void mostrar(){
            System.out.println("["+nome+","+endereco+","+cidade+","+endereco+","+bairro+","+cep+","+rg+","+cpf+","+dataNasc+","+telefone+","+email+","+celular+","+sexo+"]");
        }

	public Cliente(/*int codigo*/String nome, String endereco, String cidade, String bairro, String cep, String rg,
			String cpf, String dataNasc, String telefone, String email, String celular, String sexo) {
		super();
//		this.codigo = codigo;
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


//	public int getCodigo() {
//		return codigo;
//	}
//

//	public void setCodigo(int codigo) {
//		this.codigo = codigo;
//	}


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


	public String getCep() {
		return cep;
	}


	public void setCep(String cep) {
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


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCelular() {
		return celular;
	}


	public void setCelular(String celular) {
		this.celular = celular;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
}

	
	