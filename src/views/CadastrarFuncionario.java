package views;

import controllers.FuncionarioController;
//import dao.FuncionarioDAO;
import models.Funcionario;
import utils.Console;
//import utils.Validacao;

public class CadastrarFuncionario {

	private static Funcionario f = new Funcionario();

	public static void renderizar() {

		f = new Funcionario();

		System.out.println("\n -- CADASTRAR FUNCIONÁRIO --\n ");

		f.setCodigo(Console.readInt("Código: "));
		f.setNome(Console.readString("Nome: "));
		f.setSexo(Console.readString("Sexo: "));
		f.setIdade(Console.readInt("Idade: "));
		f.setCpf(Console.readString("CPF: "));
		
		FuncionarioController.cadastrar(f);
		
		if(FuncionarioController.cadastrar(f) == 1) {
			System.out.println("\nFUNCIONÁRIO CADASTRADO!!!\n");
		} else if(FuncionarioController.cadastrar(f) == 2) {
			System.out.println("\nESSE FUNCIONÁRIO JÁ EXISTE!!!\n");
		} else if(FuncionarioController.cadastrar(f) == 3) {
			System.out.println("\nCPF inválido!");
		}

	}

}