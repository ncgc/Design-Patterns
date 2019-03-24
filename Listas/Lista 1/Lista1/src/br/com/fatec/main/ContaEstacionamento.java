package br.com.fatec.main;

/*
 * Classe que armazena todos os dados de um veículo no estacionamento. 
 * @author Natalia Gonçalves
 * @version 1.0 (Mar 10 2019)
 */

public class ContaEstacionamento {
    private long inicio, fim;
    private Veiculo veiculo;
    private CalculoValor cv;

    /*
     * @param inicio		informa o horário de entrada do veículo no estacionamento (em horas)
     * @param fim 			informa o horário de saida do veículo do estacionamento (em horas)
     * @param Veiculo 		informa o tipo de veículo a que a conta se refere
     * @param CalculoValor 	informa o tipo de cobrança que será feita segundo o período de 
     * 						permanência, ou seja, por hora, por dia ou por mês. 
     */
 
    public ContaEstacionamento(long inicio, long fim, Veiculo veiculo, CalculoValor cv){
        this.inicio = inicio;
        this.fim = fim;
        this.veiculo = veiculo;
        this.cv = cv;
    }

    /*
     * return valor a ser cobrado pela permanência do veículo no estacionamento
     */
    public double valorConta(){
        return cv.valorConta(fim - inicio, veiculo);
    }

}
