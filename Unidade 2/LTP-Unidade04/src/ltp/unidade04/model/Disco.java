/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltp.unidade04.model;

/**
 *
 * @author Lucas Brum
 */
public class Disco extends Midia{
    
    private int duracao;
    private String formato;
    
    public Disco(){
        
    }
    public Disco(int codigo, String titulo, String autor, String genero, boolean disponivel, int duracao, String formato){
        super(codigo, titulo, autor, genero, disponivel);
        this.duracao = duracao;
        this.formato = formato;
    }
    
}
