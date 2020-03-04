/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltp.unidade04.view;

import ltp.unidade04.control.Biblioteca;
import ltp.unidade04.model.Livro;
import java.util.Scanner;
import ltp.unidade04.control.Segurança;
import ltp.unidade04.model.Midia;
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
        biblioteca.cadastrarLivro("O Monge e o Executivo", "James Hunter", 2, 100, "Sextante");
        biblioteca.cadastrarLivro("Java para Iniciantes", "Luiz Duarte", 3, 120, "Amazon");
        biblioteca.cadastrarLivro("Querido John","Nicolas Sparks", 1, 200, "Roco");
        
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
        System.out.println("===Biblioteca 2.0===");
        
        while(true){
            exibirMenu();
        }
    }

    private static void exibirMenu() {
        System.out.println("1 - Pesquisar\n"
                            + "2 - Emprestar\n"
                            + "3 - Devolver");
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
            case 5: editarLivro(); break;
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
        System.out.println("Digite o numero de paginas:");
        int paginas = teclado.nextInt();
        teclado.nextLine();
        System.out.println("Digite o nome da editora:");
        String editora = teclado.nextLine();
        
        boolean sucesso = biblioteca.cadastrarLivro(titulo, autor, genero, paginas, editora);
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
            System.out.println("Digite o titulo da midia:");
            String titulo = teclado.nextLine();
            Midia[] midias = biblioteca.pesquisar(titulo);
            System.out.println("-=-=-=-=-=-=-=-=-=-=-");
            if(midias == null){
                System.out.println("Nenhum midia encontrada com este titulo");
            }
            else{
                System.out.println("Midias encontradas:");
                for (int i = 0; i < midias.length; i++) {
                    if(midias[i] != null)
                    System.out.println(midias[i].getCodigo()+ " - "+ midias[i].getTitulo()+ " - "+ midias[i].getDisponivel());
                }
            }
        }
        else if(opcao == 2){
            System.out.println("Digite o codigo da midia:");
            int codigo = teclado.nextInt();
            teclado.nextLine();
            System.out.println("-=-=-=-=-=-=-=-=-=-=-");
            Midia midia = biblioteca.pesquisar(codigo);
            if(midia == null){
                System.out.println("Codigo invalido!");  
            }
            else{
                System.out.println(midia.getCodigo()+ " - "+ midia.getTitulo()+ " - "+ midia.getDisponivel());

            }
                
        }
        else{
            System.out.println("Opção invalida!");
        }
        System.out.println("-=-=-=-=-=-=-=-=-=-=-");
    }
    
    private static void emprestar() {
        System.out.println("======emprestar=======");
        System.out.print("Digite o codigo da midia:");
        int codigo = teclado.nextInt();
        teclado.nextLine();
        boolean sucesso = biblioteca.emprestar(codigo);
        if(sucesso){
            System.out.println("Midia emprestada com sucesso!");
        }
        else{
            System.out.println("Não foi possivel enprestar a midia!");
        }
    }
    
    private static void devolver() {
        System.out.println("======devolver==========");
        System.out.print("Digite o codigo da midia:");
        int codigo = teclado.nextInt();
        teclado.nextLine();
        boolean sucesso = biblioteca.devolver(codigo);
        if(sucesso){
            System.out.println("Midia devolvido com sucesso!");
        }
        else{
            System.out.println("Não foi possivel devolver a midia!");
        }
    }

    private static void editarLivro() {
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
        
        System.out.println("Digite o novo numero de paginas (ou digite 0)");
        int novaPaginas = teclado.nextInt();
        teclado.nextLine();
        System.out.println("Digite o novo nome da editora (ou deixe em branco)");
        String novaEditora = teclado.nextLine();
        Boolean sucesso = biblioteca.editarLivro(codigo, novoTitulo, novoAutor, novoGenero, novaPaginas, novaEditora);
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
        Boolean sucesso = biblioteca.excluir(codigo);
            if(sucesso){
                System.out.println("Exclução realizada com sucesso!");
            }
            else{
                System.out.println("Midia não encontrado!");
        }
    }
    
}
