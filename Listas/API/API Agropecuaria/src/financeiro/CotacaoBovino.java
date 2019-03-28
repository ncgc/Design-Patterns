package financeiro;

public class CotacaoBovino implements Cotacao {
	public double precoArroba;

	public CotacaoBovino(double precoArroba) {
		this.precoArroba = precoArroba;
	}

	@Override
	public double valorCotacao() {
		return precoArroba/14.689;
	}

}
