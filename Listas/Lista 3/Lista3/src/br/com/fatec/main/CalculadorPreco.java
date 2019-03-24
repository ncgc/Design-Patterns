package br.com.fatec.main;

public class CalculadorPreco {
	public Produto produto;
	public Desconto desconto;
	
	public CalculadorPreco(Produto produto, Desconto desconto) {
		this.produto = produto;
		this.desconto = desconto;
	}

	public double calcularDesconto() {
		if(desconto instanceof DescontoDinheiro){
            return produto.valor - desconto.valorDesconto();
        }
        return produto.valor * (1 - desconto.valorDesconto());
    }

}
