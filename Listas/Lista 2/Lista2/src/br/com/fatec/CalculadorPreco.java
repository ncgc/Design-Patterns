/*
 * Calcula o valor final do produto ap�s a aplica��o do desconto
 * @author Natalia Goncalves
 * @version 1.0 (Mar 10 2019)
 */
package br.com.fatec;

public class CalculadorPreco {
	public Produto produto;
    public Desconto desconto;
    
    public  CalculadorPreco(Produto produto, Desconto desconto){
        this.produto = produto;
        this.desconto = desconto;
    }

    /*
     * Calculo do valor final do produto ap�s a aplica��o do desconto 
     * identificando a f�rmula de c�lculo dependendo do tipo de desconto 
     * aplicado, ou seja, se monet�rio ou em porcentual. 
     */
    public double calcularValor(){
        if(desconto instanceof DescontoDinheiro){
            return produto.preco - desconto.valorDesconto();
        }
        return produto.preco * (1 - desconto.valorDesconto());
    }
}
