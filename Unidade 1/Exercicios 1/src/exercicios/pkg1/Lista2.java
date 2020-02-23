/*
1) Faça um programa em Java que mostre para o usuário todos os números entre 
-100 e 100 que não sejam múltiplos de 3 e 5.

 

2) Faça um programa em Java que receba do usuário uma palavra e mostre a 
quantidade de letras naquela palavra e a própria palavra invertida.

 

3) Faça um programa em Java que receba do usuário uma palavra e diga se aquela 
palavra é ou não um palíndromo (pode ser lida igualmente da direita para a 
esquerda e da esquerda para a direita).

 

4) Faça um programa em Java que receba do usuário um número e diga se aquele 
número é ou não primo (números que apenas são divisíveis por um e por eles 
mesmos).

 

5) Altere o programa do exercício anterior para ficar recebendo o número dentro
de um laço enquanto o número for diferente de 0 (zero).

 

6) Crie um programa que peça 10 números inteiros e apresente: a média, o maior e
o menor.

 

7) Implemente um programa que recebe repetidamente um número de 1 a 12, enquanto
esse número for diferente de 0 (zero), e imprime o mês correspondente. Quando o 
número estiver fora do intervalo permitido, a mensagem “mês inválido” deverá ser
exibida.

 

8) Escreva um programa que imprima na tela a soma dos números ímpares entre 1 e 
30 e a multiplicação dos números pares entre 1 e 20.

 

9) Escreva um programa que percorra dois laços de 0 a 10, um interno ao outro, 
imprimindo os contadores, e quando estes forem iguais, o programa deve passar à 
próxima interação do laço mais externo, caso contrário, deve imprimir os valores
dos contadores dos dois laços.


 */
package exercicios.pkg1;
import static exercicios.pkg1.Lista1.teclado;
import java.util.Scanner;
import javax.swing.JOptionPane;
 
/**
 *
 * @author lucas
 */
public class Lista2 {
    static Scanner teclado = new Scanner (System.in);
    public static void main(String[] args) 
    {
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-="
                + "-=-");
        System.out.println("Escolha uma opçao: ");
        System.out.println("1 - Numeros de -100 até 100 sem os multiplos de 3 "
                + "e 5:");
        System.out.println("2 - Conta a quantidade de letras em uma palavra e"
                + " inverte elá:");
        System.out.println("3 - Verifica se a palavra é um palindrono: (Fiz "
                + "mas não entendi haha)");
        System.out.println("4 - Verifica se o numero é primo: ");
        System.out.println("5 - Repeti até escrever o o: ");
        System.out.println("6 - Verifica a media de 10 numeros");
        System.out.println("7 - Verifica o mes do ano correpondente ao "
                + "numero:");
        System.out.println("8 - Soma pares 1/30 e pares 1/20");
        System.out.println("9 - Não imprime os j iguais aos i");
        System.out.print("Digite a opção selecionada: ");
        int opcao = teclado.nextInt();
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-"
                + "=-=-");
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
            case 7:
                exercicio07();
                break;
            case 8:
                exercicio08();
                break;
            case 9:
                exercicio09();
                break;
            default:
                System.out.println("Opção Invalida");
                break;
        }
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-="
                + "-=-");
    
    
    }

    private static void exercicio01() {
        for ( int i = -100; i <= 100; i++)
        {   
            if(0!= (i % 5) && 0 != (i % 3))
            {
                System.out.print(i+" ");
            }
        }
        System.out.println("\n");
    }

    private static void exercicio02() {
        String nome = JOptionPane.showInputDialog("Digite uma palavra: ");
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
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-="
                + "-=-");
        if (nome.equals(invertida))
        {
            System.out.println("As palavras são palindrono");
        }
        else
        {
            System.out.println("As palavras não são palindrono");
        }
    }

    private static void exercicio04() {
        
        String palavra = JOptionPane.showInputDialog("\"Digite um numero "
                + "inteiro positivo e eu falo se é primo ou n: \"");
        int numero = Integer.parseInt(palavra);
        if (numero != 2 && numero % 2 == 0 )
        {
            System.out.println("Este numero não é primo!");
            return;
        }
        int contador = 0;
        for(int i = 1; i<=numero; i++)
        {   
            if(numero % i == 0)
            {
                contador++;
            }
        }
        if(contador>2)
        {
            System.out.println("Esse numero não é primo!");
        }
        else
        {
            System.out.println("Numero primo!");
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
        int[] numero =new int[10];
        int soma = 0;
        int maior = 0;
        int menor = 0;
        for(int i = 0; i <= numero.length - 1; i++)
        {
            
            System.out.print("Digite o "+ i +"º valor: ");
            numero[i] = teclado.nextInt();
            soma = soma + numero[i];
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-"
                    + "=-=-=-=-");
            if( i == 0 || maior <= numero[i])
            {
                maior= numero[i];
            }

            if(i == 0 || menor >= numero[i])
            {
                menor = numero[i];
            }
        }

        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-="
                + "-=-=-");
        int media = (soma/10);
        System.out.println("A media é: "+ media);
        System.out.println("O maior numero digitado: "+ maior);
        System.out.println("O menor numero digitado: "+ menor);
        
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
      while (true)
        {
           int mes = teclado.nextInt();
           if (mes == 0)
           {
               return;
           }
           else if (mes < 13 && mes > 0)
           {
               System.out.println(listaDeMeses[mes]);
           }
           else
           {
               System.out.println("Mes invalido");
           }               
        }
    }

    private static void exercicio08() {
        double soma = 0;
        double multi = 1;
        for(double i = 1; i <= 30; i++)
        {
            if ((i % 2) != 0)
            {
                soma +=  i;
            }
            else
            {
                if(i<=20)
                {
                    multi = multi * i;
                }
            }
        }
        System.out.println("Soma dos valores impares até 30 = " + soma);
        System.out.println("A multiplicação dos valores pares até 20 = "+multi);
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
