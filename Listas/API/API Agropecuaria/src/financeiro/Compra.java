package financeiro;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;

import cadastro.Animal;
import cadastro.Bovino;
import cadastro.Suino;
import main.Fazenda;
import main.Rebanho;

/**
 * @author natalia
 * Classe que registra a compra de animais e realiza a atualização 
 * de sua quantidade na unidade administrativa (fazenda). 
 */
public class Compra {
	private Rebanho rebanhoComprado;
	private LocalDate dataCompra;
	private double valorCompra;
	private Fazenda fazenda;
	
	/**
	 * @param rebanhoComprado 	grupo de animais comprados
	 * @param ano				ano da compra
	 * @param mes				mês da compra
	 * @param dia				dia da compra
	 * @param fazenda			unidade administrativa para a qual os animais serão alocados.
	 */
	public Compra(Rebanho rebanhoComprado, int ano, int mes, int dia, Fazenda fazenda) {
		this.rebanhoComprado = rebanhoComprado;
		this.dataCompra = new LocalDate(ano, mes, dia);	
		this.valorCompra = rebanhoComprado.valorRebanho();
		this.fazenda = fazenda;
		atualizarRebanho();
		atualizarHistorico();
	}
	
	/**
	 * Realiza a inserção dos animais comprados em seus respectivos rebanhos
	 * (conjunto de animais de mesmo tipo)
	 */
	private void atualizarRebanho() {
		List<Animal> animaisComprados = rebanhoComprado.getAnimais();
		Rebanho rBovino = new Rebanho(new ArrayList<Animal>());
		Rebanho rSuino = new Rebanho(new ArrayList<Animal>());
		for(Animal a: animaisComprados) {
			if(a instanceof Bovino) rBovino.getAnimais().add((Bovino) a);	
			else rSuino.getAnimais().add((Suino) a);
		}
		fazenda.compraRebanho(fazenda.getRebanhoBovino(), rBovino);
		fazenda.compraRebanho(fazenda.getRebanhoSuino(), rSuino);
	}
	
	/**
	 * Atualiza o histórico de notas de compra que pertencem a uma unidade 
	 * administrativa (fazenda)
	 */
	private void atualizarHistorico() {
		fazenda.getHistoricoCompra().add(this);
	}

	/**
	 * @return o conjunto de animais comprados em uma determinada nota de compra
	 */
	public Rebanho getRebanhoComprado() {
		return rebanhoComprado;
	}

	/**
	 * @return data em que uma nota de compra foi registrada.
	 */
	public LocalDate getDataCompra() {
		return dataCompra;
	}

	/**
	 * @return valor dos animais comprados. 
	 */
	public double getValorCompra() {
		return valorCompra;
	}
	
}
