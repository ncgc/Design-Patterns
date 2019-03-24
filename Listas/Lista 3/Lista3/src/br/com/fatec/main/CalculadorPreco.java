/*
 * Calcula o valor final do produto após a aplicação do desconto
 * @author Natalia Goncalves
 * @version 1.0 (Mar 10 2019)
 */

package br.com.fatec.main;

public class CalculadorPreco {
	public Produto produto;
	public Desconto desconto;
	
	public CalculadorPreco(Produto produto, Desconto desconto) {
		this.produto = produto;
		this.desconto = desconto;
	}

	/*
     * Calculo do valor final do produto após a aplicação do desconto 
     * identificando a fórmula de cálculo dependendo do tipo de desconto 
     * aplicado, ou seja, se monetário ou em porcentual. 
     */
	public double calcularDesconto() {
		if(desconto instanceof DescontoDinheiro){
            return produto.valor - desconto.valorDesconto();
        }
        return produto.valor * (1 - desconto.valorDesconto());
    }

}
