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
public class Revista extends Midia {
    private String materias;
    private String dataLancamento;
    
    public Revista(){
        
    }
    public Revista(int codigo, String titulo, String autor, String genero, boolean disponivel, String dataLancamento, String materias){
        super(codigo, titulo, autor, genero, disponivel);
        this.materias = materias;
        this.dataLancamento = dataLancamento;
    }
    
    public void setMaterias(String materias){
        this.materias = materias;
    }
    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }
    
    @Override
    public String toString(){
        String texto = super.toString();
        return texto+ " - "+ this.dataLancamento;
    }
}
