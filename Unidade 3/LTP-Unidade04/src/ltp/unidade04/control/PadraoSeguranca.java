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
public interface PadraoSeguranca {
    String autenticar(String usuario, String senha)throws SegurancaException;
    boolean autorizar(String usuario, int opcao);
}
