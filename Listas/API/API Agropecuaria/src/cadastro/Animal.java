package cadastro;

import static cadastro.Animal.count;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import vacinacao.CartaoVacinacao;

public class Animal implements Peso {
	public static final AtomicInteger count = new AtomicInteger(0);
	private final int ID;
	protected double peso;
	protected String raca;
	protected Genero genero;
	protected Date dataNascimento;
	protected double preco;
	
	public Animal(double peso, String raca, Genero genero, Date dataNascimento) {
		this.ID = count.incrementAndGet();
		this.peso = peso;
		this.raca = raca;
		this.genero = genero;
		this.dataNascimento = dataNascimento;	
	}

	@Override
	public double getPeso() {
		return peso;
	}
	
}
