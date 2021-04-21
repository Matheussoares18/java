package controllers;

import dao.FuncionarioDAO;
import models.Funcionario;
import utils.Validacao;

public class FuncionarioController {

	// Cadastrar e listar Funcionário
	
	public static void cadastrar(Funcionario f) {
		if (Validacao.validarCpf(f.getCpf())) {
			if (FuncionarioDAO.cadastrarFuncionario(f)) {
				System.out.println("\nFUNCIONÁRIO CADASTRADO!!!\n");
			} else {
				System.out.println("\nESSE FUNCIONÁRIO JÁ EXISTE!!!\n");
			}
		}else {
			System.out.println("\nCPF inválido!");
		}
	}
	
}
