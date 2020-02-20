/*
1) Crie um programa que peça o nome, a altura e o peso de duas pessoas e 
apresente o nome da mais pesada e o nome da mais alta.
2) Faça um programa em Java que receba do usuário um número e mostre todos os 
números anteriores a ele até o zero.
3) Implemente um programa que recebe um número de 1 a 7 e imprime o dia da
semana correspondente.
4) Faça uma calculadora em Java onde o usuário informa qual operação deseja 
fazer (adição, subtração, multiplicação, divisão, radiciação e potenciação), o 
programa solicita as entradas necessárias e depois imprime o resultado.
 */
package exercicios.pkg1;

import java.util.Scanner;

/**
 *
 * @author lucas
 */
public class Lista1 {
    static Scanner teclado = new Scanner (System.in);
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Escolha uma opçao: ");
        System.out.println("1 - Comparador de peso e altura:");
        System.out.println("2 - Contador Regressivo até 0:");
        System.out.println("3 - Dia da semana:");
        System.out.println("4 - calculadora:");
        System.out.print("Digite a opção selecionada: ");
        int opcao = teclado.nextInt();
        if (opcao == 1)
        {
            exercicio01();
        }
        else if (opcao==2)
        {
            exercicio02();
        }
        else if (opcao==3)
        {
            exercicio03();
        }
        else if (opcao==4)
        {
            exercicio04();
        }
        else
            System.out.println("Opção Invalida");
    }
     private static void exercicio01()
    {
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("APP que verifica peso e altura e detemina \nquem é mais alto e quem é mais baixo");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.print("Digite seu nome: ");
        String nome1 = teclado.next();
        System.out.print("Digite seu peso em Kg: ");
        int peso1 = teclado.nextInt();
        System.out.print("Digite sua altura em cm: ");
        int altura1 = teclado.nextInt();
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Nova pessoa: ");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.print("Digite seu nome: ");
        String nome2 = teclado.next();
        System.out.print("Digite seu peso em Kg: ");
        int peso2 = teclado.nextInt();
        System.out.print("Digite sua altura em cm: ");
        int altura2 = teclado.nextInt();
        if (peso1 > peso2)
        {
            System.out.print(nome1);
            System.out.println(" é mais Pesadx");
        }
        else
        {
            System.out.print(nome2);
            System.out.println(" é mais Pesadx");
        }
        if (altura1 > altura2)
        {
            System.out.print(nome1);
            System.out.println(" é mais Altx");
        }
        else
        {
            System.out.print(nome2);
            System.out.println(" é mais altx");
        }
    }
    private static void exercicio02() {
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Digite um numero inteiro positivo e eu conto até 0:");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        int valor = teclado.nextInt();
        System.out.println("Contando...");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        for (int numero = valor; numero > 0; numero--)
        {
            System.out.print(numero);
            System.out.print(",");
        }
        System.out.println("0!");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
    }
    private static void exercicio03()
    {   
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Digite um numero inteiro de 0 até 7 para saber qual \no dia da semana ele corresponde: ");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        String[] lista  = new String[] {"Invalido","Segunda","Terça","Quarta","Quinta","Sexta","Sabado","Domingo"};
        System.out.println("Digite o valor:");
        int dia = teclado.nextInt(); 
        System.out.println(lista[dia]);
        if (dia <0 || dia >7)
        {
            System.out.println("valor invalido");
        }

    }
    private static void exercicio04()
    {
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.print("Selecione qual operação deseja fazer:\n"
                + "1 - adição:\n"
                + "2 - subtração:\n"
                + "3 - multiplicação:\n"
                + "4 - divisão:\n"
                + "5 - radiciação:\n"
                + "6 - potenciação:\n");
        System.out.print("Digite sua escolha: ");
        int escolha = teclado.nextInt();
        if(escolha == 1)
        {
             System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.print("Adição...\n"
                    + "Escolha o primero valor: ");
            float operador1 = teclado.nextFloat();
            System.out.print("Escolha o valor que quer somar ao anterior: ");
            float operador2 = teclado.nextFloat();
            float resposta = operador1 + operador2;
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println(operador1 + " + " + operador2 + " = " + resposta);
        }
        else if (escolha == 2)
        {
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.print("Subtração...\n"
                    + "Escolha o primero valor: ");
            float operador1 = teclado.nextFloat();
            System.out.print("Escolha o valor que quer subtrair ao anterior: ");
            float operador2 = teclado.nextFloat();
            float resposta = operador1 - operador2;
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println(operador1 + " - " + operador2 + " = " + resposta);
        }
        else if (escolha == 3)
        {
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.print("Multiplicação...\n"
                    + "Escolha o primero valor: ");
            float operador1 = teclado.nextFloat();
            System.out.print("Escolha o valor que quer multiplicar o anterior: ");
            float operador2 = teclado.nextFloat();
            float resposta = operador1 * operador2;
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println(operador1 + " x " + operador2 + " = " + resposta);
        }
        else if (escolha == 4)
        {
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.print("Divisão...\n"
                    + "Escolha o primero valor: ");
            float operador1 = teclado.nextFloat();
            System.out.print("Escolha o valor que quer Dividir o anterior: ");
            float operador2 = teclado.nextFloat();
            float resposta = operador1 / operador2;
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println(operador1 + " / " + operador2 + " = " + resposta);
        }
        else if (escolha == 5)
        {
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.print("Radiciação...\n"
                    + "Escolha o valor: ");
            float operador1 = teclado.nextFloat();
            float resposta = (float) Math.sqrt(operador1);
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println(" A raiz de " + operador1 + " é : " + resposta);
        }
        else if (escolha == 6)
        {
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.print("Potenciação...\n"
                    + "Escolha o valor: ");
            float operador1 = teclado.nextFloat();
            float resposta = (float) Math.pow(operador1, 2);
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println(operador1 + " ao quadrado é : " + resposta);
        }
        else
        {
            System.out.println("OPÇÃO INVALIDA");
        }
         System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
    }                
}
