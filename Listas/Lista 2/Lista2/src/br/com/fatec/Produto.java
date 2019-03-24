/*
 * Classe para armazenar os dados do produto comercializado. 
 * @author Natalia Goncalves
 * @version 1.0 (Mar 10 2019)
 */

package br.com.fatec;

public class Produto {
	 	public String nome;
	 	protected double preco;
	    protected CalculadorPreco calcValor;
	   
	    /*
	     * @param nome  	nome do produto
	     * @param preco 	valor original do produto sobre o qual o desconto será aplicado
	     * @param desconto	tipo de desconto que será aplicado: dinheiro ou percentual
	     */
	    public Produto(String nome, double preco, Desconto desconto){
	        this.nome = nome;
	        this.preco = preco;
	        this.calcValor = new CalculadorPreco(this, desconto);
	    }

	    /*
	     * @return valor a ser cobrado com o desconto atribuído
	     */
	    public double valorComDesconto(){
	        return calcValor.calcularValor();
	    }

	    /*
	     * @return nome do produto
	     */
		public String getNome() {
			return nome;
		}

		/*
		 * @return preco do produto sem desconto 
		 */
		public double getPreco() {
			return preco;
		}
	    
}
