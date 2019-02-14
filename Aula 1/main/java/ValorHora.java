public class ValorHora implements CalculoValor{ 
    public final double hora = 3600000;

    public ValorHora(double periodo) {
        this.periodo = periodo;
    }

    public double valorConta(double periodo, Veiculo veiculo){
        return Math.ceil(periodo/hora) * veiculo.getValorHora();
    }
    
}