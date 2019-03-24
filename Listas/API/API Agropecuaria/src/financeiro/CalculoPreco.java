package financeiro;

import cadastro.Animal;

public class CalculoPreco {
	private Animal animal;
	private Cotacao cotacao;
	
	public CalculoPreco(Animal animal, Cotacao cotacao) {
		this.animal = animal;
		this.cotacao = cotacao;
	}
	
	public double valorVenda() {
		return cotacao.valorCotacao() * animal.getPeso();
	}

}
