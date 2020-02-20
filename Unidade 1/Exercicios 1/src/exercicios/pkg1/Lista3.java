/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicios.pkg1;

import static exercicios.pkg1.Lista2.teclado;

/**
 *
 * @author lucas
 */
public class Lista3 {
    public static void main(String[] args) 
    {
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Escolha uma opçao: ");
        System.out.println("1 - Caixa eletronico:");
        System.out.println("2 - Digite uma sequencia eu vou inverter ela para vc...");
        System.out.println("3 - procura valor nas sequencias: ");
        System.out.println("4 - ");
        System.out.println("5 - ");
        System.out.println("6 - ");
        System.out.print("Digite a opção selecionada: ");
        int opcao = teclado.nextInt();
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        switch (opcao) {
            case 1:
                exercicio01();
                break;
            case 2:
                exercicio02();
                break;
            case 3:
                exercicio03();
                break;
            case 4:
                exercicio04();
                break;
            case 5:
                exercicio05();
                break;
            case 6:
                exercicio06();
                break;
            default:
                System.out.println("Opção Invalida");
                break;
        }
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-"); 
    }

    private static void exercicio01() {
        System.out.print("Digite quanto desejpa sacar :");
        int sacar = teclado.nextInt();
        int sacado = 0;
        int cedulas = 0;
        for(int i = sacar; i > sacado; i--)
        {
            if (( sacar % 100) == 0)
            {
                sacado = sacado + 100;
                sacar = sacar - 100;
                cedulas++;
            }
            else if ((sacar % 50) == 0)
            {
                sacado = sacado + 50;
                sacar = sacar - 50;
                cedulas++;                
            }
            else if ((sacar % 20) == 0)
            {
                sacado = sacado + 20;
                sacar = sacar - 20;
                cedulas++;
            }
            else if ((sacar % 10) == 0)
            {
                sacado = sacado + 10;
                sacar = sacar - 10;
                cedulas++;                
            }
            else if ((sacar % 5) == 0)
            {
                sacado = sacado + 5;
                sacar = sacar - 5;
                cedulas++;                
            }
            else
            {
                sacado = sacado + 2;
                sacar = sacar - 2;
                cedulas++;
            }
        }
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("O total de cedular é: "+ cedulas);
        System.out.println(sacado);
    }

    private static void exercicio02() {
        int[] x = new int[10];
        int[] y = new int[10];
        int j = -1;
        System.out.println("Digite uma sequencia de 10 numeros:");
        for(int i = 0;i<10; i++)
        {
            System.out.print("Digite o "+ i +"º valor: ");
            x[i] = teclado.nextInt();
        }
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        for(int i = 9; i>=0; i--)
        {   j++;
            y[i]=x[j];      
        }
        for(int i = 0;i<10; i++)
        {
            System.out.println(y[i]);
        }
    }
    

    private static void exercicio03() {
        System.out.println("Digite uma sequencia de 10 numeros:");
        int[] x = new int[10];
        int encontrar;
         for(int i = 0;i<10; i++)
        {
            System.out.print("Digite o "+ i +"º valor: ");
            x[i] = teclado.nextInt();
        }
         System.out.println("Qual o valor quer que eu procure na sequencia anterior?");
        encontrar = teclado.nextInt();
        for(int i = 0;i<10; i++)
        {
            if (x[i]== encontrar)
            {
                System.out.println("Encontrei na "+ i +"º posição um valor igual! ");
            }
        }
    }

    private static void exercicio04() {
        System.out.println("Digite uma sequencia de 10 numeros:");
        int[] x = new int[10];
        int encontrar;
        int achei = 0;
         for(int i = 0;i<10; i++)
        {
            System.out.print("Digite o "+ i +"º valor: ");
            x[i] = teclado.nextInt();
        }
         System.out.println("Qual o valor quer que eu procure na sequencia anterior?");
        encontrar = teclado.nextInt();
        for(int i = 0;i<10; i++)
        {
            if (x[i]== encontrar)
            {
                System.out.println("Achei!!!");
                achei = 1;
                break;
            }
        }
        if (achei == 0)
        {
            System.out.println("Não achei");
        }
    }

    private static void exercicio05() {
        System.out.println("Digite uma sequencia de 10 numeros:");
        int[] x = new int[10];
        int[] controle = new int [10];
        int menor;
        int contador=0;
        for(int i = 0;i<10; i++)
        {
            System.out.print("Digite o "+ i +"º valor: ");
            x[i] = teclado.nextInt();
        }
        System.out.println("Digite o primeiro valor do novo vetor");
        menor = teclado.nextInt();
        for(int i = 0;i<10; i++)
        {   
            if (x[i]>= menor)
            {
                controle[contador] = x[i];
                contador++;
            }
        }
        System.out.println("são "+contador);
        int[] copiador = new int[contador];
        for(int i = 0; i < contador; i++)
        {
            copiador[i] = controle[i];

        }
        for(int i = 0; i < contador; i++)
        {
            System.out.println(copiador[i]);
        }
    }

    private static void exercicio06() {
        System.out.print("Digite o temanho do vetor: ");
        int tamanho = teclado.nextInt();
        int[] vetor = new int[tamanho];
         for(int i = 0;i<tamanho; i++)
        {
            System.out.print("Digite o "+ i +"º valor: ");
            vetor[i] = teclado.nextInt();
        }
        
    }
    
}
