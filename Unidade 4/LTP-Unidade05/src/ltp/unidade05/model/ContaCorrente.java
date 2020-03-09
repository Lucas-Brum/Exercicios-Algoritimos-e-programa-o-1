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
public class ContaCorrente extends Conta {
    
    private final double LIMITE_ESPECIAL = 500;
    
    public ContaCorrente(String titular, int numero, String senha) throws BancoException{
        super(titular, numero, senha);
    }
    
    @Override
    public boolean verificarSaldoSaque(double valor) throws BancoException{
        if (valor > this.saldo)
            throw new BancoException(this.getNumero(),"Não´há saldo suficiante para concluir a operação.");          
        return true;
    }
    
}
