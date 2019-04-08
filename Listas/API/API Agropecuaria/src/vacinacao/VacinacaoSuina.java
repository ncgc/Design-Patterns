package vacinacao;

import java.util.ArrayList;
import java.util.List;

public class VacinacaoSuina {
	private List<Vacinacao> anvisa;
	private static VacinacaoSuina uniqueInstance;
	
	private VacinacaoSuina() {
		anvisa = new ArrayList<Vacinacao>();
		construirLista();
	}
	
	public static VacinacaoSuina getVacinacaoSuina() {
		if(uniqueInstance == null)
			uniqueInstance = new VacinacaoSuina();
		return uniqueInstance;
	}
	
	/**
	 * Popula a lista com as vacinações obrigatórias inicialmente cadastradas
	 */
	private void construirLista(){
		
		Vacinacao doencaAujeszky = new Vacinacao("Doença de Aujeszky");
		doencaAujeszky.setIdadeMinima(65/30);
		doencaAujeszky.setInveraloAplicacao(6);
		
		Vacinacao erisipela = new Vacinacao("Erisipela");
		erisipela.setIdadeMinima(1);
		erisipela.setInveraloAplicacao(6);
		
		Vacinacao leptospirose = new Vacinacao("Leptospirose");
		leptospirose.setIdadeMinima(1);
		leptospirose.setInveraloAplicacao(6);
		
		Vacinacao parvovirose = new Vacinacao("Parvovirose");
		parvovirose.setIdadeMinima(1);
		parvovirose.setInveraloAplicacao(6);
		
		Vacinacao peste = new Vacinacao("Peste Suína");
		peste.setIdadeMinima(65/30);
		
		anvisa.add(peste);
		anvisa.add(parvovirose);
		anvisa.add(leptospirose);
		anvisa.add(erisipela);
		anvisa.add(doencaAujeszky);
	}
	
	/**
	 * @param v 	Vacinação a ser adicionada
	 */
	public void addVacinacao(Vacinacao v) {
		if(anvisa.contains(v));
		else anvisa.add(v);
	}

	/**
	 * @param v		Vacinação a ser removida
	 */
	public  void  removeVacinacao(Vacinacao v) {
		if(anvisa.contains(v)) anvisa.remove(v);
	}
	
	public List<Vacinacao> getAnvisa(){
		return anvisa;
	}

}
