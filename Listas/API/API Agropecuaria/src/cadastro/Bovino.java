package cadastro;

import financeiro.CotacaoBovino;
import pesagem.ConversorPeso;

public class Bovino extends Animal {
	private RacaBovina raca;

	public Bovino(ConversorPeso peso, Genero genero, String dataNascimento, RacaBovina raca, CotacaoBovino cotacao) {
		super(peso, genero, dataNascimento, cotacao);
		this.raca = raca;
	}

	public RacaBovina getRaca() {
		return raca;
	}
	

}
