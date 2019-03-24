package br.com.fatec.main;

/**
 * Implementa a descricao de uma mochila
 * @author Natalia Gonçalves
 *
 */
public class Mochila extends ProdutoUnitario {
	private String marca;
	private String cor;
	private String dimensoes;
	private int capacidade;
	/**
	 * @param nome			nome do produto
	 * @param valor			valor original da mochila 
	 * @param desconto		valor de desconto aplicado à mochila
	 * @param marca			marca da mochila
	 * @param cor			cor da mochila
	 * @param dimensões 	dimensões da mochila descrita como largura x altura x profundidade
	 * @param capacidade	capacidade em kilos que a mochila suporta
	 */
	public Mochila(String nome, double valor, Desconto desconto, String marca, String cor, String dimensoes,
			int capacidade) {
		super(nome, valor, desconto);
		this.marca = marca;
		this.cor = cor;
		this.dimensoes = dimensoes;
		this.capacidade = capacidade;
	}
	
	@Override
	public void descreverProduto() {
		System.out.println("Marca: " + this.marca);
		System.out.println("Cor: " + this.cor);
		System.out.println("Tamanho: " + this.dimensoes);
		System.out.println("Capacidade: " + this.capacidade + "kg");
	
	}


	
}
