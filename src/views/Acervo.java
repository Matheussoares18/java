package views;
import dao.LivroDAO;
import models.Livro;

public class Acervo {
	
	public static void renderizar() {
		System.out.println("\n -- ACERVO -- \n");
		
		
			for(Livro livroCadastrado : LivroDAO.retornarLivros()) {
					System.out.println("----------------------");
					System.out.println(livroCadastrado);
				  
			}
		
			
	}	

}
