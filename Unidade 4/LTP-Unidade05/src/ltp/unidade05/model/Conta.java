/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltp.unidade05.model;

import java.util.Date;
import java.util.regex.Pattern;

/**
 *
 * @author Lucas Brum
 */
public abstract class Conta {
    
    private String titular;
    private int numero;
    protected double saldo;
    private String senha;
    
    private int diaUltimoSaque;
    private double[] saquesHoje;
    private final double LIMITE_SAQUE = 500;
    private final int MAX_SAQUES = 100;
    
    public Conta(){
        this.saquesHoje = new double[MAX_SAQUES];
        this.saldo = 0;
    }
    public Conta(String titular, int numero, String senha) throws BancoException{
        this();
        this.titular = titular;
        this.numero = numero;
        this.senha = senha;
    }
    public  double getSaldo(){
        return this.saldo;
    }
    
    public boolean autenticar(String senha){
        return this.senha.equals(senha);
    }
    
    public void setSenha(String senha) throws BancoException{
        if(senha.length() > 6)
            throw new BancoException(this.numero, "A senha deve ter no maximo 6 numeros.");
        
        Pattern padrao = Pattern.compile("^[0-9{6}$");
        if(padrao.matcher(senha).matches())
            this.senha = senha;
        else
           throw new BancoException(this.numero, "A senha deve ter somente 6 digitos numeros.");
    }
    
    public String getTitular(){
        return this.titular = titular;
    }
    public void setTitular(String titular){
        this.titular = titular;
    }
    public int getNumero(){
        return this.numero = numero;
    }
    public void setNumero(int numero){
        this.numero = numero;
    }
    public boolean depositar(double valor) throws BancoException{
        if(valor<=0) throw new BancoException(this.numero,"O valor para depositar é invalido.");
        
        this.saldo += valor;
        return true;
    }
    
    protected boolean verificarLimiteSaque(double valor) throws BancoException{
        if (valor > this.LIMITE_SAQUE)
            throw new BancoException(this.numero,"Limite de saque diario Excedido!");
        if (this.diaUltimoSaque != new Date().getDay()){
            this.saquesHoje = new double[MAX_SAQUES];
            this.saquesHoje[0] = valor;
            this.diaUltimoSaque = new Date().getDay();
            return true;
        }
        else{
            double total = valor;
            for (int i = 0; i < this.saquesHoje.length; i++) {
                total += saquesHoje[i];
                
            }
            if(total > this.LIMITE_SAQUE)
                throw new BancoException(this.numero, "Limite de saque diario Excedido!");
            
            for (int i = 0; i < this.saquesHoje.length; i++) {
                if(this.saquesHoje[i]==0){
                    this.saquesHoje[i] = valor;
                    return true;
                }   
            }
            throw new BancoException(this.numero,"Numero maximos de saque diario Excedido!");
        }
    }
    
    public boolean verificarSaldoSaque(double valor) throws BancoException{
        if (valor > this.saldo)
            throw new BancoException(this.numero,"Não´há saldo suficiante para concluir a operação.");          
        return true;
    }
    
    
    public boolean sacar (double valor) throws BancoException {
        if(!verificarSaldoSaque(valor) || !verificarLimiteSaque(valor)){
            throw new BancoException(this.numero,"Não foi possivel realizar este saque por regras do banco.");
        }
        this.saldo -= valor;
        return true;
    }
    public boolean transferir(Conta conta, double valor) throws BancoException{
        boolean sucesso = this.sacar(valor);
        if (sucesso)
            return conta .depositar(valor);
        return false;
    }
}

