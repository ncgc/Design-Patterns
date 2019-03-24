package financeiro;

public class CotacaoSuino implements Cotacao{
	private double valorCotacao;
	
	public CotacaoSuino(double valorCotacao) {
		this.valorCotacao = valorCotacao;
	}

	@Override
	public double valorCotacao() {
		return valorCotacao;
	}
	

}
