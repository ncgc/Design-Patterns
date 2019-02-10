public class ValorDiaria implements CalculoValor{
    public final double dia = 86400000;
    public double valorDiaria;

    public ValorDiaria(double periodo, double valorDiaria) {
        this.periodo = periodo;
        this.valorDiaria = valorDiaria;
    }

    public double valorConta(){
        return Math.ceil(periodo/dia) * valorDiaria;
    }
   
}