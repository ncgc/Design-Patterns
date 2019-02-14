package br.com.fatec;

public class ValorHora implements CalculoValor{ 
    private final double hora = 3600000;
    public double periodo;

    public ValorHora(double periodo) {
        this.periodo = periodo;
    }

    public double valorConta(double periodo, Veiculo veiculo){
        return Math.ceil(periodo/hora) * veiculo.getValorHora();
    }
    
}
