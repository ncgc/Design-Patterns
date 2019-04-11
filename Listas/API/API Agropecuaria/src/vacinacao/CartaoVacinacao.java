package vacinacao;

import java.util.ArrayList;

import cadastro.Animal;
import cadastro.Bovino;
import cadastro.Suino;

/**
 * @author natalia
 * Mant�m registros de vacina��o de um animal
 * @see ItemCartaoVacinacao
 */
public class CartaoVacinacao {
	private ArrayList<ItemCartaoVacinacao> planoVacinacao;
	private ArrayList<Vacinacao> vacinasObrigatorias;
	private Animal animal;
	
	public CartaoVacinacao(Animal animal) {
		this.animal = animal;
		this.vacinasObrigatorias = new ArrayList<Vacinacao>();
		this.planoVacinacao = new ArrayList<ItemCartaoVacinacao>();
		criarCartaoVacinacao();
	}
	
	/**
	 * Cria��o de um cart�o de vacina��o conforme regulamenta��o.
	 */
	private void criarCartaoVacinacao() {
		setVacinasObrigatorias();
		setPlanoVacinacao();			
	}
	/**
	 * Seleciona dentre a lista de vacina��o obrigat�ria do tipo de animal (bovino/su�no)
	 * aquelas que devem ser aplicadas, considerando o g�nero de um animal (f�mea, macho).
	 */
	private void setVacinasObrigatorias() {
		if(animal instanceof Bovino) {
			VacinacaoBovina vb = VacinacaoBovina.getVacinacaoBovina();
			for(Vacinacao v :vb.getAnvisa()) {
				if(v.getGenero().contains(animal.getGenero())) {
					this.vacinasObrigatorias.add(v);
				}
			}
		}
		if(animal instanceof Suino) {
			VacinacaoSuina vs = VacinacaoSuina.getVacinacaoSuina();
			this.vacinasObrigatorias = (ArrayList<Vacinacao>) vs.getAnvisa();
		}
			
	}

	/**
	 * Para a lista de vacina��o obrigat�ria determinar os itens de controle da vacina��o
	 * @see ItemCartaoVacinacao
	 */
	private void setPlanoVacinacao() {
		if(vacinasObrigatorias == null);
		else {
			for(Vacinacao v: vacinasObrigatorias) {
				planoVacinacao.add(new ItemCartaoVacinacao(animal, v));
			}
		}
	}
	
	/**
	 * @return lista de vacinas obrigat�rios para uma animal
	 */
	public ArrayList<Vacinacao> getVacinasObrigatorias(){
		return this.vacinasObrigatorias;
	}
	
	/**
	 * @return controle da vacina��o de um animal
	 * @see ItemCartaoVacinacao
	 */
	public ArrayList<ItemCartaoVacinacao> getPlanoVacinacao(){
		return this.planoVacinacao;
	}
	
}
