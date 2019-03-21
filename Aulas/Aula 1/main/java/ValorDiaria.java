public class ValorDiaria implements CalculoValor{
    private final double dia = 86400000;
    public double periodo;

    public ValorDiaria(double periodo) {
        this.periodo = periodo;
    }

    public double valorConta(double periodo, Veiculo veiculo){
        return Math.ceil(periodo/dia) * veiculo.getValorDiaria();
    }
   
}