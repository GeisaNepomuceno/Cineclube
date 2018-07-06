/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author
 */
public class Sessao {
        private int codigo; 
	private String animacao; 
	private String duracao; 
	private String data; 
	private String idFuncionario; 
	private String idFilme;
        
    public Sessao(int codigo, String animacao, String duracao, String data, String idFuncionario, String idFilme) {
        this.codigo = codigo;
        this.animacao = animacao;
        this.duracao = duracao;
        this.data = data;
        this.idFuncionario = idFuncionario;
        this.idFilme = idFilme;
    }
    
    public Sessao(){  
    }

    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getAnimacao() {
        return animacao;
    }

    public void setAnimacao(String animacao) {
        this.animacao = animacao;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(String idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(String idFilme) {
        this.idFilme = idFilme;
    }
	
        
        
}
