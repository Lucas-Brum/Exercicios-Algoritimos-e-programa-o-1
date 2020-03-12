/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltp.unidade05.model;

/**
 *
 * @author Lucas Brum
 */
public class Agencia {
    private int numero;
    private Conta[]contas;
    private static int proximaConta = 1;
    
    private final int TIPO_CONTA_CORRENTE = 1;
    private final int TIPO_CONTA_POUPANCA = 2;
    
    public Agencia(int numero){
        this.numero = numero;
        this.contas = new Conta[100];
    }
    public int getNumero(){
        return this.numero;
    }
    
    public Conta buscarConta(int numeroConta) throws BancoException{
        for(int i = 0; i < contas.length; i++){
            if(contas[i] != null && contas[i].getNumero() == numeroConta){
                return contas[i];
            }
        }
        throw new BancoException(numeroConta, "Conta invalida");
    }
    
    public boolean depositar(int numeroConta, double valor) throws BancoException{
        Conta conta = buscarConta(numeroConta);
        return conta.depositar(valor);
    }
    public boolean transferir(int contaOrigem,Conta contaDestino , double valor) throws BancoException {
        Conta conta = buscarConta(contaOrigem);
        return conta.transferir(contaDestino, valor);
    }
    
    public boolean sacar(int numeroConta, double valor) throws BancoException{
        Conta conta = buscarConta(numeroConta);
        return conta.sacar(valor);
    }
    
    public Conta autenticarCliente(int numeroConta, String senha){

        
        try{
            Conta conta = buscarConta(numeroConta);
            boolean sucesso = conta.autenticar(senha);
            if (sucesso)
                return conta;
            else
                return null;
        }
        catch(BancoException bex){
            return null;
        }

    }
    
    public boolean  cadastrarConta(int tipo,String titular, String senha) throws BancoException{
        for (int i = 0; i < contas.length; i++) {
           if(contas[i] == null){
               if (tipo == TIPO_CONTA_CORRENTE)
                   contas[i] = new ContaCorrente(titular, proximaConta, senha);
               else if(tipo == TIPO_CONTA_POUPANCA)
                   contas[i] = new ContaPoupanca(titular, proximaConta, senha);
               else
                     throw new BancoException(proximaConta, "Tipo de conta invalida");
                   
                   proximaConta++;
                   return true;   
           }   
        }
        return false;
    }
}
