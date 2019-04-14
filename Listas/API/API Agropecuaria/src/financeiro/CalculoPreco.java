package financeiro;

import cadastro.Animal;
import pesagem.ConversorPeso;

/**
 * @author natalia
 * C�lculo do pre�o do animal de acordo com um valor de cota��o 
 * vari�vel (por dia, por ra�a, tipo de animal, ...)
 */
public class CalculoPreco {
	private Animal animal;
	private Cotacao cotacao;
	
	/**
	 * @param animal 	animal que ter� seu pre�o calculado
	 * @param cotacao	valor da cota��o desse animal
	 */
	public CalculoPreco(Animal animal, Cotacao cotacao) {
		this.animal = animal;
		this.cotacao = cotacao;
	}
	
	/**
	 * @return 	o valor de venda do animal, multiplicando seu peso em kilos
	 * 			pela cota��o do animal.
	 */
	public double valorVenda() {
		ConversorPeso peso = animal.getPeso();
		return peso.getPesoKilo() * cotacao.valorCotacao();
	}
}
