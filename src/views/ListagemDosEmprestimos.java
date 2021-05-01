package views;


import java.util.ArrayList;

import models.Emprestimo;
import models.Livro;
import utils.Console;

public class ListagemDosEmprestimos {
    
    public static void renderizar(ArrayList<Emprestimo> emprestimos){
        int opcao;
        do {
            for (Emprestimo emprestimo : emprestimos) {
                System.out.println("\n" + "Emprestimo n: " + emprestimo.getCodEmprestimo());
            }
            opcao = Console.readInt("\nDigite o codigo do emprestimo: ");
            System.out.println("0 - Sair");
            switch (opcao) {
                case 0:
                    DevolucaoLivro.renderizar();
                    break;
            
                default:
                    for (Emprestimo emprestimo : emprestimos) {
                        if(emprestimo.getCodEmprestimo() == opcao){
                            DevolucaoLivrosEmprestimo.renderizar(emprestimo);
                            
                        }
                    }
                    break;
            }
            
            
        } while (opcao != 0);

       /*  for (Emprestimo emprestimo : emprestimos) {
            
        } */
    }
}
