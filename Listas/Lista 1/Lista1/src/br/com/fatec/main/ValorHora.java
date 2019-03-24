package br.com.fatec.main;

public class ValorHora implements CalculoValor{ 

	/*
	 * Calcula o valor da conta quando a permanência em horas
	 * @see br.com.fatec.main.CalculoValor#valorConta(double, br.com.fatec.main.Veiculo)
	 */
    public double valorConta(double periodo, Veiculo veiculo){
        return Math.ceil(periodo) * veiculo.getValorHora();
    }
    
}
