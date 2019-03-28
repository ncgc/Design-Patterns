package financeiro;

import cadastro.Animal;
import pesagem.ConversorPeso;

public class CalculoPreco {
	private Animal animal;
	private Cotacao cotacao;
	
	public CalculoPreco(Animal animal, Cotacao cotacao) {
		this.animal = animal;
		this.cotacao = cotacao;
	}
	
	public double valorVenda() {
		ConversorPeso peso = animal.getPeso();
		return peso.getPesoKilo() * cotacao.valorCotacao();
	}
}
