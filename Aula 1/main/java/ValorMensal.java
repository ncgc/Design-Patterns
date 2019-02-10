public class ValorMensal implements CalculoValor{
    public final double mes = 2592E6;
    public double valorMes;

    public ValorMensal(double periodo, double valorMes){
        this.periodo = periodo;
        this.valorMes = valorMes;
    }

    public double valorConta(){
        return Math.ceil(periodo/mes) * valorMes;
    }
    
}