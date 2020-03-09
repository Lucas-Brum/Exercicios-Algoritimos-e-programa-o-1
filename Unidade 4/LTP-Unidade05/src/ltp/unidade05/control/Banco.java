/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltp.unidade05.control;

import ltp.unidade05.model.Agencia;
import ltp.unidade05.model.BancoException;
import ltp.unidade05.model.Conta;

/**
 *
 * @author Lucas Brum
 */
public class Banco {
    private static Agencia[] agencias;
    private static int proximaAgencia = 1 ;
   
    public Banco(){
        
        this.agencias = new Agencia[100];
    }
    
    public Agencia buscarAgencia(int agencia){
        for (int i = 0; i < agencias.length; i++) {
            if(agencias[i] != null && agencias[i].getNumero() == agencia){
                return agencias[i];
            }
        }
        return null;
    }
    
    public boolean autenticarCliente(int agencia, int conta, String senha){
        Agencia ag = buscarAgencia(agencia);
                
            if(ag == null) return false;
            
            return ag.autenticarCliente(conta, senha);
    }
    
    public boolean cadastrarAgencia ( ){
        for (int i = 0; i < this.agencias.length; i++) {
            if(this.agencias[i] == null){
             this.agencias[i] = new Agencia(proximaAgencia);
             proximaAgencia++;
             return true;
            }       
        }
        return false;
    }
    
    public boolean cadastrarConta(int tipo, int agencia, String titular, String senha) throws BancoException{
        Agencia ag = buscarAgencia(agencia);
        
        if(ag == null)throw new BancoException(0, "Agencia invalida.");
        
        return ag.cadastrarConta(tipo, titular, senha);
    }

}
