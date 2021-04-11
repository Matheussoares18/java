package views;

import dao.LivroDAO;
import models.Livro;
import utils.Console;

public class MenuCliente {

	public static void renderizar() {

		int opcao;
		do {
			System.out.println("\n ---------- MENU CLIENTE ---------- \n");
			System.out.println("1 - Acervo");
			System.out.println("2 - Emprestar Livro");
			System.out.println("3 - Buscar um Livro");
			System.out.println("0 - Voltar para menu principal");
			opcao = Console.readInt("\nDigite uma opção: ");

			switch (opcao) {
			case 1:
				Acervo.renderizar();
				break;
			case 2:
				EmprestarLivro.renderizar();
				break;
			case 3:
				String buscar = Console.readString("Buscar livro por título: ");
				for (Livro livroCadastrado : LivroDAO.retornarLivros()) {
					if (buscar.equals(livroCadastrado.getTitulo())) {
						System.out.println("\nLivro encontrado! ");
						System.out.println(livroCadastrado);
					} else {
						System.out.println("\nLivro não encontrado! ");
					}
				}
	
				break;
			case 0:
				System.out.println("\nRetornando ao menu principal");
				break;
			default:
				System.out.println("\n -- OPÇÃO INVÁLIDA ! -- \n");
				break;
			}
			
		} while (opcao != 0);

	}

}
