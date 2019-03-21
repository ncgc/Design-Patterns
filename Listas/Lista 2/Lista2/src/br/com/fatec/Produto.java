package br.com.fatec;

public class Produto {
	 public String nome;
	    protected double preco;
	    protected CalculadorPreco calcValor;
	   
	    public Produto(String nome, double preco, Desconto desconto){
	        this.nome = nome;
	        this.preco = preco;
	        this.calcValor = new CalculadorPreco(this, desconto);
	    }

	    public double valorComDesconto(){
	        return calcValor.calcularValor();
	    }

		public String getNome() {
			return nome;
		}

		public double getPreco() {
			return preco;
		}
	    
}
