package models;

import java.util.ArrayList;
import java.util.Date;

public class Emprestimo {
	
    private int codEmprestimo;
	private ArrayList<Livro> livro;
	private Funcionario funcionario;
	private Cliente cliente;
	private Date dateEmprestimo;
	private Date dateDevolucao;

	
	public ArrayList<Livro> getLivro() {
        return livro;
    }
	public Integer getCodEmprestimo() {
        return codEmprestimo;
    }
    public void setCodEmprestimo(int codEmprestimo) {
        this.codEmprestimo = codEmprestimo;
    }

    public void setLivro(ArrayList<Livro> livros) {
        this.livro = livros;
    }


    public Funcionario getFuncionario() {
        return funcionario;
    }


    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }


    public Cliente getCliente() {
        return cliente;
    }


    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    public Date getDateEmprestimo() {
        return dateEmprestimo;
    }


    public void setDateEmprestimo(Date dateEmprestimo) {
        this.dateEmprestimo = dateEmprestimo;
    }


    public Date getDateDevolucao() {
        return dateDevolucao;
    }


    public void setDateDevolucao(Date dateDevolucao) {
        this.dateDevolucao = dateDevolucao;
    }


    public Emprestimo() {
		
	}
	
	

}
