package br.com.fatec.main;

public class ValorDiaria implements CalculoValor{
    private final double dia = 24;

    /*
     * Calcula o valor da conta para a perman�ncia di�ria
     * @see br.com.fatec.main.CalculoValor#valorConta(double, br.com.fatec.main.Veiculo)
     */
    public double valorConta(double periodo, Veiculo veiculo){
        return Math.ceil(periodo/dia) * veiculo.getValorDiaria();
    }
   
}