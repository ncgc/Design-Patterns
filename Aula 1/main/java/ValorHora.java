public class ValorHora implements CalculoValor{ 
    public final double hora = 3600000;
    public double valorHora;


    public ValorHora(double periodo, double valorHora) {
        this.periodo = periodo;
        this.valorHora = valorHora;
    }

    public double valorConta(){
        return Math.ceil(periodo/hora) * valorHora;
    }
    
}