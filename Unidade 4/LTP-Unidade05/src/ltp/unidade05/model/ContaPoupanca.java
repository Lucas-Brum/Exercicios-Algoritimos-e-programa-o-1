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
public class ContaPoupanca extends Conta {
    
    private final double JURO_MENSAL =  1.006;
    private final double SALDO_INICIAL = 50;
    public ContaPoupanca(){
        super();
        this.saldo = SALDO_INICIAL;
    }
    
    public ContaPoupanca(String titular, int numero, String senha) throws BancoException{
        super(titular, numero, senha);
        this.saldo = SALDO_INICIAL;
    }
   
    
    public double verificarRendimentos() throws BancoException{
        if(this.saldo<=0)
                throw new BancoException(this.getNumero(), "não há saldo em conta para obter rendimentos da´poupança.");
        return this.saldo * this.JURO_MENSAL;
    }
    
}
