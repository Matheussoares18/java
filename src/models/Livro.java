package models;

public class Livro {
	
	private int codLivro;
	private String titulo;
	private String editora;
	private String autor;
	private String assunto;
	private String idioma;
	private boolean emprestado;
	

	public int getCodlivro() {
		return codLivro;
	}
	public void setCodlivro(int codLivro) {
		this.codLivro = codLivro;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	public boolean getEmprestado() {
		return emprestado;
	}
	public void setEmprestado(boolean emprestado) {
		this.emprestado = emprestado;
	}

	
	@Override
	public String toString() {
		return "Código do livro: " + getCodlivro() +
				"\nTítulo: " + getTitulo() + 
				"\nEditora: " + getEditora() +
				"\nAutor: " + getAutor() +
				"\nAssunto " + getAssunto() +
				"\nIdioma " + getIdioma() +
				"\nOcupado? " + getEmprestado();
	}

}