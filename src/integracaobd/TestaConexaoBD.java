/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integracaobd;

/**
 *
 * @author Jefer
 */
public class TestaConexaoBD {
    public static void main(String[] args) {
    ConexaoBD bd = new ConexaoBD(); 
    bd.getConnection(); 
    bd.close(); 
    }
}
