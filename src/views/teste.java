package views;

import java.util.Date;

import dao.ClienteDAO;
import dao.FuncionarioDAO;
import dao.LivroDAO;
import models.Cliente;
import models.Funcionario;
import models.Livro;


public class teste {
    private static Livro l = new Livro();
    private static Livro l2 = new Livro();
    private static Funcionario f = new Funcionario();
    private static Cliente c = new Cliente();

    public static void renderizar(){
        l = new Livro();
        l2 = new Livro();
		
		
		
		l.setCodlivro(3123);
		l.setTitulo("Seninha");
		l.setEditora("massa dms");
		l.setAutor("vai te toma no cu rapa");
		l.setAssunto("te fuder");
		l.setIdioma("paulada nas costa");
		l.setEmprestado(false);
		
		LivroDAO.cadastrarLivro(l);
		
		l2.setCodlivro(312323);
		l2.setTitulo("awd");
		l2.setEditora("awd");
		l2.setAutor("vai tawdrapa");
		l2.setAssunto("te fuder");
		l2.setIdioma("pawda");
		l2.setEmprestado(false);
		
		LivroDAO.cadastrarLivro(l2);

        c = new Cliente();

        c.setCodigo(2123);
        c.setEndereco("alçwdjlawd");
        c.setCpf("04695988917");
        

        Date nascimento = new Date("22/11/2001");

      
        c.setDataDeNasc(nascimento);
        c.setNome("nome");
        c.setTelefone("41995331771");

        ClienteDAO.cadastrarCliente(c);

        f = new Funcionario();

        f.setCodigo(181298);
        f.setCpf("04695988917");
        f.setDataDeNasc(nascimento);
        f.setNome("o jorgin me empresta a doze");
        f.setSexo("outros");

        FuncionarioDAO.cadastrarFuncionario(f);

        System.out.println("\n -- FOII CARALHO --\n");
		
    }
}
