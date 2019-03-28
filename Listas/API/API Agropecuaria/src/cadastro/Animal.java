package cadastro;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import financeiro.CalculoPreco;
import financeiro.Cotacao;
import pesagem.ConversorPeso;

public abstract class Animal {
	public static final AtomicInteger count = new AtomicInteger(0);
	protected final int ID;
	protected ConversorPeso peso;
	protected Genero genero;
	protected Date dataNascimento;
	protected double preco;
	protected Cotacao cotacao;
	
	
	public Animal(ConversorPeso peso, Genero genero, String dataNascimento, Cotacao cotacao) {
		this.ID = count.incrementAndGet();
		this.peso = peso;
		this.genero = genero;
		this.dataNascimento = setDataNascimento(dataNascimento);	
		this.cotacao = cotacao;
		this.preco = setPreco();
	}
	
	public int getID() {
		return ID;
	}

	public Genero getGenero() {
		return genero;
	}
	
	public ConversorPeso getPeso() {
		return peso;
	}
	
	private double setPreco() {
		return new CalculoPreco(this, cotacao).valorVenda();
	}
	
	public double getPreco() {
		return preco;
	}
	
	private Date setDataNascimento(String data) {
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-mm-dd");
		try {
			return formato.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
