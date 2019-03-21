package br.com.fatec.main;

public class ValorHora implements CalculoValor{ 
    private final double hora = 3600000;

    public double valorConta(double periodo, Veiculo veiculo){
        return Math.ceil(periodo/hora) * veiculo.getValorHora();
    }
    
}
