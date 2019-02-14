package br.com.fatec;

public class ContaEstacionamento {
    private double inicio;
    private double fim;
    private Veiculo veiculo;
    private double valorCobrado;

    public ContaEstacionamento(double inicio, double fim, Veiculo veiculo){
        this.inicio = inicio;
        this.fim = fim;
        this.veiculo = veiculo;
    }

    public double valorConta(){
        return valorCobrado;
    }

    public void setCalculo(CalculoValor calculoValor){
        double periodo = fim - inicio;
        valorCobrado = calculoValor.valorConta(periodo, veiculo);
    }
}
