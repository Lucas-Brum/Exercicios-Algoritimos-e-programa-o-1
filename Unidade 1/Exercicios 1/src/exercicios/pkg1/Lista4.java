/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicios.pkg1;

/**
 *
 * @author lucas
 */
public class Lista4 {
    public static void main(String[] args)
    {
        
    }
    public class Pessoa
    {
        String nome ;
        String login;
        String senha;
        
        public Pessoa(String nome,String login, String senha)
        {
        nome = this.nome;
        login = this.login;
        senha = this.senha;
            
        }
        public String get_Nome()
        {
            return nome;
        }
        public void set_Nome(String nome)
        {
            nome = this.nome;
        }
        public String get_Login()
        {
            return login;
        }
        public void set_Login(String login)
        {
            login = this.login;
        }
        public String get_Senha()
        {
            return senha;
        }
        public void set_Senha(String senha)
        {
            senha = this.senha;
        }
    }
    
    
    
}
