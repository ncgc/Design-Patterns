package financeiro;

/**
 * @author natalia
 * Valor da cota��o para animais bovinos, considerando a unidade de peso arroba
 * como a oficial. 
 */
public class CotacaoBovino implements Cotacao {
	public double precoArroba;

	/**
	 * @param precoArroba pre�o do animal em arrobas
	 */
	public CotacaoBovino(double precoArroba) {
		this.precoArroba = precoArroba;
	}

	@Override
	public double valorCotacao() {
		return precoArroba/14.689;
	}

}
