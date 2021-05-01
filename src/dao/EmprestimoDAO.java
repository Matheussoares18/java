package dao;

import java.util.ArrayList;
import java.util.Date;

import models.Emprestimo;
import models.Livro;

public class EmprestimoDAO {

    private static ArrayList<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
    


    public static Boolean cadastrarEmprestimo(Emprestimo emprestimo) {

        try {
            emprestimos.add(emprestimo);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    public static ArrayList<Emprestimo> listarEmprestimos() {
        return emprestimos;
    }

    public static int pegarCodUltEmprestimo() {
        int maiorId = 0;
        if (emprestimos.size() > 0) {
            for (Emprestimo emprestimo : emprestimos) {
                if (emprestimo.getCodEmprestimo() > maiorId) {
                    maiorId = emprestimo.getCodEmprestimo();
                }
                return maiorId;
            }
        }
        return 0;

    }

  

    public static Integer devolverLivro(int codEmprestimo) {

        for (Emprestimo emprestimo : emprestimos) {
           
            Date today = new Date();
            if (emprestimo.getCodEmprestimo() == codEmprestimo) {
               
                try {
                    if(today.compareTo(emprestimo.getDateDevolucao()) <=0){
                        for (Livro livro : emprestimo.getLivro()) {
                            livro.setEmprestado(false);
                        }
                        Boolean remove = emprestimos.remove(emprestimo);
                        System.out.println(remove);
                        
                        return 1;
                    }else{
                        return 2;
                    }
                } catch (Exception e) {
                    //TODO: handle exception
                    return 3;
                }

            }

        }
        return null;
    }
    public static Integer pagarMulta(int codEmprestimo) {

        for (Emprestimo emprestimo : emprestimos) {
           if(codEmprestimo == emprestimo.getCodEmprestimo()){
               Date today = new Date();
               emprestimo.setDateDevolucao(today);
               return 1;
          
           }

        }
        return null;
    }

}
