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
public class SegurancaV1  implements PadraoSeguranca {
    
    //admin/admin = Usuario administrador
    //useer/user = Usuario comum
    @Override
    public String autenticar(String usuario, String senha) throws SegurancaException{
        if (usuario.equals("admin") && senha.equals("admin")){
            return "admin";
        }
        else if (usuario.equals("user") && senha.equals("user")){
            return "user";
        }
        else{
            throw new SegurancaException(usuario);
        }
    }
    @Override
    public boolean autorizar(String usuario, int opcao){
        switch(opcao){
            case 1:
            case 2:
            case 3:
            case 7: return true;
            case 4:
            case 5:
            case 6:if(usuario.equals("admin")) return true;
            default: return false;
        }
    }
}
