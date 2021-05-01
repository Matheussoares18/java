package views;




import java.util.Date;

import dao.EmprestimoDAO;
import models.Emprestimo;
import models.Livro;
import utils.Console;

public class DevolucaoLivrosEmprestimo {

    public static void renderizar(Emprestimo emprestimo) {
        int opcao;
        do {
            Date today = new Date();
            System.out.println("Emprestimo n: " + emprestimo.getCodEmprestimo() + " ----------- \n");
            if(today.compareTo(emprestimo.getDateDevolucao()) > 0){
                int diasEmAtraso = today.getDay() - emprestimo.getDateDevolucao().getDay();
                System.out.println("Em atraso, multa de: " + 0.25 * diasEmAtraso);
            }
           
           
            for (Livro livro : emprestimo.getLivro()) {
            System.out.println(livro.getCodlivro() + " - " + livro.getTitulo() + " " + emprestimo.getDateDevolucao());
            }
            opcao = Console.readInt("Digite 1 para devolver os livros emprestados, digite 0 para sair: ");
            
            switch (opcao) {
                case 0:
                
                    
                    break;
            
                default:
                   int result =  EmprestimoDAO.devolverLivro(emprestimo.getCodEmprestimo());

                    if(result == 1){
                        System.out.println("\n Devolução efetuada com sucesso");
                        opcao = 0;
                    }else if(result == 2){
                       
                        System.out.println("\n Devolução com atraso, caso deseje efetuar o pagamento da multa digite 1 ");
                        int escolha = Console.readInt();
                        if(escolha == 1){
                            Integer resultMulta = EmprestimoDAO.pagarMulta(emprestimo.getCodEmprestimo());
                            if(resultMulta == 1){
                                if(EmprestimoDAO.devolverLivro(emprestimo.getCodEmprestimo()) == 1){
                                    System.out.println("\n Pagamento e devolução efetuados com sucesso!");
                                    MenuFuncionario.renderizar();
                                }
                               
                            }else{
                                System.out.println("\n Falha ao efetuar o pagamento");

                            }
                        }
                        
                    }
                    break;
            }
            

        
            
        } while (opcao != 0 );

        
    }

}
