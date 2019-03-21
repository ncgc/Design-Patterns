package br.com.fatec;

public class CalculadorPreco {
	public Produto produto;
    public Desconto desconto;
    
    public  CalculadorPreco(Produto produto, Desconto desconto){
        this.produto = produto;
        this.desconto = desconto;
    }

    public double calcularValor(){
        if(desconto instanceof DescontoDinheiro){
            return produto.preco - desconto.valorDesconto();
        }
        return produto.preco * (1 - desconto.valorDesconto());
    }
}
