package cadastro;

import financeiro.Cotacao;
import financeiro.CotacaoBovino;
import pesagem.ConversorPeso;

/**
 * @author natalia
 * Cadastro de animais bovinos
 * @see Animal
 */
public class Bovino extends Animal {
	private RacaBovina raca;
	
	
	public Bovino(ConversorPeso peso, Genero genero, int ano, int mes, int dia, Cotacao cotacao, RacaBovina raca) {
		super(peso, genero, ano, mes, dia, cotacao);
		this.raca = raca;
	}

	/**
	 * @return raça do animal dentre a lista de raças bovinas
	 */
	public RacaBovina getRaca() {
		return raca;
	}
	
}
