/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questaodissertativa;

/**
 *
 * @author Lucas Brum
 */
public class Principal {
static Aluno aluno;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String nome = "Lucas Matheus Rodrigues Brum";
        long ra = 1234;
        Aluno a1 = new Aluno(nome, ra);
        System.out.println(a1.nomeAluno);
        System.out.println(a1.raAluno);
    }
    
}
