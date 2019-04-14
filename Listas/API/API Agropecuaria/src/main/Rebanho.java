package main;

import java.util.ArrayList;
import java.util.List;

import cadastro.Animal;
import cadastro.Genero;
import pesagem.ConversorPeso;
import pesagem.PesoKilo;
import vacinacao.ItemCartaoVacinacao;
import vacinacao.Status;
import vacinacao.Vacinacao;

/**
 * @author natalia
 * Classe para agrupamento de um conjunto de animais de um mesmo tipo 
 * do qual se deseja informações da população 
 */
public class Rebanho {
	private ArrayList<Animal> animais;
	
	/**
	 * @param animais animais pertencentes ao rebanho
	 */
	public Rebanho(ArrayList<Animal> animais) {
		this.animais = animais;
	}

	/**
	 * @return lista do conjunto de animais do rebanho
	 */
	public List<Animal> getAnimais() {
		return animais;
	}
	
	/**
	 * @return quantidade de aniamis pertencentes ao rebanho
	 */
	public int qtdAnimais() {
		return animais.size();
	}
	
	/**
	 * @param g 	gênero do animal (macho/fêmea)
	 * @return		quantidade de animais do rebanho que possuem o mesmo gênero especificado
	 */
	public int calculaGenero(Genero g) {
		int count = 0;
		for(Animal a: animais) {
			if(a.getGenero() == g) count++;
		}
		return count;	
	}
	
	/**
	 * @return soma dos pesos dos animais pertencente ao rebanho (em kilos)
	 */
	public double pesoTotalKg() {
		int count = 0;
		for(Animal a: animais) { 
			ConversorPeso peso = a.getPeso();
			count += peso.getPesoKilo();
		}
		return count;
	}
	
	/**
	 * 
	 * @return soma dos pesos dos animais pertencente ao rebanho (em arrobas)
	 */
	public double pesoTotalArroba() {
		ConversorPeso peso = new PesoKilo(pesoTotalKg());
		return peso.getPesoArroba();
	}
	
	/**
	 * @return soma dos valores dos animais pertencentes ao rebanho
	 */
	public double valorRebanho() {
		double count = 0;
		for(Animal a: animais) {
			count += a.getPreco();
		}
		return count;
	}
	
	/**
	 * @param doenca	nome da zoonose a ser pesquisada
	 * @return			percentual, em decimais, do total de animais de um rebanho vacinados para essa zoonose.
	 */
	public double percentualVacinado(String doenca) {
		int count = 0;
		for(Animal a: animais) {
			ArrayList<ItemCartaoVacinacao> cartao = a.getCartaoVacinacao();
			for(ItemCartaoVacinacao item: cartao) {
				Vacinacao vItem = item.getVacinacao();
				doenca = doenca.toLowerCase();
				String vDoenca = vItem.getDoença().toLowerCase();
				if(vDoenca.equals(doenca)) {
					if(item.getStatus().equals(Status.APLICADA)){
						count+=1;
					}
				}
			}
		}
		return count/animais.size();
	}
	
	/**
	 * @param doenca	nome da zoonose a ser pesquisada
	 * @return			percentual, em decimais, do total de animais de um rebanho não vacinados para essa zoonose.
	 */
	public double percentualNaoVacinado(String doenca) {
		return 1 - percentualVacinado(doenca);
	}

	/**
	 * @param rebanhoComprado inclusão ao rebanho dos animais comprados
	 */
	public void addRebanho(List<Animal> rebanhoComprado) {
		animais.addAll(rebanhoComprado);
	}
	
	/**
	 * @param rebanhoVendido remoção do rebanho dos animais vendidos
	 */
	public void removeRebanho(List<Animal> rebanhoVendido) {
		animais.removeAll(rebanhoVendido);
	}
	
}
