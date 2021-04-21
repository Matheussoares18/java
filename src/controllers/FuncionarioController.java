package controllers;

import dao.FuncionarioDAO;
import models.Funcionario;
import utils.Validacao;

public class FuncionarioController {

	// Cadastrar e listar Funcionário
	// Verificar CPF aqui
	
	public static int cadastrar(Funcionario f) {
		if (Validacao.validarCpf(f.getCpf())) {
			if (FuncionarioDAO.cadastrarFuncionario(f)) {
				return 1;
			} else {
				return 2;
			}
		}
		return 3;
	}
	
	public static void listar() {
		for(Funcionario funcionarioCadastrado : FuncionarioDAO.retornarFuncionarios()) {
			System.out.println(funcionarioCadastrado);
		}
	}
	
}
