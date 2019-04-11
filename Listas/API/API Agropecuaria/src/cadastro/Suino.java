package cadastro;

import financeiro.Cotacao;
import financeiro.CotacaoSuino;
import pesagem.ConversorPeso;

/**
 * @author natalia
 * Cadastro de animais suinos
 * @see Animal
 */
public class Suino extends Animal{
	private RacaSuina raca;

	public Suino(ConversorPeso peso, Genero genero, int ano, int mes, int dia, Cotacao cotacao, RacaSuina raca) {
		super(peso, genero, ano, mes, dia, cotacao);
		this.raca = raca;
	}

	/**
	 * @return raça do animal dentre a lista de raças suínas
	 */
	public RacaSuina getRaca() {
		return raca;
	}


}
