public class ValorDiaria implements CalculoValor{
    public final double dia = 86400000;
    public Veiculo veiculo;

    public ValorDiaria(double periodo) {
        this.periodo = periodo;
    }

    public double valorConta(double periodo, Veiculo veiculo){
        return Math.ceil(periodo/dia) * veiculo.getValorDiaria();
    }
   
}