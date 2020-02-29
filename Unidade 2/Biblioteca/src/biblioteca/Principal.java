/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;
import java.util.Scanner;
/**
 *
 * @author Lucas Brum
 */
public class Principal {
        static Biblioteca biblioteca;
        static Scanner teclado = new Scanner(System.in);
        static String usuarioAutenticado = null;
        static Segurança seguranca = new Segurança();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        biblioteca = new Biblioteca(100);
        biblioteca.cadastrarLivro("O Monge e o Executivo", "James Hunter", 2);
        biblioteca.cadastrarLivro("Java para Iniciantes", "Luiz Duarte", 3);
        biblioteca.cadastrarLivro("Querido John","Nicolas Sparks", 1);
        
        //camada de segurança
        System.out.println("Usuario:");
        String usuario = teclado.nextLine();
        
        System.out.println("Senha:");
        String senha = teclado.nextLine();
            
        usuarioAutenticado = seguranca.autenticar(usuario, senha);
        if(usuarioAutenticado == null){
            System.out.println("Usuario/senha invalida");
            return;
        }
        System.out.println("===Biblioteca 1.0===");
        
        while(true){
            exibirMenu();
        }
    }

    private static void exibirMenu() {
        System.out.println("1 - Pesquisar\n"
                            + "2 - Emprestar\n"
                            + "3- Devolver");
        if(usuarioAutenticado.equals("admin")){
            System.out.println( "4 - Cadastrar\n"
                                + "5 - Editar\n"
                                + "6 - Excluir\n"
                                + "7 - Sair\n");
        }
        int opcao = teclado.nextInt();
        teclado.nextLine();
        if(seguranca.autorizar(usuarioAutenticado, opcao) == false){
            System.out.println("Essse usuario não possui permissão para isso");
            return;
        }
        switch(opcao){
            case 1: pesquisar(); break;
            case 2: emprestar(); break;
            case 3: devolver(); break;
            case 4: cadastrar(); break;
            case 5: editar(); break;
            case 6: Excluir(); break;
            case 7: System.exit(0); break;
            default: System.out.println("Opção invalida");
        }    
            
    }
    
    private static void cadastrar() {
        System.out.println("=====Cadastrar=====");
        System.out.println("Digite o titulo:");
        String titulo = teclado.nextLine();
        System.out.println("Digite o nome do autor:");
        String autor = teclado.nextLine();
        System.out.println("Escolha um genero:");
        System.out.println("1 - Romance");
        System.out.println("2 - Aventura");
        System.out.println("3 - Não-Ficação");
        int genero = teclado.nextInt();
        teclado.nextLine();
        boolean sucesso = biblioteca.cadastrarLivro(titulo, autor, genero);
        if(sucesso){
            System.out.println("cadastrado com sucesso");
        }
        else
        {
            System.out.println("Estoque cheio");
        }
    }
    
    private static void pesquisar() {
        System.out.println("======pesquisar======");
        System.out.println("Escolha uma opção de pesquisa:");
        System.out.println("1 - Por titulo");
        System.out.println("2 - Por código");
        int opcao = teclado.nextInt();
        teclado.nextLine();
        System.out.println("-=-=-=-=-=-=-=-=-=-=-");
        if(opcao == 1){
            System.out.println("Digite o titulo do livro:");
            String titulo = teclado.nextLine();
            Livro[] livros = biblioteca.pesquisar(titulo);
            System.out.println("-=-=-=-=-=-=-=-=-=-=-");
            if(livros == null){
                System.out.println("Nenhum livro encontrado com este titulo");
            }
            else{
                System.out.println("Livros encontrados:");
                for (int i = 0; i < livros.length; i++) {
                    if(livros[i] != null)
                    System.out.println(livros[i].codigo+ " - "+ livros[i].titulo+ " - "+ livros[i].disponivel);
                }
            }
        }
        else if(opcao == 2){
            System.out.println("Digite o codigo do livro:");
            int codigo = teclado.nextInt();
            teclado.nextLine();
            System.out.println("-=-=-=-=-=-=-=-=-=-=-");
            Livro livro = biblioteca.pesquisar(codigo);
            if(livro == null){
                System.out.println("Codigo invalido!");  
            }
            else{
                System.out.println(livro.codigo+ " - "+ livro.titulo+ " - "+ livro.disponivel);

            }
                
        }
        else{
            System.out.println("Opção invalida!");
        }
        System.out.println("-=-=-=-=-=-=-=-=-=-=-");
    }
    
    private static void emprestar() {
        System.out.println("======emprestar=======");
        System.out.print("Digite o codigo do livro:");
        int codigo = teclado.nextInt();
        teclado.nextLine();
        boolean sucesso = biblioteca.emprestarLivro(codigo);
        if(sucesso){
            System.out.println("Livro emprestado com sucesso!");
        }
        else{
            System.out.println("Não foi possivel entregar o livro!");
        }
    }
    
    private static void devolver() {
        System.out.println("======devolver==========");
        System.out.print("Digite o codigo do livro:");
        int codigo = teclado.nextInt();
        teclado.nextLine();
        boolean sucesso = biblioteca.devolverLivro(codigo);
        if(sucesso){
            System.out.println("Livro devolvido com sucesso!");
        }
        else{
            System.out.println("Não foi possivel devolver o livro!");
        }
    }

    private static void editar() {
        System.out.println("====Editar====");
        System.out.println("Digite o código do livro:");
        int codigo = teclado.nextInt();
        teclado.nextLine();
        
        System.out.println("Digite o novo titulo (ou deixe em branco):");
        String novoTitulo = teclado.nextLine();
        System.out.println("Digite o novo Autor (ou deixe em branco):");
        String novoAutor = teclado.nextLine();
        System.out.println("Digite o Codigo do novo genero (ou Digite 0)");
        System.out.println("1 - Romance");
        System.out.println("2 - Aventura");
        System.out.println("3 - Não-Ficação");
        int novoGenero = teclado.nextInt();
        teclado.nextLine();
        
        Boolean sucesso = biblioteca.editarLivro(codigo, novoTitulo, novoAutor, novoGenero);
            if(sucesso){
                System.out.println("Edição realizada com sucesso!");
            }
            else{
                System.out.println("Livro não encontrado!");
        }
    }

    private static void Excluir() {
        System.out.println("====Excluir====");
        System.out.println("Digite o codigo do livro:");
        int codigo = teclado.nextInt();
        teclado.nextLine();
        Boolean sucesso = biblioteca.excluirLivro(codigo);
            if(sucesso){
                System.out.println("Exclução realizada com sucesso!");
            }
            else{
                System.out.println("Livro não encontrado!");
        }
    }
    
}
