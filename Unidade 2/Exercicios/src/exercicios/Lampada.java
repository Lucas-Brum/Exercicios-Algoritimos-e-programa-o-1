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
public class Lampada {
    boolean ligada = false;
    
    public void ligar(){
        ligada = true;
    }
    public void desligar(){
        ligada = false;
    }
    public String observar(){
        if(ligada){
            return"Ligada";
        }
        else{
            return "Desligada";
        }
    }
}
