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
public class Calculadora {
    
    int v1,v2;
    public Calculadora(int num1,int num2){
        v1 = num1;
        v2 = num2;
    }
    public int somar(){
        return v1 + v2;
    }
    public int subtrair(){
        return v1 - v2;
    }
    public int multiplicar(){
        return v1 * v2;
    }
    public int dividir(){
        return v1 / v2;
    }
}
