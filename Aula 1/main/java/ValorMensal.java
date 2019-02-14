public class ValorMensal implements CalculoValor{
    public final double mes = 2592E6;
    public double valorMes;

    public ValorMensal(double periodo, double valorMes){
        this.periodo = periodo;
    }

    public double valorConta(double periodo, Veiculo veiculo){
        return Math.ceil(periodo/mes) * veiculo.getValorMensal();
    }
    
}