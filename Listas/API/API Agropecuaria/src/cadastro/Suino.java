package cadastro;

import financeiro.CotacaoSuino;
import pesagem.ConversorPeso;

public class Suino extends Animal{
	private RacaSuina raca;

	public Suino(ConversorPeso peso, Genero genero, String dataNascimento, RacaSuina raca, CotacaoSuino cotacao) {
		super(peso, genero, dataNascimento, cotacao);
		this.raca = raca;
	}

	public RacaSuina getRaca() {
		return raca;
	}


}
