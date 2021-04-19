package views;
import dao.ClienteDAO;
import dao.LivroDAO;
import models.Cliente;
import models.Livro;
import utils.Console;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;


public class EmprestarLivro {
	
	public static void renderizar() {
		
		for (Cliente clienteCadastrado : ClienteDAO.retonarClientes()) {
			System.out.println(clienteCadastrado.getCodigo() + "-" + clienteCadastrado.getCpf() + "-" + clienteCadastrado.getNome());

			int codCli = Console.readInt("Digite o código do Cliente: ");

			if (codCli == clienteCadastrado.getCodigo()) {
		
		for(Livro livroCadastrado : LivroDAO.retornarLivros()) {
			System.out.println(livroCadastrado.getCodlivro() + " - " + livroCadastrado.getTitulo());
		}
		
		
		int emprestar = Console.readInt("Digite o código do livro que deseja emprestar: ");
		for(Livro livroCadastrado : LivroDAO.retornarLivros()) {
			if(emprestar == livroCadastrado.getCodlivro()) {
				
				if(!livroCadastrado.getEmprestado()) {
					livroCadastrado.setEmprestado(true);
					LocalDate today = LocalDate.now();
					LocalDate tomorrow = today.plusDays(7);
					String formattedDate = today.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));			
					System.out.println("Sucesso! Livro emprestado em: " + formattedDate);
					String DD = tomorrow.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
					System.out.println("A devolucao devera ser realizada ate: /n" + DD);
				} else {
		
					System.out.println("Livro indisponível!");
				}
				
			}else {
				System.out.println("Livro não encontrado!");
				}
			}
		}
	}
}
	
}