package main;

import java.util.ArrayList;
import java.util.List;

import cadastro.Animal;
import cadastro.Bovino;
import cadastro.Genero;
import financeiro.Compra;
import financeiro.Venda;

/**
 * @author natalia
 * Classe para administração de todos os dados necessários para gestão de animais e financeiras. 
 */
public class Fazenda {
	
	private static Fazenda uniqueInstance;
	private  Rebanho bovino;
	private  Rebanho suino;
	private List<Compra> historicoCompra;
	private List<Venda> historicoVenda;

	/**
	 * Cria rebanhos (conjunto de animais de mesmo tipo) para bovinos e suinos
	 * bem como uma lista de historico de compra e venda de animais. 
	 */
	private Fazenda() {
		this.bovino = new Rebanho(new ArrayList<Animal>());
		this.suino = new Rebanho(new ArrayList<Animal>());
		this.historicoCompra = new ArrayList<>();
		this.historicoVenda= new ArrayList<>();
	}
	
	/**
	 * @return uma instância única da unidade administrativa 
	 */
	public static Fazenda getInstance() {
		if(uniqueInstance == null)
			uniqueInstance = new Fazenda();
		return uniqueInstance;
	}
	
	// Administração populacional
	/**
	 * @return retorna a quantidade total de animais que pertecem a unidade administrativa
	 */
	public double totalAnimais() {
		return bovino.qtdAnimais() + suino.qtdAnimais();
	}
	
	/**
	 * @return retorna a quantidade total de animais do tipo bovino
	 */
	public Rebanho getRebanhoBovino() {
		return bovino;
	}
	
	/**
	 * @return retorna a quantidade total de animais do tipo suino
	 */
	public Rebanho getRebanhoSuino() {
		return suino;
	}
	
	/**
	 * @param r 	rebanho do qual se deseja a informação sobre a quantidade por gênero (bovino/suino)
	 * @param g		genêro do qual se deseja saber a quantidade de animais (macho/fêmea)
	 * @return		quantidade de animais de um determinando rebanho (bovino/suino) que são de um gênero especificado (macho/fêmea)
	 */
	public int getQuantidadeGenero(Rebanho r, Genero g) {
		return r.calculaGenero(g);
	}
	
	/**
	 * Registro de nascimentos de animais na unidade administrativa por cruzamento
	 * @param a Animal gerado na unidade adminstrativa
	 */
	public void nascimento(Animal a) {
		if(a instanceof Bovino) {
			bovino.getAnimais().add(a);
		}
		else {
			suino.getAnimais().add(a);
		}
	}
	
	/**
	 * Registro de falecimento de animal 
	 * @param a	Animal falecido na unidade administrativa
	 */
	public void morte(Animal a) {
		if(a instanceof Bovino) {
			bovino.getAnimais().remove(a);
		}
		else {
			suino.getAnimais().remove(a);
		}
	}
	
	/**
	 * @param r			rebanho de animal que se deseja conhecer o peso total (bovino/suino)
	 * @param unPeso	unidade de peso desejada para o resultado (kilo/arroba)	
	 * @return			soma do peso dos animais pertencentes a um rebanho. 
	 */
	public double getPesoTotal(Rebanho r, String unPeso) {
		if(unPeso.toLowerCase().equals("kilo"))
			return r.pesoTotalKg();
		return r.pesoTotalArroba();
	}
	
	//Administração financeira
	/**
	 * @return soma dos valores de venda de todos os animais pertencentes a unidade administrativa
	 */
	public double valorAtivo() {
		return suino.valorRebanho() + bovino.valorRebanho();
	}
	
	/**
	 * Atualiza os animais de cada rebanho, registrando os animais comprados.
	 * @param rAtual		rebanho atual da unidade administrativa	
	 * @param rComprado		rebanho comprado para a unidade administrativa
	 */
	public void compraRebanho(Rebanho rAtual, Rebanho rComprado) {
		rAtual.addRebanho(rComprado.getAnimais());
	}
	
	/**
	 * Atualiza os animais de cada rebanho, removendo dos registros os animais vendidos.
	 * @param rAtual	rebanho atual da unidade administrativa	
	 * @param rVendido	rebanho vendido da unidade administrativa
	 */
	public void vendaRebanho(Rebanho rAtual, Rebanho rVendido) {
		rAtual.removeRebanho(rVendido.getAnimais());
	}

	/**
	 * @return histórico de compras realizadas pela unidade administrativa
	 */
	public List<Compra> getHistoricoCompra() {
		return historicoCompra;
	}

	/**
	 * Adiciona no histórico de compra uma nova compra efetivada
	 * @param compra Nota de compra realizada pela unidade administrativa
	 */
	public void setHistoricoCompra(Compra compra) {
		historicoCompra.add(compra);
	}

	/**
	 * @return histórico de vendas realizadas pela unidade administrativa
	 */
	public List<Venda> getHistoricoVenda() {
		return historicoVenda;
	}

	/**
	 * Adiciona no histórico de vendas uma nova venda efetivada
	 * @param venda Nota de venda realizada pela unidade administrativa
	 */
	public void setHistoricoVenda(Venda venda) {
		historicoVenda.add(venda);
	}
	
	/**
	 * Retorna o percentual de animais vacinados para o controle de uma determinada zoonose
	 * obrigatória, segundo a regulamentação da ANVISA.
	 * @param r			conjunto de animais do qual se deseja informações 
	 * @param doenca	nome da zoonose (doença) da qual se deseja informações
	 * @return			percentual, em número decimal, da população do rebanho que foi vacinado. 
	 */
	//Administração sanitária
	public double getPercentualVacinado(Rebanho r, String doenca) {
		return r.percentualVacinado(doenca);
	}
	
	/**
	 * Retorna o percentual de animais não vacinados para o controle de uma determinada zoonose
	 * obrigatória, segundo a regulamentação da ANVISA.
	 * @param r			conjunto de animais do qual se deseja informações 
	 * @param doenca	nome da zoonose (doença) da qual se deseja informações
	 * @return			percentual, em número decimal, da população do rebanho que não foi vacinado. 
	 */
	public double getPercentualNaoVacinado(Rebanho r, String doenca) {
		return r.percentualNaoVacinado(doenca);
	}
}
