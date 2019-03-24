/*
 * Implementa o cálculo do desconto a ser aplicado no produto 
 * caso seja informado a quantia exata em dinheiro.
 * @see br.com.fatec.Desconto#valorDesconto()
*/

package br.com.fatec.main;

public class DescontoDinheiro implements Desconto{
	 public double valorDesconto;

	 public DescontoDinheiro(double valor){
	        this.valorDesconto = valor;
	    }

	    @Override
	    public double valorDesconto(){
	        return valorDesconto;
	    }
}
