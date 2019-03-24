/*
 * Classe para armazenar os dados do produto comercializado. 
 * @author Natalia Goncalves
 * @version 1.0 (Mar 10 2019)
 */

package br.com.fatec.main;

public class Produto implements Descricao{
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

	public void descreverProduto() {}


}
