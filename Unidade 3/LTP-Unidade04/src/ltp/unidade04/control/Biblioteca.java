/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltp.unidade04.control;

import ltp.unidade04.model.Disco;
import ltp.unidade04.model.Genero;
import ltp.unidade04.model.Livro;
import ltp.unidade04.model.Midia;
import ltp.unidade04.model.Revista;

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
                                  .replace("ç","c")
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
                return (Midia) midias[i];
            }
        }
        return null;
    }
    
    private boolean cadastrar(Midia midia){
       for (int i = 0; i < midias.length; i++) {
            
            if(midias[i]==null){
                
                midias[i] = midia;
                proximoCodigo++;
                return true;
            }
        }
        return false; 
    }
    
    public boolean cadastrarLivro(String titulo, String autor, int genero, int paginas, String editora){
        Livro livro = new Livro(proximoCodigo, titulo, autor,Genero.getGenero(genero) , true, paginas, editora);
        return cadastrar(livro);  
    }
    public boolean cadastrarRevista(String titulo,String autor, int genero, String materias, String dataLancamento){
        Revista revista = new Revista(proximoCodigo, titulo, autor,Genero.getGenero(genero), true, materias,dataLancamento);
        return cadastrar(revista);
    }
    public boolean cadastrarDisco(String titulo,String autor, int genero, int duracao, String formato ){
        Disco disco = new Disco(proximoCodigo, titulo, autor,Genero.getGenero(genero), true, duracao, formato);
        return cadastrar(disco);
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
    private void editar(Midia midia, String novoTitulo, String novoAutor, int novoGenero){

        if(novoTitulo != null && !novoTitulo.equals("")){
            midia.setTitulo(novoTitulo);
        }
        if(novoAutor != null && !novoAutor.equals("")){
            midia.setAutor(novoAutor);
        }
        if(novoGenero != 0){
            midia.setGenero(Genero.getGenero(novoGenero));
        }
    }
    public boolean editarLivro(int codigo, String novoTitulo, String novoAutor, int novoGenero, int novaPaginas, String novaEditora){
        Livro livro = (Livro)pesquisar(codigo);
        if(livro == null){
            return false;
        }
        if(novaPaginas != 0){
            livro.setPaginas(novaPaginas);
        }
        editar(livro, novoTitulo, novoAutor, novoGenero);
        if(novaEditora != null && !novaEditora.equals("")){
            livro.setEditora(novaEditora);
        }
        return true;
    }
    public boolean editarRevista(int codigo, String novoTitulo, String novoAutor, int novoGenero, String novaMaterias, String novaDataLancamento){
        Revista revista = (Revista)pesquisar(codigo);
        if(revista == null){
            return false;
        }
        editar(revista, novoTitulo, novoAutor, novoGenero);
        if(novaMaterias != null && !novaMaterias.equals("")){
            revista.setMaterias(novaMaterias);
        }
        if(novaDataLancamento != null && !novaDataLancamento.equals("")){
            revista.setDataLancamento(novaDataLancamento);
        }
        return true;
    }
     public boolean editarDisco(int codigo, String novoTitulo, String novoAutor, int novoGenero, int novaDuracao, String novoFormato){
        Disco disco = (Disco)pesquisar(codigo);
        if(disco == null){
            return false;
        }
        editar(disco, novoTitulo, novoAutor, novoGenero);
        if(novaDuracao != 0){
            disco.setDuracao(novaDuracao);
        }
        if(novoFormato != null && !novoFormato.equals("")){
            disco.setFormato(novoFormato);
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
