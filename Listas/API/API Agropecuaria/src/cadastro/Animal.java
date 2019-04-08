package cadastro;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.Months;

import financeiro.CalculoPreco;
import financeiro.Cotacao;
import pesagem.ConversorPeso;
import vacinacao.CartaoVacinacao;
import vacinacao.ItemCartaoVacinacao;

public abstract class Animal {
	public static final AtomicInteger count = new AtomicInteger(0);
	protected final int ID;
	protected ConversorPeso peso;
	protected Genero genero;
	protected LocalDate dataNascimento;
	protected double preco;
	protected Cotacao cotacao;
	protected ArrayList<ItemCartaoVacinacao> cartaoVacinacao;
	
	public Animal(ConversorPeso peso, Genero genero, int ano, int mes, int dia , Cotacao cotacao) {
		this.ID = count.incrementAndGet();
		this.peso = peso;
		this.genero = genero;
		this.dataNascimento = new LocalDate(ano, mes, dia);	
		this.cotacao = cotacao;
		this.preco = setPreco();
		this.cartaoVacinacao = new CartaoVacinacao(this).getPlanoVacinacao();
		
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

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public static AtomicInteger getCount() {
		return count;
	}

	public Cotacao getCotacao() {
		return cotacao;
	}

	public ArrayList<ItemCartaoVacinacao> getCartaoVacinacao() {
		return cartaoVacinacao;
	}

	public int getIdade() {
		LocalDate agora = new LocalDate().now(DateTimeZone.UTC);
		return Months.monthsBetween(agora, dataNascimento).getMonths();
	}
	
	

	
}
