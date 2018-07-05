package model;

public class Filme {
	private int codfilme;
	private String nome; 
	private String dataLancamento; 
	private String diretor; 
	private String bairro; 
	private String	 tempo; 
	private String genero;
	private String classificacao;
	private String descricao;
	private int codfuncionario;
	
	public void mostrar(){
        System.out.println("["+codfilme+","+nome+","+dataLancamento+","+diretor+","+bairro+","+tempo+","+genero+","+classificacao+","+descricao+","+codfuncionario+"]");
    }
	
	public Filme() {
		
	}
	

	public Filme(int codfilme, String nome, String dataLancamento, String diretor, String bairro, String tempo,
			String genero, String classificacao, String descricao, int codfuncionario) {
		super();
		this.codfilme = codfilme;
		this.nome = nome;
		this.dataLancamento = dataLancamento;
		this.diretor = diretor;
		this.bairro = bairro;
		this.tempo = tempo;
		this.genero = genero;
		this.classificacao = classificacao;
		this.descricao = descricao;
		this.codfuncionario = codfuncionario;
	}

	public int getCodfilme() {
		return codfilme;
	}

	public void setCodfilme(int codfilme) {
		this.codfilme = codfilme;
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

	public String getTempo() {
		return tempo;
	}

	public void setTempo(String tempo) {
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

	public int getCodfuncionario() {
		return codfuncionario;
	}

	public void setCodfuncionario(int codfuncionario) {
		this.codfuncionario = codfuncionario;
	}
	
	
}
