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
 * Classe que registra a venda de animais e realiza a atualização 
 * de sua quantidade na unidade administrativa (fazenda). 
 */
public class Venda  {
	private Rebanho rebanhoVendido;
	private LocalDate dataVenda;
	private double valorVenda;
	private Fazenda fazenda;
	
	/**
	 * @param rebanho	conjunto de animais informados como vendidos antes da validação
	 * @param ano		ano da realização da venda
	 * @param mes		mês da realização da venda
	 * @param dia		dia da realização da venda
	 * @param fazenda	unidade administrativa para a qual os animais serão alocados
	 */
	public Venda(Rebanho rebanho, int ano, int mes, int dia, Fazenda fazenda) {
		this.dataVenda = new LocalDate(ano, mes, dia);
		this.fazenda = fazenda.getInstance();
		this.valorVenda = 0;
		validaVenda(rebanho);
	}
	
	/**
	 * Valida se os animais informados como vendidos pertencem a unidade administrativa (fazenda)
	 * fornecedora desses animais. Ou seja, verifica se os animais existem ou não, validando a transação. 
	 * 
	 * Os animais identificados como pertencentes a unidade administrativa e, portanto, aptos a serem vendidos
	 * são então registrados na nota de venda e removidos de seus respectivos rebanhos. 
	 * 
	 * @param conjunto de animais informados como vendidos
	 */
	private void validaVenda(Rebanho rebanho) {
		rebanhoVendido = new Rebanho(new ArrayList<Animal>());
		for(Animal a: rebanho.getAnimais()) {
			if(isVenda(a))
				rebanhoVendido.getAnimais().add(a);
		}
		if(rebanhoVendido.getAnimais().isEmpty()) {}
		else {
			this.valorVenda = rebanhoVendido.valorRebanho();
			atualizarRebanho();
			atualizarHistorico();
		}
	}

	/**
	 * Verifica se um animal faz parte da unidade administrativa ou não
	 * @param a 	Animal que se deseja saber a origem. 
	 * @return 		TRUE quando o animal pertence a unidade administrativa
	 * 				FALSE quando o animal não pertende a unidade administrativa
	 */
	private boolean isVenda(Animal a) {
		if(a instanceof Bovino) {
			List<Animal> animaisBovinos = fazenda.getRebanhoBovino().getAnimais();
			if(animaisBovinos.contains(a)) {
				return true;
			}
		}
		else {
			List<Animal> animaisSuinos = fazenda.getRebanhoSuino().getAnimais();
			if(animaisSuinos.contains(a)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Atualiza os rebanhos da unidade administrativa, removendo os animais vendidos.
	 */
	private void atualizarRebanho() {
		List<Animal> animaisVendidos = rebanhoVendido.getAnimais();
		Rebanho rBovino = new Rebanho(new ArrayList<Animal>());
		Rebanho rSuino = new Rebanho(new ArrayList<Animal>());
		for(Animal a: animaisVendidos) {
			if(a instanceof Bovino) rBovino.getAnimais().add((Bovino) a);	
			else rSuino.getAnimais().add((Suino) a);
		}
		fazenda.vendaRebanho(fazenda.getRebanhoBovino(), rBovino);
		fazenda.vendaRebanho(fazenda.getRebanhoSuino(), rSuino);
	}
	
	/**
	 * Registra a venda no histórico de vendas da unidade administrativa
	 */
	private void atualizarHistorico() {
		fazenda.getHistoricoVenda().add(this);
	}

	/**
	 * 
	 * @return rebanho oficialmente vendido pela unidade administrativa em uma determinada nota de venda
	 */
	public Rebanho getRebanhoVendido() {
		return rebanhoVendido;
	}

	/**
	 * @return data da nota de venda 
	 */
	public LocalDate getDataVenda() {
		return dataVenda;
	}

	/**
	 * @return valor dos animais oficialmente vendidos pela unidade administrativa
	 */
	public double getValorVenda() {
		return valorVenda;
	}
	
}
