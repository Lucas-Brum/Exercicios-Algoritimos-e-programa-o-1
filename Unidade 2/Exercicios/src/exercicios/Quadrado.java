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
public class Quadrado {
    double lado;
    
    public Quadrado(double lado){
        this.lado = lado;
    }
    public double calcularArea(){
        return Math.pow(lado, 2);
    }
    public double calcularPerimetro(){
        return lado * 4;
    }
}
