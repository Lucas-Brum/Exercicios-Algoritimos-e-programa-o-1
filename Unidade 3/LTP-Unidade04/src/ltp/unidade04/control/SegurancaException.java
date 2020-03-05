/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltp.unidade04.control;

/**
 *
 * @author Lucas Brum
 */
public class SegurancaException extends Exception {
    
    private String usuario;
    
    public SegurancaException(String usuario){
        super("O usuario"+ usuario+ " tentou violar a segurança do sistema");
        this.usuario = this.usuario;
    }
    
}
