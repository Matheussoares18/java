package models;

public class Funcionario extends Pessoa{	
	
	public Funcionario() {
	}
	
	
	@Override
	public String toString() {
		return  "\nC�digo: " + getCodigo() +
				"\nNome: " + getNome() + 
				"\nSexo: " + getSexo() +
				"\nIdade: " + getDataDeNasc() +
				"\nCPF: " + getCpf();
		}

}
