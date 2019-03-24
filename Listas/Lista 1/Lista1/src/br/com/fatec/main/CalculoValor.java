/*
 * Interface para o calculo do valor cobrado para cada veículo de acordo com 
 * sua permanência no estacionamento, segundo o padrão de projeto composição. 
 */


package br.com.fatec.main;

public interface CalculoValor {
	
	/*
	 * Calcula o valor a ser cobrado pela permanência do veículo no estacionamento
	 * @param periodo corresponde ao tempo transcorrido entre a entrada e saída do 
	 * 				  veículo no estacionamento (em horas).
	 * @param veiculo corresponde ao veículo a que a conta pertence, identificando a
	 * 				  tabela de valores cobrados para cada intervalo de permanência. 
	 */
	public double valorConta (double periodo, Veiculo veiculo);
	
}
