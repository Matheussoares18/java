package views;
import java.util.ArrayList;

import dao.ClienteDAO;
import dao.EmprestimoDAO;
import dao.LivroDAO;
import models.Cliente;
import models.Emprestimo;
import models.Livro;
import utils.Console;

public class DevolucaoLivro {
	private static ArrayList<Emprestimo> emprestimosDoCliente = new ArrayList<Emprestimo>();
	public static void renderizar() {
		int opcao;
		do {
			System.out.println("\n ----------- Menu de devolu��o -----------\n ");
			/* for(Livro livroCadastrado : LivroDAO.retornarEmprestados()) {
					System.out.println("----------------------");
					System.out.println(livroCadastrado);
			} */
			for (Cliente cliente : ClienteDAO.retonarClientes()) {
				System.out.println(cliente.getCodigo() + " - " + cliente.getNome());
			}
			opcao = Console.readInt("\nDigite o codigo do cliente: ");
			System.out.println("0 - Sair");			
			switch (opcao) {
			case 0:	
				MenuFuncionario.renderizar();
				break;
			default:
				/* int result;
				
				result = LivroDAO.devolverLivro(opcao);
				
				if(result == 1) {
					System.out.println("\n -- Livro devolvido com sucesso --\n ");
				}else if(result == 2) {
					System.out.println("ha uma multa, por favor fa�a o pagamento");
				} */
				ArrayList<Emprestimo> result = EmprestimoDAO.listarEmprestimos();
				for (Emprestimo emprestimo : result) {
					if(opcao == emprestimo.getCliente().getCodigo()){
						emprestimosDoCliente.add(emprestimo);
					}
				}
				
				if(emprestimosDoCliente.size() > 0){
					ListagemDosEmprestimos.renderizar(result);
					emprestimosDoCliente.clear();
				}else{
					System.out.println("Não foram encontrados emprestimos para o cliente digitado" );
					
				}
				break;
			}
			
		} while (opcao != 0);
		
	}	
}
