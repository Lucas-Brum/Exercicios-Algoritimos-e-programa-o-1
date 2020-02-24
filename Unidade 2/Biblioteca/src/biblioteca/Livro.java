/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Biblioteca;
/**
 *
 * @author lucas
 */
public class Livro {
    int codigo;
    String titulo;
    String autor;
    String genero;
    boolean disponivel;
    
    public Livro(){
        
    }
    
    public Livro(int codigo, String titulo,String autor, String genero, boolean disponivel ){
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.disponivel = disponivel;
    }
}
