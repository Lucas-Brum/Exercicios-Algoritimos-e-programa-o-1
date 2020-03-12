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
    private static int agenciaAutenticada = 0; 
    private static Conta contaAutenticada = null;

    @Override
    public boolean equals(Object o) {
        return super.equals(o); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
   
    public Banco(){
        
        this.agencias = new Agencia[100];
    }
    
    public Agencia buscarAgencia(int agencia) throws BancoException{
        for (int i = 0; i < agencias.length; i++) {
            if(agencias[i] != null && agencias[i].getNumero() == agencia){
                return agencias[i];
            }
        }
        throw new BancoException(0, "Agencia invalida.");
    }
    
    public Conta getContaAutenticada(){
        return contaAutenticada;
    }
    
    public boolean autenticarCliente(int agencia, int numeroConta, String senha){
        
        try{
            Agencia ag = buscarAgencia(agencia);           
            Conta conta =  ag.autenticarCliente(numeroConta, senha);
            if(conta != null){
                agenciaAutenticada = ag.getNumero();
                contaAutenticada = conta;
                return true;
            }
            else
                return false;
        }
        catch(BancoException bex){
            return false;
        }
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
        return ag.cadastrarConta(tipo, titular, senha);
    }

    public boolean depositar( int agencia, int conta, double valor) throws BancoException{
        Agencia ag = buscarAgencia(agencia);
        return ag.depositar(conta, valor);
    }
    public boolean transferirAutenticado(int agenciaDestino, int contaDestino, double valor) throws BancoException{
        return transferir(agenciaAutenticada, contaAutenticada.getNumero(), agenciaDestino, contaDestino, valor);
    }
    
    public boolean transferir(int agenciaOrigem, int contaOrigem, int agenciaDestino, int contaDestino, double valor) throws BancoException{
        Agencia agDestino = buscarAgencia(agenciaDestino);
        Conta conta = agDestino.buscarConta(contaDestino);
        
        Agencia agOrigem = buscarAgencia(agenciaOrigem);
        return agOrigem.transferir(contaOrigem, conta, valor);
    }
    
    public boolean sacar(int agencia, int conta, double valor) throws BancoException{
        Agencia ag = buscarAgencia(agencia);
        return ag.sacar(conta, valor);
    }
    public boolean sacarAutenticado(double valor) throws BancoException{
        return sacar(agenciaAutenticada, contaAutenticada.getNumero(), valor);
    }
}
