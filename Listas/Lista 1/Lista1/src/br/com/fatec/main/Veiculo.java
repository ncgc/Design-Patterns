package br.com.fatec.main;

/*
 * Implementa o objeto Veiculo informando os valores cobrados
 * para cada intervalo de perman�ncia, ou seja, hora, dia, m�s.
 * @ author Natalia Gon�alves
 * @version 1.0 (Mar 10 2019)
 */

public class Veiculo{
    protected double valorHora;
    protected double valorDiaria;
    protected double valorMensal;

   
    public Veiculo (double valorHora, double valorDiaria, double valorMensal){
        this.valorHora = valorHora;
        this.valorDiaria = valorDiaria;
        this.valorMensal = valorMensal;
    }

   /*
    * @return valorHora
    */
    public double getValorHora() {
        return valorHora;
    }

   /*
    * @return valorDiaria
    */
    public double getValorDiaria() {
        return valorDiaria;
    }

    /*
     * @return valorMensal
     */
    public double getValorMensal() {
        return valorMensal;
    }

}
