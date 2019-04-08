package vacinacao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cadastro.Genero;

/**
 * @author natalia
 * Caracter�sticas estipuladas pela Anvisa para que a vacina��o seja
 * eficiente no controle de zoonoses do rebanho bovino e/ou suino;
 */
public class Vacinacao {
	private String doen�a;
	private int intervaloAplicacao; 
	private int idadeMaxima;
	private int idadeMinima;
	private List<Genero> genero;
	
	
	/**
	 * @param Doen�a nome da doen�a para qual uma vacina dever� ser aplicada;
	 * 
	 * @param intervaloAplicacao	intervalo em meses em que uma dose dever� ser aplicada (em meses)
	 * 					 			por padr�o � 12 meses (anual);
	 *  
	 * @param idadeMinima	(opicional) idade m�nima que a vacina poder� ser tomada (em meses),
	 * 						 por padr�o 12 meses (1 ano);
	 * 
	 * @param idadeMaxima  (opicional) limite de idade que a vacina dever� ser tomada (em meses)
	 * 						
	 * @param genero (opicional) identifica��o de vacinas obrigat�rias a apenas um g�nero do animal ou ambos
	 * 							 por padr�o seu valor � ambos;
	 * 
	 */
	public Vacinacao(String doen�a) {
		this.doen�a = doen�a;
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
	 * @return nome da doen�a a qual a vacina��o se destina a combater
	 */
	public String getDoen�a() {
		return doen�a;
	}

	/**
	 * @return intervado de aplica��o entre as doses (em meses)
	 */
	public int getIntervaloAplicacao() {
		return intervaloAplicacao;
	}


	/**
	 * @return idade m�xima que a vacina dever� ser aplicada
	 */
	public int getIdadeMaxima() {
		return idadeMaxima;
	}


	/**
	 * @return idade m�nima para a primeira dose da vacina;
	 */
	public int getIdadeMinima() {
		return idadeMinima;
	}

	/**
	 * @return genero a que a vacina��o se destina
	 */
	public List<Genero> getGenero() {
		return genero;
	}
	
}
