package br.com.fatec.main;

import java.util.ArrayList;
import java.util.List;

public class ProdutoComposto extends Produto{
	private List<Produto> kit = new ArrayList<>();
	
	public ProdutoComposto(String nome, List<Produto> produtos, Desconto desconto) {
		this.nome = nome;
		this.kit.addAll(produtos);
		this.valor = setValor();
		this.desconto = desconto;
	}

	private double setValor() {
		valor = 0;
		for(Produto p: kit) {
			valor += p.getValorProduto();
		}
		return valor;
	}
	
}
