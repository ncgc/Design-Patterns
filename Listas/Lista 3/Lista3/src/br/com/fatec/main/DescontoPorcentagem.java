/*
 * Implementa o cálculo do desconto a ser aplicado no produto 
 * caso seja informado o percentual de valor. 
 * @see br.com.fatec.Desconto#valorDesconto()
*/

package br.com.fatec.main;

public class DescontoPorcentagem implements Desconto{
	public double valorDesconto;
	
	public DescontoPorcentagem(double percentual) {
		this.valorDesconto = percentual;
	}
	
	 /*
     * @return conversão do valor em porcentagem para decimal
     */
	public double valorDesconto() {
		return valorDesconto/100;
	}

}
