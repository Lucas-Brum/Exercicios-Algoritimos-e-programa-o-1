/*
 Uma biblioteca deseja cadastrar em um sistema os seus livros disponiveis. Como
não vemos banco de dados nesta disciplina, o cadastro será todo feito em 
memória, em um array do tipo Livro. Como ainda não vimos interface gráfica, o 
sistema será feito em modo console.

O sistema inicialmente vai pedir usuário e senha, se o usuário acertar 
(admin/admin) ele deixa entrar, caso contrário dá uma mensagem de erro e 
solicita digitar novamente.

O sistema deve ter uma tela inicial com as opções de 1 - buscar livro, 2 - 
cadastrar livro, 3 - emprestar, 4 - devolver e 5 - sair do sistema, e 
quaisquer outras funções que acharem relevante.

Desenvolva uma classe para armazenar os dados dos livros, uma classe para 
a biblioteca em si e todos os métodos de manipulação dos livros.

Os gêneros possíveis para os livros são somente: Ação, Romance, Ficção, 
História e Técnico.

A busca deverá ser realizada por título. Caso o livro esteja cadastrado os 
dados deverão aparecer na tela e informar se o livro está ou não emprestado.

O empréstimo e a devolução exigem a inserção do código do livro e somente p
odem ser emprestados os livros que estiverem disponíveis na biblioteca.
 */
package biblioteca;

import java.util.Scanner;

/**
 *
 * @author lucas
 */
public class Principal {
    static Scanner teclado = new Scanner(System.in);
    static Biblioteca biblioteca;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("-=-=-=-=Sistema de Biblioteca:-=-=-=-=-=-");
        biblioteca = new Biblioteca(100);
            while(true){
                exibirMenu();
        }
    }

    private static void exibirMenu() {
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Pesquisar");
        System.out.println("2 - Emprestar");
        System.out.println("3 - Devolver");
        System.out.println("4 - Cadastrar");
        System.out.println("5 - Sair");
        int opcao = teclado.nextInt();
        switch (opcao) {
            case 1:
                pesquisar();
                break;
            case 2:
                emprestar();
                break;
            case 3:
                devolver();
                break;
            case 4:
                cadastrar();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("Opção Invalida");
                break;
        }
    }
    
    private static void cadastrar() {
        System.out.println("cadastrar");
    }
    private static void pesquisar() {
        System.out.println("Pesquisar");
    }
    private static void emprestar() {
        System.out.println("Emprestar");
    }
    private static void devolver() {
        System.out.println("Devolver");
    }

}
