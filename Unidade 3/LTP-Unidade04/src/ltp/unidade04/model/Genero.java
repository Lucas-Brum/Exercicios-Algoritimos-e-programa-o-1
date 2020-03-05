/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltp.unidade04.model;

/**
 *
 * @author Lucas Brum
 */
public abstract class Genero {
    
    public final static int ROMANCE = 1;
    public final static int AVENTURA = 2;
    public final static int NAO_FICCAO = 3;
    public final static int RELIGIAO = 4;
    public final static int ARTES = 5;

    
    public final static int[] GENEROS = { ROMANCE, AVENTURA , NAO_FICCAO, RELIGIAO, ARTES};
    
    public static String getGenero(int genero){
     
        switch(genero){
                case ROMANCE: return "ROMANCE";
                case AVENTURA: return "AVENTURA";
                case NAO_FICCAO: return "NAO_FICCAO";
                case RELIGIAO: return "RELIGIAO";
                case ARTES: return "ARTES";
                default: return null;
            }
    }
 
    public static String[] getGeneros(){
        String[] generos = new String[GENEROS.length];
        for (int i = 0; i < GENEROS.length; i++) {
            generos[i] = getGenero(GENEROS[i]);
        }
        return generos;
    }
}
