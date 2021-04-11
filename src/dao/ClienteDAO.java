package dao;

import java.util.ArrayList;

import models.Cliente;

public class ClienteDAO {

	
	private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();


	public static Cliente buscarClientePorCpf(String cpf) {
		for (Cliente clienteCadastrado : clientes) {
			if (clienteCadastrado.getCpf().equals(cpf)) {
				return clienteCadastrado;
			}
		}
		return null;
	}
	
	
	public static Boolean cadastrarCliente(Cliente c) {
		if (buscarClientePorCpf(c.getCpf()) == null) {
			clientes.add(c);
			return true;
		}
		return false;
	}

	public static ArrayList<Cliente> retonarClientes() {
		return clientes;
	}

}
