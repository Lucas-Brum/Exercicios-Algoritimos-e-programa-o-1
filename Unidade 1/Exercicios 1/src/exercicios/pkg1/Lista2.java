/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicios.pkg1;
import static exercicios.pkg1.Lista1.teclado;
import java.util.Scanner;

/**
 *
 * @author lucas
 */
public class Lista2 {
    static Scanner teclado = new Scanner (System.in);
    public static void main(String[] args) 
    {
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Escolha uma opçao: ");
        System.out.println("1 - Numeros de -100 até 100 sem os multiplos de 3 e 5:");
        System.out.println("2 - Conta a quantidade de letras em uma palavra e inverte elá:");
        System.out.println("3 - Verifica se a palavra é um palindrono: (Fiz mas não entendi haha)");
        System.out.println("4 - Verifica se o numero é primo: ");
        System.out.println("5 - Repeti até escrever o o: ");
        System.out.println("6 - Verifica a media de 10 numeros");
        System.out.println("7 - Verifica o mes do ano correpondente ao numero:");
        System.out.println("8 - Soma pares 1/30 e pares 1/20");
        System.out.println("9 - Não imprime os j iguais aos i");
        System.out.print("Digite a opção selecionada: ");
        int opcao = teclado.nextInt();
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        if (opcao==1)
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
        else if (opcao==5)
        {
            exercicio05();
        }
        else if (opcao==6)
        {
            exercicio06();
        }
        else if (opcao==7)
        {
            exercicio07();
        }
        else if (opcao==8)
        {
            exercicio08();
        }
        else if (opcao==9)
        {
            exercicio09();
        }
        else
        {
            System.out.println("Opção Invalida");
        }
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
    
    
    }

    private static void exercicio01() {
        for ( int i = -100; i <= 100; i++)
        {   
            if((i % 5)== 0 || 0 == (i % 3))
            {
            
            }
            else
            {
                System.out.print(i+" ");
            }
        }
        System.out.println("\n");
    }

    private static void exercicio02() {
        System.out.print("Digite uma palavra: ");
        String nome = teclado.next();
        char[] letras = null;
        letras = nome.toCharArray();
        int len = nome.length();
        System.out.println("A palavra tem: "+ len + " Letras");
        System.out.print("A palavra ao contrario fica: ");
        for (int i = (len - 1) ; i >= 0; i--)
        {
            System.out.print(letras[i]);
        }

        System.out.print("\n");
    }

    private static void exercicio03() {
        System.out.print("Digite algo e eu verifica se é um palindrono:");
        String nome = teclado.next();
        int len = nome.length();
        String invertida = new StringBuilder(nome).reverse().toString();
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        if (nome == null ? invertida == null : nome.equals(invertida))
        {
            System.out.println("As palavras são palindrono");
        }
        else
        {
            System.out.println("As palavras não são palindrono");
        }
    }

    private static void exercicio04() {
        System.out.print("Digite um numero inteiro positivo e eu falo se é primo ou n: ");
        double numero = teclado.nextDouble();
        for(double i=2; i < numero; i++)
        {   
            
            if ((numero % i) == 0)
            {
                System.out.println("Numero não é primo!");
                break;
            }
            else if ((numero == 1) || (numero == 0))
            {
                System.out.println("Numero primo");
            }
            else
            {
                System.out.println("Numero primo!");
                break;
            }
        }
    }

    private static void exercicio05() {
        double numero = 1;
        while(numero != 0)
        {   
            System.out.print("Digite O numero 0: ");
            numero = teclado.nextDouble();
            if (numero != 0)
            {
                 System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                System.out.println("Falei p digitar 0!");
            }
             System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        }
    }

    private static void exercicio06() {
        System.out.println("Calculadora de media: ");
        int numero =0;
        int soma = 0;
        for(int i = 1; i <=10; i++)
        {
            
            System.out.print("Digite o "+ i +"º valor: ");
            numero = teclado.nextInt();
            soma = soma + numero;
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        }
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        int media = (soma/10);
        System.out.println("A media é: "+ media);
        
    }

    private static void exercicio07() {
        String[] listaDeMeses = {"Zero",
                                 "Janeiro",
                                 "Fevereiro",
                                 "março",
                                 "Abril",
                                 "Maio",
                                 "Junho",
                                 "Julho",
                                 "Agosto",
                                 "Setembro",
                                 "Outubro",
                                 "Novembro",
                                 "Dezenbro"};
        for(int i=0;i<9999; i++)
        {
            if(i<13)
            {
                System.out.println(listaDeMeses[i]);
            }
            else
            {
                System.out.println("mes invalido!");
            }
        }
    }

    private static void exercicio08() {
        double soma = 0;
        double multi = 1;
        for(double i = 1; i <= 30; i++)
        {
            if ((i % 2) == 0)
            {
                soma = soma + i;
            }
            else
            {
                if(i<=20)
                {
                    multi = multi * i;
                }
            }
        }
        System.out.println("Soma dos valores pares até 30 = " + soma);
        System.out.println("A multiplicação dos valores impares até 20 = "+multi);
    }

    private static void exercicio09() {
        System.out.println("NÃO ENTENDI...");
        for(int i =0; i <=10; i++)
        {
            for(int j = 0; j<=10; j++)
            {
                if(i==j)
                {
                    System.out.println("I = " + i);
                }
                else
                {
                    System.out.println("I = " + i + " ||| J = " + j);
                }
            }
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        }
    }
}
