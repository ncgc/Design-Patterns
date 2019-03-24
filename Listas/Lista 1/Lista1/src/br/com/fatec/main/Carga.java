/*
 * Implementa as particularidades de cobrança do veículo tipo carga
 * @author Natalia Gonçalves
 * @version 1.0 (Mar 10 2019)
 */

package br.com.fatec.main;

public class Carga extends Veiculo{
    public Carga(double valorHora, double valorDiaria, double valorMensal){
        super(valorDiaria, valorDiaria, valorDiaria);
    }
}
