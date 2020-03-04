/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltp.unidade04.control;

import ltp.unidade04.model.Livro;
import ltp.unidade04.model.Midia;

/**
 *
 * @author Lucas Brum
 */
public class Biblioteca {
    
    Midia[] midias;
    int proximoCodigo = 1;
    
    public Biblioteca(int capacidade){
       midias = new Midia[capacidade];
    }
    private String normalizarPesquisa(String texto){
        
       
        return texto.toLowerCase().replaceAll("áàâã", "a")
                                  .replaceAll("éê", "e")
                                  .replace("í", "i")
                                  .replaceAll("óôõ", "o")
                                  .replace("ú", "u")
                                  .replaceAll("[^\\w]", " ");
    }
    public Midia[] pesquisar(String titulo){
        if(titulo == null || titulo.equals("")){
            return midias;
        }
        Livro[] aux = new Livro[midias.length];
        titulo = normalizarPesquisa(titulo);
        for (int i = 0; i < midias.length; i++) {
            if(midias[i] != null && normalizarPesquisa(midias[i].getTitulo()).toLowerCase().contains(titulo) ){
                aux[i]=(Livro) midias[i];
            }
        }
        return aux;
    }
    public Midia pesquisar(int codigo){
        for (int i = 0; i < midias.length; i++) {
            if(midias[i] != null && midias[i].getCodigo() == codigo){
                return (Livro) midias[i];
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
    public boolean cadastrarLivro(String titulo, String autor, int genero, int paginas, String editora){
        Livro livro = new Livro(proximoCodigo, titulo, autor,converterGenero(genero) , true, paginas, editora);
        
        for (int i = 0; i < midias.length; i++) {
            
            if(midias[i]==null){
                
                midias[i] = livro;
                proximoCodigo++;
                return true;
            }
        }
        return false;
    }
    public boolean emprestar(int codigo){
        Midia midia = pesquisar(codigo);
        if(midia == null)
            return false;
        if(midia.getDisponivel() == false)
            return false;
        else{
            midia.setDisponivel(false);
            return true;
        }
    }
    public boolean devolver(int codigo){
        Midia midia = pesquisar(codigo);
        if(midia == null)
            return false;
        
        if(midia.getDisponivel() == true)
            return false;
        
        else{
            midia.setDisponivel(true);
            return true;
        }
    }
    public boolean editarLivro(int codigo, String novoTitulo, String novoAutor, int novoGenero, int novaPaginas, String novaEditora){
        Livro livro = (Livro)pesquisar(codigo);
        if(livro == null){
            return false;
        }
        if(novoTitulo != null && !novoTitulo.equals("")){
            livro.setTitulo(novoTitulo);
        }
        if(novoAutor != null && !novoAutor.equals("")){
            livro.setAutor(novoAutor);
        }
        if(novoGenero != 0){
            livro.setGenero(converterGenero(novoGenero));
        }
        if(novaPaginas != 0){
            livro.setPaginas(novaPaginas);
        }
        if(novaEditora != null && !novaEditora.equals("")){
            livro.setEditora(novaEditora);
        }
        return true;
    }
    public boolean excluir(int codigo){
        for(int i = 0; i < midias.length; i++){
            if(midias[i] != null && midias[i].getCodigo() == codigo){
                midias[i] = null;
                return true;
            }
        }
        return false;
    }
}
