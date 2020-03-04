/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicios;

import java.util.Scanner;

/**
 *
 * @author Lucas Brum
 */
public class Principal {
    static Scanner teclado = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("1 - Impressora");
        System.out.println("2 - Intervalo");
        System.out.println("3 - Inverso");
        System.out.println("4 - Calculadora");
        System.out.println("5 - Lampada");
        System.out.println("6 - Radio");
        System.out.println("7 - Quadrado");
        System.out.println("8 - Sair");
        
        int opcao = teclado.nextInt();
        teclado.nextLine();
        
        switch(opcao){
            case 1: testarImpressora();
                break;
            case 2: testarIntervalo();
                break;
            case 3: testarInverso();
                break;
            case 4: testarCalculadora();
                break;
            case 5: ligarLampada();
                break;
             case 6: testarRadio();
                break;
             case 7: testarQuadrado();
                break;
            default: return;
        }
    }

    private static void testarImpressora() {
        System.out.println("Digite uma mensagem");
        String mensagem = teclado.nextLine();
        
        Impressora hp = new Impressora(mensagem);
        
        hp.imprimir();
    }

    private static void testarIntervalo() {
        System.out.println("Digite o primero numero:");
        int num1 = teclado.nextInt();
        teclado.nextLine();
        
        System.out.println("Digite o segundo numero");
        int num2 = teclado.nextInt();
        teclado.nextLine();
        
        Intervalo intervalo = new Intervalo(num1, num2);
        intervalo.imprimir();
    }

    private static void testarInverso() {
        System.out.println("Digite uma palavra:");
        String palavra = teclado.nextLine();
        Inverso inverso = new Inverso(palavra);
        inverso.inverter();
    }

    private static void testarCalculadora() {
        System.out.println("Digite o numero 1");
        int num1 = teclado.nextInt();
        teclado.nextLine();
        
        System.out.println("Digite o numero 2");
        int num2 = teclado.nextInt();
        teclado.nextLine();
        
        Calculadora calc = new Calculadora(num1, num2);
        System.out.println(calc.somar());
        System.out.println(calc.subtrair());
        System.out.println(calc.multiplicar());
        System.out.println(calc.dividir());
        
    }

    private static void ligarLampada() {
     Lampada lampada = new Lampada();
     lampada.ligar();
     System.out.println(lampada.observar());
     lampada.desligar();
     System.out.println(lampada.observar());
    }

    private static void testarRadio() {
        System.out.println("Digite o volume que deseja:");
        int volume = teclado.nextInt();
        teclado.nextLine();
        
        Radio radio = new Radio(volume);
        radio.exibirVolume();
        
    }

    private static void testarQuadrado() {
        System.out.println("Digite o comprimento do lado: ");
        double lado = teclado.nextInt();
        teclado.nextLine();
        Quadrado quadrado = new Quadrado(lado);
        System.out.println("Area: " + quadrado.calcularArea());
        System.out.println("Perimetro: "+ quadrado.calcularPerimetro());
    }
    
    
}
