package financeiro;

import cadastro.Animal;
import pesagem.ConversorPeso;

/**
 * @author natalia
 * Cálculo do preço do animal de acordo com um valor de cotação 
 * variável (por dia, por raça, tipo de animal, ...)
 */
public class CalculoPreco {
	private Animal animal;
	private Cotacao cotacao;
	
	/**
	 * @param animal 	animal que terá seu preço calculado
	 * @param cotacao	valor da cotação desse animal
	 */
	public CalculoPreco(Animal animal, Cotacao cotacao) {
		this.animal = animal;
		this.cotacao = cotacao;
	}
	
	/**
	 * @return 	o valor de venda do animal, multiplicando seu peso em kilos
	 * 			pela cotação do animal.
	 */
	public double valorVenda() {
		ConversorPeso peso = animal.getPeso();
		return peso.getPesoKilo() * cotacao.valorCotacao();
	}
}
