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
public abstract class Midia {
    
    protected int codigo;
    protected String titulo;
    protected String autor;
    protected String genero;
    protected boolean disponivel;
    
    public Midia(){
        
    }
    
    public Midia(int codigo, String titulo, String autor, String genero, boolean disponivel){
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.disponivel = disponivel;
    }
    public String getTitulo(){
        return this.titulo;
    }
    public int getCodigo(){
        return this.codigo;
    }
    public boolean getDisponivel(){
        return this.disponivel;
    }
    public void setDisponivel(boolean disponivel){
        this.disponivel = disponivel;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public void setAutor(String autor){
        this.autor = autor;
    }
     public void setGenero(String genero){
        this.genero = genero;
    }
}
