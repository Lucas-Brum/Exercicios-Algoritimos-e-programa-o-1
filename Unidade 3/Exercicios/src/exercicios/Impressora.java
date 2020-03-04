/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicios;

/**
 *
 * @author Lucas Brum
 */
public class Impressora {
    
    String mensagem;
    
    public Impressora(String mensagem){
        
        this.mensagem = mensagem;
        
    }
    public void imprimir(){
        System.out.println(mensagem);
    }
}
