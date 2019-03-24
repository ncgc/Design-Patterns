package br.com.fatec.main;

public class Produto {
	protected String nome;
	protected double valor;
	public Desconto desconto;
	

	public String getNome() {
		return nome;
	}

	public double getValorProduto() {
		return valor;
	}
	
	public double getValorComDesconto() {
		return new CalculadorPreco(this, desconto).calcularDesconto();
	}

	
}
