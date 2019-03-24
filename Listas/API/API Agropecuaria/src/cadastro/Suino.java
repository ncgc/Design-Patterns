package cadastro;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import financeiro.CalculoPreco;
import financeiro.Cotacao;

public class Suino extends Animal{
	private static final AtomicInteger count = new AtomicInteger(0);
	private final int suinoID;
	private Cotacao cotacaoSuina;
	

	public Suino(double peso, String raca, Genero genero, Date dataNascimento, Cotacao cotacaoSuina) {
		super(peso, raca, genero, dataNascimento);
		suinoID = count.incrementAndGet();
		this.preco = setPreco();
		this.cotacaoSuina = cotacaoSuina;
	}
	
	public int getSuinoID() {
		return suinoID;
	}
	
	public double setPreco() {
		return new CalculoPreco(this, cotacaoSuina).valorVenda();
	}
	
	

}
