package views;
import dao.LivroDAO;
import models.Livro;
import utils.Console;

public class DevolucaoLivro {
	public static void renderizar() {
		int opcao;
		do {
			System.out.println("\n ----------- Menu de devolução -----------\n ");
			for(Livro livroCadastrado : LivroDAO.retornarEmprestados()) {
					System.out.println("----------------------");
					System.out.println(livroCadastrado);
			}
			opcao = Console.readInt("\nDigite o codigo do livro que deseja devolver: ");
			System.out.println("0 - Sair");			
			switch (opcao) {
			case 0:	
				MenuFuncionario.renderizar();
				break;
			default:
				int result;
				
				result = LivroDAO.devolverLivro(opcao);
				
				if(result == 1) {
					System.out.println("\n -- Livro devolvido com sucesso --\n ");
				}else if(result == 2) {
					System.out.println("ha uma multa, por favor faça o pagamento");
				}
				break;
			}
			
		} while (opcao != 0);
		
	}	
}
