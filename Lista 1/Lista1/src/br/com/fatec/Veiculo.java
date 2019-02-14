package br.com.fatec;

public class Veiculo{
    protected double valorHora;
    protected double valorDiaria;
    protected double valorMensal;

    public Veiculo (double valorHora, double valorDiaria, double valorMensal){
        this.valorHora = valorHora;
        this.valorDiaria = valorDiaria;
        this.valorMensal = valorMensal;
    }

    /**
     * @return the valorHora
     */
    public double getValorHora() {
        return valorHora;
    }

    /**
     * @return the valorDiaria
     */
    public double getValorDiaria() {
        return valorDiaria;
    }

    /**
     * @return the valorMensal
     */
    public double getValorMensal() {
        return valorMensal;
    }

}
