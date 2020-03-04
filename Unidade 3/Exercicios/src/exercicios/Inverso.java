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
public class Inverso {
    String palavra;
    public Inverso(String palavra){
        this.palavra = palavra;
    }
    
    public void inverter(){
        String palavraInvertida = "";
        for (int i = palavra.length()-1; i >=0; i--) {
            palavraInvertida += palavra.charAt(i);
        }
        System.out.println(palavraInvertida);
    }
}
