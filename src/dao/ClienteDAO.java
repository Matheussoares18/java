package dao;

import java.util.ArrayList;
import java.util.Date;

import models.Cliente;
import models.Emprestimo;

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

	public static Boolean verificarPendencias(int codCliente){
		Date today = new Date();
		for (Emprestimo emprestimo : EmprestimoDAO.listarEmprestimos()) {
			if(emprestimo.getCliente().getCodigo() == codCliente && emprestimo.getDateDevolucao().compareTo(today) < 0){
				return true;

			}
		}
		return false;
	}

}
