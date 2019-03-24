package br.com.fatec.main;

public class ValorMensal implements CalculoValor{
    private final double mes = 720;
   
    /*
     * Calcula o valor da permanência em meses.
     * @see br.com.fatec.main.CalculoValor#valorConta(double, br.com.fatec.main.Veiculo)
     */
    public double valorConta(double periodo, Veiculo veiculo){
        return Math.ceil(periodo/mes) * veiculo.getValorMensal();
    }
    
}
