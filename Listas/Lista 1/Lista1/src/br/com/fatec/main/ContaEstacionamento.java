package br.com.fatec.main;

public class ContaEstacionamento {
    private long inicio, fim;
    private Veiculo veiculo;
    private CalculoValor cv;

    public ContaEstacionamento(long inicio, long fim, Veiculo veiculo, CalculoValor cv){
        this.inicio = inicio;
        this.fim = fim;
        this.veiculo = veiculo;
        this.cv = cv;
    }

    public double valorConta(){
        return cv.valorConta(fim - inicio, veiculo);
    }

}
