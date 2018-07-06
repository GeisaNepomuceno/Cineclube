/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author geisa
 */
public class Eleicao {
        private int id; 
        private String descricao; 
        private String id_funcionario; 

    public Eleicao(){
    }

    public Eleicao(int id, String descricao, String id_funcionario) {
        this.id = id;
        this.descricao = descricao;
        this.id_funcionario = id_funcionario;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(String id_funcionario) {
        this.id_funcionario = id_funcionario;
    }
        
        
}
