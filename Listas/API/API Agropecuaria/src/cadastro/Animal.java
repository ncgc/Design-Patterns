package cadastro;

import java.util.Date;

public abstract class Animal {

	protected double peso;
	protected String raca;
	protected Genero genero;
	protected Date dataNascimento;
	protected double preco;
	
	public Animal(double peso, String raca, Genero genero, Date dataNascimento) {
		super();
		this.peso = peso;
		this.raca = raca;
		this.genero = genero;
		this.dataNascimento = dataNascimento;
	}
	
}
