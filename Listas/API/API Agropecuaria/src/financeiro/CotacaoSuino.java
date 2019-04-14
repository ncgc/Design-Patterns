package financeiro;

/**
 * @author natalia
 * Valor de cotação, considerando a unidade de peso kilo como oficial. 
 */
public class CotacaoSuino implements Cotacao{
	private double valorCotacao;
	
	public CotacaoSuino(double valorKilo) {
		this.valorCotacao = valorKilo;
	}

	@Override
	public double valorCotacao() {
		return valorCotacao;
	}
	

}
