/*
 * Interface para o calculo do valor cobrado para cada ve�culo de acordo com 
 * sua perman�ncia no estacionamento, segundo o padr�o de projeto composi��o. 
 */


package br.com.fatec.main;

public interface CalculoValor {
	
	/*
	 * Calcula o valor a ser cobrado pela perman�ncia do ve�culo no estacionamento
	 * @param periodo corresponde ao tempo transcorrido entre a entrada e sa�da do 
	 * 				  ve�culo no estacionamento (em horas).
	 * @param veiculo corresponde ao ve�culo a que a conta pertence, identificando a
	 * 				  tabela de valores cobrados para cada intervalo de perman�ncia. 
	 */
	public double valorConta (double periodo, Veiculo veiculo);
	
}
