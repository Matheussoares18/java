package controllers;

import dao.ClienteDAO;
import models.Cliente;
import utils.Validacao;

public class ClienteController {

	// Cadastrar e listar cliente 
	
	public static int cadastrar(Cliente c) {
		if (Validacao.validarCpf(c.getCpf())) {
			if (ClienteDAO.cadastrarCliente(c)) {
				return 1;
			} else {
				return 2;
			}
		}
		
		return 3;
	}
	
	public static void listar() {
		//ClienteDAO.retonarClientes();
		for(Cliente clienteCadastrado : ClienteDAO.retonarClientes()) {
			System.out.println(clienteCadastrado);
		}
	}
	
}
