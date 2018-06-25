package model;

public class Filme {
	private int codigoFilme;
	private String nome; 
	private String dataLancamento; 
	private String diretor; 
	private String bairro; 
	private int    tempo; 
	private String genero;
	private String classificacao;
	private String descricao;
	private int codigoFunc;
	
	public void mostrar(){
        System.out.println("["+codigoFilme+","+nome+","+dataLancamento+","+diretor+","+bairro+","+tempo+","+genero+","+classificacao+","+descricao+","+codigoFunc+"]");
    }
	
	public int getCodigoFilme() {
		return codigoFilme;
	}
	public void setCodigoFilme(int codigoFilme) {
		this.codigoFilme = codigoFilme;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDataLancamento() {
		return dataLancamento;
	}
	public void setDataLancamento(String dataLancamento) {
		this.dataLancamento = dataLancamento;
	}
	public String getDiretor() {
		return diretor;
	}
	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public int getTempo() {
		return tempo;
	}
	public void setTempo(int tempo) {
		this.tempo = tempo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getClassificacao() {
		return classificacao;
	}
	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getCodigofunc() {
		return codigoFunc;
	}
	public void setCodigofunc(int codigofunc) {
		this.codigoFunc = codigofunc;
	}
}
