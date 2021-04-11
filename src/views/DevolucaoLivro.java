package views;
import dao.LivroDAO;
import models.Livro;
import utils.Console;

public class DevolucaoLivro {
	public static void renderizar() {
		int opcao;
		do {
			System.out.println("\n ----------- MENU de devolução -----------\n ");
			for(Livro livroCadastrado : LivroDAO.retornarEmprestados()) {
					System.out.println("----------------------");
					System.out.println(livroCadastrado);
			}
			opcao = Console.readInt("\nDigite a opção escolhida: ");
			System.out.println("0 - Sair");			
			switch (opcao) {
			case 0:	
				MenuFuncionario.renderizar();
				break;
			default:
				int result;
				
				result = LivroDAO.devolverLivro(opcao);
				
				if(result == 1) {
					System.out.println("\n -- DEVOLVIDO OTARIO --\n ");
				}else if(result == 2) {
					System.out.println("\n -- TEM QUE PAGAR A MULTA FDP --\n ");
				}
				break;
			}
			
		} while (opcao != 0);
		
	}	
}
