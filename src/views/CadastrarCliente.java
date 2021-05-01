package views;
import java.util.Date;

import controllers.ClienteController;
//import dao.ClienteDAO;
import models.Cliente;
import utils.Console;
//import utils.Validacao;

public class CadastrarCliente {

	private static Cliente c = new Cliente();

	public static void renderizar() {

		c = new Cliente();

		System.out.println("\n -- CADASTRAR CLIENTE --\n ");

		// Preenchendo o objeto de cliente
		c.setCodigo(Console.readInt("C�digo: "));
		c.setNome(Console.readString("Nome: "));
		c.setSexo(Console.readString("Sexo: "));
		System.out.println("Idade: ");
		String dataDeNasc = Console.readString();
		Date date = new Date(dataDeNasc);
		c.setDataDeNasc(date);
		c.setCpf(Console.readString("CPF: "));
		c.setEndereco(Console.readString("Endere�o: "));
		c.setTelefone(Console.readString("Telefone: "));

		// Cadastrar o objeto de cliente na lista de clientes
		// Verificar CPF aqui
		
//		if (Validacao.validarCpf(c.getCpf())) {
//			if (ClienteDAO.cadastrarCliente(c)) {
//				System.out.println("\nCLIENTE CADASTRADO!!!\n");
//			} else {
//				System.out.println("\nESSE CLIENTE J� EXISTE!!!\n");
//			}
//		}else {
//			System.out.println("\nCPF inv�lido!");
//		}
		
		//ClienteController.cadastrar(c);
		if(ClienteController.cadastrar(c) == 1) {
			System.out.println("\nCLIENTE CADASTRADO!!!\n");
		} else if(ClienteController.cadastrar(c) == 2) {
			System.out.println("\nESSE CLIENTE J� EXISTE!!!\n");
		} else if(ClienteController.cadastrar(c) == 3) {
			System.out.println("\nCPF INV�LIDO!");
		}
		
		

	}

}