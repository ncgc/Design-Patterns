package vacinacao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cadastro.Genero;
import main.Fazenda;

/**
 * @author natalia
 * Lista o esquema de vacina��o das principais doen�as infecciosas
 * de bovinos controladas por vacina��o no Brasil segundo a Anvisa.
 */
public class VacinacaoBovina {
	private List<Vacinacao> anvisa;
	private static VacinacaoBovina uniqueInstance;
	
	private VacinacaoBovina() {
		anvisa = new ArrayList<Vacinacao>();
		construirLista();
	}
	
	public static VacinacaoBovina getVacinacaoBovina() {
		if(uniqueInstance == null)
			uniqueInstance = new VacinacaoBovina();
		return uniqueInstance;
	}
	
	/**
	 * Popula a lista com as vacina��es obrigat�rias inicialmente cadastradas
	 */
	private void construirLista(){
		
		Vacinacao  febreAftosa = new Vacinacao("Febre Aftosa");
		febreAftosa.setIdadeMinima(24);
		
		Vacinacao febreAftosaInfantil = new Vacinacao("Febre Aftosa (at� 2 anos)");
		febreAftosaInfantil.setIdadeMaxima(24);
		febreAftosaInfantil.setIdadeMinima(4);
		febreAftosaInfantil.setInveraloAplicacao(6);
		
		Vacinacao brucelose = new Vacinacao("Brucelose");
		brucelose.setGenero(Arrays.asList(Genero.FEMEA));
		brucelose.setIdadeMinima(3);
		brucelose.setIdadeMaxima(8);
	
		Vacinacao raivaInfantil = new Vacinacao("Raiva - 1a dose");
		raivaInfantil.setIdadeMinima(3);
		raivaInfantil.setInveraloAplicacao(2);
		
		Vacinacao raiva = new Vacinacao("Raiva");
		raiva.setIdadeMinima(1);
		
		Vacinacao ibrInfantil = new Vacinacao("Rinotraqueite Infecciosa Bovina(IBR) - PrimoVacina��o");
		ibrInfantil.setIdadeMinima(6);
		ibrInfantil.setIdadeMaxima(7);
		
		Vacinacao ibr = new Vacinacao("Rinotraqueite Infecciosa Bovina(IBR)");
		ibr.setIdadeMinima(1);
		
		Vacinacao bvdInfantil = new Vacinacao("Diarr�ia viral bovina (BVD)- PrimoVacina��o");
		bvdInfantil.setIdadeMinima(6);
		bvdInfantil.setIdadeMaxima(7);
		
		Vacinacao bvd = new Vacinacao("Diarr�ia viral bovina (BVD)");
		bvd.setIdadeMinima(1);
		
		Vacinacao clostridioseInfantil = new Vacinacao("Clostridioses (at� 6 meses)");
		clostridioseInfantil.setIdadeMinima(2);
		clostridioseInfantil.setInveraloAplicacao(1);
		clostridioseInfantil.setIdadeMaxima(3);

		Vacinacao clostridiose = new Vacinacao("Clostridioses (ap�s 6 meses)");
		clostridiose.setIdadeMinima(12);
		
		Vacinacao botulismoInfantil = new Vacinacao("Botulismo - dose inicial");
		botulismoInfantil.setIdadeMinima(4);
		botulismoInfantil.setInveraloAplicacao(1);
		botulismoInfantil.setIdadeMaxima(5);
		
		Vacinacao botulismo = new Vacinacao("Botulismo");
		botulismo.setIdadeMinima(12);
		
		anvisa.add(clostridiose);
		anvisa.add(clostridioseInfantil);
		anvisa.add(brucelose);
		anvisa.add(febreAftosaInfantil);
		anvisa.add(febreAftosa);
		anvisa.add(botulismo);
		anvisa.add(botulismoInfantil);
		anvisa.add(bvd);
		anvisa.add(bvdInfantil);
		anvisa.add(ibr);
		anvisa.add(ibrInfantil);
		anvisa.add(raiva);
		anvisa.add(raivaInfantil);
	}

	/**
	 * @param v 	Vacina��o a ser adicionada
	 */
	public void addVacinacao(Vacinacao v) {
		if(anvisa.contains(v));
		else anvisa.add(v);
	}

	/**
	 * @param v		Vacina��o a ser removida
	 */
	public  void  removeVacinacao(Vacinacao v) {
		if(anvisa.contains(v)) anvisa.remove(v);
	}
	
	public List<Vacinacao> getAnvisa(){
		return anvisa;
	}
	
	
	


	
	
	
	
	
	
	
	
	
	
	

}
