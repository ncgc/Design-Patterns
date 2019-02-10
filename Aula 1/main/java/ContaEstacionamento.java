public class ContaEstacionamento {
    private double inicio;
    private double fim;
    private Veiculo veiculo;

    public ContaEstacionamento(double inicio, double fim, Veiculo veiculo){
        this.inicio = inicio;
        this.fim = fim;
        this.veiculo = veiculo;
    }

    public double valorConta(){
        return null;
    }

    public void setCalculo(double calculoValor){
        double periodo = fim - inicio;
        if (periodo <= 12) {
            CalculoValor cv = new ValorHora(periodo, veiculo.getValorHora());
        }
    }
}