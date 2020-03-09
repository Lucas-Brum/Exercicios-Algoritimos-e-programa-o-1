/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltp.unidade05.view;

import ltp.unidade05.control.Banco;
import ltp.unidade05.model.BancoException;

/**
 *
 * @author Lucas Brum
 */
public class Principal {

    protected static Banco banco = new Banco();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws BancoException {

            banco.cadastrarAgencia();
            banco.cadastrarConta(1, 1, "Lucas", "123456");
            banco.cadastrarConta(2, 1, "Fran", "197346");

       
        new FrmLogin().setVisible(true);
        
    }
    
}
