package br.com.fatec.main;

import java.util.ArrayList;
import java.util.List;

public class ProdutoComposto extends Produto implements Descricao{
	private List<Produto> kit = new ArrayList<>();
	
	public ProdutoComposto(String nome, List<Produto> produtos, Desconto desconto) {
		this.nome = nome;
		this.kit.addAll(produtos);
		this.valor = setValor();
		this.desconto = desconto;
	}

	/*
	 * @return  retorna o valor do kit como soma dos valores dos 
	 * 			produtos que o compõe
	 */
	private double setValor() {
		valor = 0;
		for(Produto p: kit) {
			valor += p.getValorProduto();
		}
		return valor;
	}

	@Override
	public void descreverProduto() {
		System.out.println("Kit " + this.nome);
		System.out.println("---------------------------------------------");
		for(Produto p: this.kit) {
			p.descreverProduto();
			System.out.println();
		}
		
	}
	
}
