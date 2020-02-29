/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

/**
 *
 * @author Lucas Brum
 */
public class Biblioteca {
    
    Livro[] livros;
    int proximoCodigo = 1;
    
    public Biblioteca(int capacidade){
       livros = new Livro[capacidade];
    }
    public Livro[] pesquisar(String titulo){
        if(titulo == null || titulo.equals("")){
            return livros;
        }
        Livro[] aux = new Livro[livros.length];
        titulo = titulo.toLowerCase();
        for (int i = 0; i < livros.length; i++) {
            if(livros[i] != null && livros[i].titulo.toLowerCase().contains(titulo) ){
                aux[i]=livros[i];
            }
        }
        return aux;
    }
    public Livro pesquisar(int codigo){
        for (int i = 0; i < livros.length; i++) {
            if(livros[i] != null && livros[i].codigo == codigo){
                return livros[i];
            }
        }
        return null;
    }
    String converterGenero(int genero){
        switch(genero){
            case 1: return "Romance";
            case 2: return "Aventura";
            case 3: return "Não-Ficação";
            default: return null;
        }
    }
    public boolean cadastrarLivro(String titulo, String autor, int genero){
        Livro livro = new Livro(proximoCodigo, titulo, autor,converterGenero(genero) , true);
        
        for (int i = 0; i < livros.length; i++) {
            
            if(livros[i]==null){
                
                livros[i] = livro;
                proximoCodigo++;
                return true;
            }
        }
        return false;
    }
    public boolean emprestarLivro(int codigo){
        Livro livro = pesquisar(codigo);
        if(livro == null)
            return false;
        if(livro.disponivel == false)
            return false;
        else{
            livro.disponivel = false;
            return true;
        }
    }
    public boolean devolverLivro(int codigo){
        Livro livro = pesquisar(codigo);
        if(livro == null)
            return false;
        
        if(livro.disponivel == true)
            return false;
        
        else{
            livro.disponivel = true;
            return true;
        }
    }
    public boolean editarLivro(int codigo, String novoTitulo, String novoAutor, int novoGenero){
        Livro livro = pesquisar(codigo);
        if(livro ==null){
            return false;
        }
        if(novoTitulo != null && !novoTitulo.equals("")){
            livro.titulo = novoTitulo;
        }
        if(novoAutor != null && !novoAutor.equals("")){
            livro.autor = novoAutor;
        }
        if(novoGenero != 0){
            livro.genero = converterGenero(novoGenero);
        }
        return true;
    }
    public boolean excluirLivro(int codigo){
        for(int i = 0; i < livros.length; i++){
            if(livros[i] != null && livros[i].codigo == codigo){
                livros[i] = null;
                return true;
            }
        }
        return false;
    }
}
