package models;

public class Funcionario extends Pessoa{	
	
	public Funcionario() {
	}
	
	
	@Override
	public String toString() {
		return  "\nCódigo: " + getCodigo() +
				"\nNome: " + getNome() + 
				"\nSexo: " + getSexo() +
				"\nIdade: " + getIdade() +
				"\nCPF: " + getCpf();
		}

}
