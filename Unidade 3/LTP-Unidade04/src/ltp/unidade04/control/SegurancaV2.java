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
public class SegurancaV2 implements PadraoSeguranca{

    @Override
    public String autenticar(String usuario, String senha) {
        return "";    
    }

    @Override
    public boolean autorizar(String usuario, int opcao) {
        return true; 
    }
    
}
