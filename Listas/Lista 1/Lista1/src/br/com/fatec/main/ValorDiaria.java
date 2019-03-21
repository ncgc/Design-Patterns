package br.com.fatec.main;

public class ValorDiaria implements CalculoValor{
    private final double dia = 86400000;

    public double valorConta(double periodo, Veiculo veiculo){
        return Math.ceil(periodo/dia) * veiculo.getValorDiaria();
    }
   
}