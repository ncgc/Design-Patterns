package cadastro;

import financeiro.Cotacao;
import financeiro.CotacaoBovino;
import pesagem.ConversorPeso;

public class Bovino extends Animal {
	private RacaBovina raca;
	
	public Bovino(ConversorPeso peso, Genero genero, int ano, int mes, int dia, Cotacao cotacao, RacaBovina raca) {
		super(peso, genero, ano, mes, dia, cotacao);
		this.raca = raca;
	}

	public RacaBovina getRaca() {
		return raca;
	}
	
}
