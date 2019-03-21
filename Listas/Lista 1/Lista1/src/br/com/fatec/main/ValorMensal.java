package br.com.fatec.main;

public class ValorMensal implements CalculoValor{
    private final double mes = 2592E6;
   
    public double valorConta(double periodo, Veiculo veiculo){
        return Math.ceil(periodo/mes) * veiculo.getValorMensal();
    }
    
}
