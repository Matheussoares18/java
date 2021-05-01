package views;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import dao.ClienteDAO;
import dao.EmprestimoDAO;
import dao.FuncionarioDAO;
import dao.LivroDAO;
import models.Cliente;
import models.Emprestimo;
import models.Funcionario;
import models.Livro;
import utils.Console;


public class EmprestarLivro {
	private static Emprestimo e = new Emprestimo();
	private static ArrayList<Livro> livrosParaEmprestar = new ArrayList<Livro>();
	public static void renderizar() {
		e = new Emprestimo();
		int id = EmprestimoDAO.pegarCodUltEmprestimo();
		if(id != 0){

			e.setCodEmprestimo(id + 1);
		}else{
			e.setCodEmprestimo(1);
		}

		for (Cliente clienteCadastrado : ClienteDAO.retonarClientes()) {
			System.out.println(clienteCadastrado.getCodigo() + "-" + clienteCadastrado.getCpf() + "-"
					+ clienteCadastrado.getNome());

			int codCli = Console.readInt("Digite o código do Cliente: ");

			if (codCli == clienteCadastrado.getCodigo() && !ClienteDAO.verificarPendencias(codCli)) {
				e.setCliente(clienteCadastrado);
				ArrayList<Funcionario> funcionarios;

				funcionarios = FuncionarioDAO.retornarFuncionarios();
				
				for (Funcionario funcionarioCadastrado : funcionarios) {
					System.out.println(funcionarioCadastrado.getCodigo() + " - " + funcionarioCadastrado.getNome());
				}
				int codFunc = Console.readInt("Digite o código do funcionario");
				Funcionario selectedFuncionario = null;
				for (Funcionario funcionario : funcionarios) {
					if(funcionario.getCodigo() == codFunc){
						selectedFuncionario = funcionario;
					}
				}
				
				if(selectedFuncionario != null){
					e.setFuncionario(selectedFuncionario);
					for (Livro livroCadastrado : LivroDAO.retornarLivros()) {
						System.out.println(livroCadastrado.getCodlivro() + " - " + livroCadastrado.getTitulo());
					}
	
					Integer emprestar;
				
					
					do {
						
						emprestar = Console
								.readInt("Digite o c�digo do livro que deseja emprestar, para concluir digite 0: ");
						for (Livro livroCadastrado : LivroDAO.retornarLivros()) {
							if (emprestar == livroCadastrado.getCodlivro() && !livroCadastrado.getEmprestado()) {
								
								
								livrosParaEmprestar.add(livroCadastrado);
								e.setLivro(livrosParaEmprestar);

									livroCadastrado.setEmprestado(true);
									LocalDate today = LocalDate.now();
									LocalDate tomorrow = today.minusDays(1);
									String formattedDate = today
											.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
									
									String DD = tomorrow.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
									System.out.println("A devolucao devera ser realizada ate: \n" + DD);
									Date devolucao = new Date(DD);
									Date emprestimo = new Date(formattedDate);
									e.setDateEmprestimo(emprestimo);
									e.setDateDevolucao(devolucao);
									
							} 
						}
					} while (emprestar != 0);
					if(EmprestimoDAO.cadastrarEmprestimo(e)){
						System.out.println("Emprestimo realizado com sucesso!!");
					}else{
						System.out.println("Falha ao realizar o emprestimo, favor tentar novamente!");
					}

				}

			}else{
				System.out.println("Cliente não encontrado ou com pendencias");
			}
		}
	}

}