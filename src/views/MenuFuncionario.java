package views;

import utils.Console;

public class MenuFuncionario {

	public static void renderizar() {

		int opcao;
		do {
			System.out.println("\n ---------- MENU FUNCION�RIO ---------- \n");
			System.out.println("1 - Cadastrar Cliente");
			System.out.println("2 - Listar Clientes");
			System.out.println("3 - Cadastrar Funcion�rio");
			System.out.println("4 - Listar Funcion�rios");
			System.out.println("5 - Cadastrar Livro");
			System.out.println("6 - Devolver um Livro");
			System.out.println("7 - Acervo");
			System.out.println("8 - LETS GO");
			System.out.println("0 - Voltar para menu principal");
			opcao = Console.readInt("\nDigite uma op��o: ");

			switch (opcao) {
				case 1:
					CadastrarCliente.renderizar();
					break;
				case 2:
					ListarClientes.renderizar();
					break;
				case 3:
					CadastrarFuncionario.renderizar();
					break;
				case 4:
					ListarFuncionarios.renderizar();
					break;
				case 5:
					CadastrarLivro.renderizar();
					break;
				case 6:
					DevolucaoLivro.renderizar();
					break;
				case 7:
					CadastrarLivro.renderizar();
					break;
				case 8:
					teste.renderizar();
					break;
			
				case 0:
					System.out.println("\nRetornando ao menu principal");
					break;
				default:
					System.out.println("\n -- OP��O INV�LIDA ! -- \n");
					break;
			}

		} while (opcao != 0);

	}

}
