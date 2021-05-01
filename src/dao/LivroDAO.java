package dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import models.Livro;

public class LivroDAO {
	
	private static ArrayList<Livro> livros = new ArrayList<Livro>();
	
	
	public static Livro buscarLivroPorTitulo(String titulo) {
		for(Livro livroCadastrado : livros) {
			if(livroCadastrado.getTitulo().equals(titulo)) {
				return livroCadastrado;
			}
		}
		return null;
	}
	public static Livro buscarLivroPorCodigo(int codLivro) {
		for(Livro livroCadastrado : livros) {
			if(livroCadastrado.getCodlivro() == codLivro) {
				return livroCadastrado;
			}
		}
		return null;
	}
	public static int devolverLivro(int cod) {
		for (Livro livroCadastrado: livros) {
			if(livroCadastrado.getCodlivro() == cod){
				Date today = new Date();
				
				livroCadastrado.setEmprestado(false);
				return 1;
				
			}
		}
		return 0;
	}
	
	public static Boolean cadastrarLivro(Livro l) {
		if(buscarLivroPorTitulo(l.getTitulo()) == null) {
			livros.add(l);

			return true;
		}
		return false;
	}
	
	public static ArrayList<Livro> retornarLivros() {
		return livros;
	}

	public static ArrayList<Livro> retornarEmprestados(){
		ArrayList<Livro> livrosEmprestados = new ArrayList<Livro>();
		for (Livro livroCadastrado : livros) {
			if(livroCadastrado.getEmprestado()){
				livrosEmprestados.add(livroCadastrado);
			}
		}
		return livrosEmprestados;
	}
}
