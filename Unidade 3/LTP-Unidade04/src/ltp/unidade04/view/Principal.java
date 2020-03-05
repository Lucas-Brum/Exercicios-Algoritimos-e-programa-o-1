/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltp.unidade04.view;

import java.util.InputMismatchException;
import ltp.unidade04.control.Biblioteca;
import ltp.unidade04.model.Livro;
import java.util.Scanner;
import ltp.unidade04.control.PadraoSeguranca;
import ltp.unidade04.control.SegurancaException;
import ltp.unidade04.control.SegurancaV1;
import ltp.unidade04.model.Disco;
import ltp.unidade04.model.Genero;
import ltp.unidade04.model.Midia;
import ltp.unidade04.model.Revista;
/**
 *
 * @author Lucas Brum
 */
public class Principal {
        static Biblioteca biblioteca;
        static Scanner teclado = new Scanner(System.in);
        static String usuarioAutenticado = null;
        static PadraoSeguranca seguranca = new SegurancaV1();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        biblioteca = new Biblioteca(100);

        biblioteca.cadastrarLivro("O Monge e o Executivo", "James Hunter", Genero.AVENTURA, 100, "Sextante");
        biblioteca.cadastrarLivro("Java para Iniciantes", "Luiz Duarte", Genero.NAO_FICCAO, 120, "Amazon");
        biblioteca.cadastrarLivro("Querido John","Nicolas Sparks", Genero.ROMANCE, 200, "Roco");
        
        biblioteca.cadastrarRevista("National Geographic", "Varios", Genero.NAO_FICCAO, "Onça-pintada morre no alaska", "05/07/2018");
        
        biblioteca.cadastrarDisco("Videoaulas de Java", "Luiz Duarte", Genero.NAO_FICCAO, 120, "DVD");

        //camada de segurança
        System.out.println("Usuario:");
        String usuario = teclado.nextLine();
        
        System.out.println("Senha:");
        String senha = teclado.nextLine();
        try{    
        usuarioAutenticado = seguranca.autenticar(usuario, senha);
        }
        catch(SegurancaException se){
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
            case 5: editar(); break;
            case 6: Excluir(); break;
            case 7: System.exit(0); break;
            default: System.out.println("Opção invalida");
        }    
            
    }
    
    private static void imprimirGeneros(){
        for (int i = 0; i < Genero.GENEROS.length ; i++) {
            System.out.println(Genero.GENEROS[i]+ " - "+Genero.getGenero(Genero.GENEROS[i]));
        }
    }
    
    private static void cadastrar() {
        System.out.println("=====Cadastrar=====");
        
        System.out.println("Oque você deseja cadastrar?");
        System.out.println("1 - Livro");
        System.out.println("2 - Revista");
        System.out.println("3 - Disco");
        int opcao = teclado.nextInt();
        teclado.nextLine();
        
        
        System.out.println("Digite o titulo:");
        String titulo = teclado.nextLine();
        System.out.println("Digite o nome do autor:");
        String autor = teclado.nextLine();
        System.out.println("Escolha um genero:");
        imprimirGeneros();
        int genero = teclado.nextInt();
        teclado.nextLine();
         boolean sucesso = false;
        if(opcao == 1){
            System.out.println("Digite o numero de paginas:");
            int paginas = teclado.nextInt();
            teclado.nextLine();
            System.out.println("Digite o nome da editora:");
            String editora = teclado.nextLine();
            sucesso = biblioteca.cadastrarLivro(titulo, autor, genero, paginas, editora);
        }
        else if (opcao == 2){
             System.out.println("Digite as materias em destaque:");
            String materias = teclado.nextLine();
            
            System.out.println("Digite a data de lançamento:");
            String dataLancamento = teclado.nextLine();
            sucesso = biblioteca.cadastrarRevista(titulo, autor, genero, materias, dataLancamento);
        }
        else if (opcao == 3) {
            System.out.println("Digite a duração do disco:");
            int duracao = teclado.nextInt();
            teclado.nextLine();
            
            System.out.println("Digite o formato do disco:  (CD,DVD e ETC)");
            String formato = teclado.nextLine();
            sucesso = biblioteca.cadastrarDisco(titulo, autor, genero, duracao, formato);
        }
        else{
            System.out.println("Opção invalida!");
            return;
        }
            
        if(sucesso){
            System.out.println("Midia cadastrada com sucesso");
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
                        System.out.println(midias[i]);
                }
            }
        }
        else if(opcao == 2){
            System.out.println("Digite o codigo da midia:");
            Midia midia = null;
            try{
            int codigo = teclado.nextInt();
            System.out.println("-=-=-=-=-=-=-=-=-=-=-");
            midia = biblioteca.pesquisar(codigo);
            }catch(InputMismatchException inex){
                //do nithing
            }
            teclado.nextLine();
                    if(midia == null){
                System.out.println("Codigo invalido!");  
            }
            else{
                
                System.out.println(midia);

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

    private static void editar() {
        System.out.println("====Editar====");
        System.out.println("Digite o código da midia:");
        int codigo = teclado.nextInt();
        teclado.nextLine();
        
        Midia midia = biblioteca.pesquisar(codigo);
        if (midia == null){
            System.out.println("Codigo invalido!");
            return;
        }
   
        System.out.println("Digite o novo titulo (ou deixe em branco):");
        String novoTitulo = teclado.nextLine();
        
        System.out.println("Digite o novo Autor (ou deixe em branco):");
        String novoAutor = teclado.nextLine();
           
        System.out.println("Digite o Codigo do novo genero (ou Digite 0)");
        System.out.println("0 - MANTER O ATUAL");
        imprimirGeneros();
        int novoGenero = teclado.nextInt();
        teclado.nextLine();
        
        
        Boolean sucesso = false;
        if(midia.getClass() == Livro.class){
            System.out.println("Digite o novo numero de paginas (ou digite 0)");
            int novaPaginas = teclado.nextInt();
            teclado.nextLine();
            System.out.println("Digite o novo nome da editora (ou deixe em branco)");
            String novaEditora = teclado.nextLine();
            sucesso = biblioteca.editarLivro(codigo, novoTitulo, novoAutor, novoGenero, novaPaginas, novaEditora);
        }
        else if(midia.getClass() == Revista.class){
            System.out.println("Digite as novas materias de destaqui ou deixa em branco");
            String novasmaterias = teclado.nextLine();
            
            System.out.println("Digite a nova data de lançamento ou deixe em branco");
            String dataLancamento = teclado.nextLine();
            
            sucesso = biblioteca.editarRevista(codigo, novoTitulo, novoAutor, novoGenero, novasmaterias, dataLancamento);
        }
        else if(midia.getClass() == Disco.class){
            System.out.println("Digite a nova duração ou deixe como 0:");
            int novaDuracao = teclado.nextInt();
            teclado.nextLine();
            
            System.out.println("Digite o novo formato ou deixe em branco");
            String novoFormato = teclado.nextLine();
            
            sucesso = biblioteca.editarDisco(codigo, novoTitulo, novoAutor, novoGenero, novaDuracao, novoFormato);
        }
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
