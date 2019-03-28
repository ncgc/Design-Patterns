package financeiro;

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
