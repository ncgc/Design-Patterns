package cadastro;

import financeiro.Cotacao;
import financeiro.CotacaoSuino;
import pesagem.ConversorPeso;

public class Suino extends Animal{
	private RacaSuina raca;

	public Suino(ConversorPeso peso, Genero genero, int ano, int mes, int dia, Cotacao cotacao, RacaSuina raca) {
		super(peso, genero, ano, mes, dia, cotacao);
		this.raca = raca;
	}

	public RacaSuina getRaca() {
		return raca;
	}


}
