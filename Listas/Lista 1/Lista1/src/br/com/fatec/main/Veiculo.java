package br.com.fatec.main;

public class Veiculo{
    protected double valorHora;
    protected double valorDiaria;
    protected double valorMensal;

    public Veiculo (double valorHora, double valorDiaria, double valorMensal){
        this.valorHora = valorHora;
        this.valorDiaria = valorDiaria;
        this.valorMensal = valorMensal;
    }

   
    public double getValorHora() {
        return valorHora;
    }

   
    public double getValorDiaria() {
        return valorDiaria;
    }

    
    public double getValorMensal() {
        return valorMensal;
    }

}
