package cadastro;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.Months;

import financeiro.CalculoPreco;
import financeiro.Cotacao;
import pesagem.ConversorPeso;
import vacinacao.CartaoVacinacao;
import vacinacao.ItemCartaoVacinacao;

/**
 * @author natalia
 * Cadastro de animais 
 */
public abstract class Animal {
	public static final AtomicInteger count = new AtomicInteger(0);
	protected final int ID;
	protected ConversorPeso peso;
	protected Genero genero;
	protected LocalDate dataNascimento;
	protected double preco;
	protected Cotacao cotacao;
	protected ArrayList<ItemCartaoVacinacao> cartaoVacinacao;
	
	/**
	 * @param peso		peso do animal, definido em kg ou arroba
	 * @param genero	g�nero do animal (feminino ou masculino)
	 * @param ano		ano de nascimento
	 * @param mes		m�s de nascimento
	 * @param dia		dia de nascimento
	 * @param cotacao	valor do animal segundo a conta��o do dia @see Cota��o
	 */
	public Animal(ConversorPeso peso, Genero genero, int ano, int mes, int dia , Cotacao cotacao) {
		this.ID = count.incrementAndGet();
		this.peso = peso;
		this.genero = genero;
		this.dataNascimento = new LocalDate(ano, mes, dia);	
		this.cotacao = cotacao;
		this.preco = setPreco();
		this.cartaoVacinacao = new CartaoVacinacao(this).getPlanoVacinacao();
		
	}
	
	/**
	 * @return n�mero de cadastro �nico do animal
	 */
	public int getID() {
		return ID;
	}

	/**
	 * @return g�nero do animal
	 */
	public Genero getGenero() {
		return genero;
	}
	
	/**
	 * @return peso do animal sem especificar a unidade
	 */
	public ConversorPeso getPeso() {
		return peso;
	}
	
	/**
	 * @return define o valor de venda do animal, segundo uma cota��o.
	 */
	private double setPreco() {
		return new CalculoPreco(this, cotacao).valorVenda();
	}

	/**
	 * @return data de nascimento
	 */
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	/**
	 * @return valor do peso do animal em um determinado dia
	 */
	public Cotacao getCotacao() {
		return cotacao;
	}

	/**
	 * @return lista de efermidades que o animal dever� ser monitorado ao longo da vida
	 */
	public ArrayList<ItemCartaoVacinacao> getCartaoVacinacao() {
		return cartaoVacinacao;
	}

	/**
	 * @return idade atual do animal;
	 */
	public int getIdade() {
		LocalDate agora = new LocalDate().now(DateTimeZone.UTC);
		return Months.monthsBetween(agora, dataNascimento).getMonths();
	}

	/**
	 * @return preco de venda do animal 
	 */
	public double getPreco() {
		return preco;
	}
	
	

	
}
