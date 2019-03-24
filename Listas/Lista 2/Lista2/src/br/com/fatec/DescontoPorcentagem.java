/*
 * Implementa o cálculo do desconto a ser aplicado no produto 
 * caso seja informado o percentual de valor. 
 * @see br.com.fatec.Desconto#valorDesconto()
*/

package br.com.fatec;

public class DescontoPorcentagem implements Desconto{
	    public double percentual;

	    public DescontoPorcentagem(double percentual){
	        this.percentual = percentual;
	    }

	    /*
	     * @return conversão do valor em porcentagem para decimal
	     */
	    public double valorDesconto(){
	        return (percentual/100);
	    }
}
