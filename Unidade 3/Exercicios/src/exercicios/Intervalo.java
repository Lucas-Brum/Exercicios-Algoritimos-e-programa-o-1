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
public class Intervalo {
    
    int inicio, fim;
    
    public Intervalo(int inicio, int fim){
        
        this.inicio = inicio;
        this.fim = fim;
        
    }
    
    public void imprimir(){
        for (int i = inicio; i <= fim; i++) {
            if(i % 2 != 0){
                System.out.println(i);
            }
        }
    }
}
