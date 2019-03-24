package cadastro;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import financeiro.CalculoPreco;
import financeiro.Cotacao;
import vacinacao.CartaoVacinacao;

public class Bovino extends Animal {
	
	private Cotacao cotacaoBovina;
	
	public Bovino(double peso, String raca, Genero genero, Date dataNascimento, Cotacao cotacaoBovina, CartaoVacinacao cv) {
		super(peso, raca, genero, dataNascimento);
		this.preco = setPreco();
		this.cotacaoBovina = cotacaoBovina;
	}
	
	private double setPreco() {
		return new CalculoPreco(this, cotacaoBovina).valorVenda();
	}

}
