package br.com.fatec.main;

/*
 * Classe que armazena todos os dados de um ve�culo no estacionamento. 
 * @author Natalia Gon�alves
 * @version 1.0 (Mar 10 2019)
 */

public class ContaEstacionamento {
    private long inicio, fim;
    private Veiculo veiculo;
    private CalculoValor cv;

    /*
     * @param inicio		informa o hor�rio de entrada do ve�culo no estacionamento (em horas)
     * @param fim 			informa o hor�rio de saida do ve�culo do estacionamento (em horas)
     * @param Veiculo 		informa o tipo de ve�culo a que a conta se refere
     * @param CalculoValor 	informa o tipo de cobran�a que ser� feita segundo o per�odo de 
     * 						perman�ncia, ou seja, por hora, por dia ou por m�s. 
     */
 
    public ContaEstacionamento(long inicio, long fim, Veiculo veiculo, CalculoValor cv){
        this.inicio = inicio;
        this.fim = fim;
        this.veiculo = veiculo;
        this.cv = cv;
    }

    /*
     * return valor a ser cobrado pela perman�ncia do ve�culo no estacionamento
     */
    public double valorConta(){
        return cv.valorConta(fim - inicio, veiculo);
    }

}
