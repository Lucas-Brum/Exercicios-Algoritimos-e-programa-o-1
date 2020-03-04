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
public class Livro extends Midia {
    
    private int paginas;
    private String editora;
    
    public Livro(){
        
    }
    
    public Livro(int codigo, String titulo, String autor, String genero, boolean disponivel, int paginas, String editor){
        super(codigo, titulo, autor, genero, disponivel);
        this.paginas = paginas;
        this.editora = editora;
    }
    public void setPaginas(int paginas){
        this.paginas = paginas;
    }
    public void setEditora(String editora){
        this.editora = editora;
    }
}
