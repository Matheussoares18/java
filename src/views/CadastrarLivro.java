package views;
import dao.LivroDAO;
import models.Livro;
import utils.Console;

public class CadastrarLivro {
	
	private static Livro l = new Livro();
	
	public static void renderizar() {
		
		l = new Livro();
		
		System.out.println("\n -- CADASTRAR LIVRO --\n");
		
		l.setCodlivro(Console.readInt("Código: "));
		l.setTitulo(Console.readString("Título: "));
		l.setEditora(Console.readString("Editora: "));
		l.setAutor(Console.readString("Autor: "));
		l.setAssunto(Console.readString("Assunto: "));
		l.setIdioma(Console.readString("Idioma: "));
		l.setEmprestado(false);
		
		if(LivroDAO.cadastrarLivro(l)) {
			System.out.println("\n -- LIVRO CADASTRADO -- \n");
		}else {
			System.out.println("\n -- LIVRO JA EXISTE -- \n");
		}
		
		
		
	}

}
