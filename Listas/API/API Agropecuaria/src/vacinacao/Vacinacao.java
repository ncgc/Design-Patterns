package vacinacao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cadastro.Genero;

/**
 * @author natalia
 * Características estipuladas pela Anvisa para que a vacinação seja
 * eficiente no controle de zoonoses do rebanho bovino e/ou suino;
 */
public class Vacinacao {
	private String doença;
	private int intervaloAplicacao; 
	private int idadeMaxima;
	private int idadeMinima;
	private List<Genero> genero;
	
	
	/**
	 * @param Doença nome da doença para qual uma vacina deverá ser aplicada;
	 * 
	 * @param intervaloAplicacao	intervalo em meses em que uma dose deverá ser aplicada (em meses)
	 * 					 			por padrão é 12 meses (anual);
	 *  
	 * @param idadeMinima	(opicional) idade mínima que a vacina poderá ser tomada (em meses),
	 * 						 por padrão 12 meses (1 ano);
	 * 
	 * @param idadeMaxima  (opicional) limite de idade que a vacina deverá ser tomada (em meses)
	 * 						
	 * @param genero (opicional) identificação de vacinas obrigatórias a apenas um gênero do animal ou ambos
	 * 							 por padrão seu valor é ambos;
	 * 
	 */
	public Vacinacao(String doença) {
		this.doença = doença;
		this.intervaloAplicacao = 12;
		this.genero = new ArrayList<>(Arrays.asList(Genero.MACHO, Genero.FEMEA));
		this.idadeMinima = 12;
		this.idadeMaxima = 240;
	}

	
	public void setIdadeMaxima(int idade) {
		this.idadeMaxima = idade;
	}


	public void setGenero(List<Genero> genero) {
		this.genero = genero;
	}

	public void setIdadeMinima(int idade) {
		this.idadeMinima = idade;
	}
	
	public void setInveraloAplicacao(int intervalo) {
		this.intervaloAplicacao = intervalo;
	}


	/**
	 * @return nome da doença a qual a vacinação se destina a combater
	 */
	public String getDoença() {
		return doença;
	}

	/**
	 * @return intervado de aplicação entre as doses (em meses)
	 */
	public int getIntervaloAplicacao() {
		return intervaloAplicacao;
	}


	/**
	 * @return idade máxima que a vacina deverá ser aplicada
	 */
	public int getIdadeMaxima() {
		return idadeMaxima;
	}


	/**
	 * @return idade mínima para a primeira dose da vacina;
	 */
	public int getIdadeMinima() {
		return idadeMinima;
	}

	/**
	 * @return genero a que a vacinação se destina
	 */
	public List<Genero> getGenero() {
		return genero;
	}
	
}
