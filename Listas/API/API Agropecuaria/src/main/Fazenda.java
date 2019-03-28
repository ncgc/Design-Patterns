package main;

public class Fazenda {
	
	private static Fazenda uniqueInstance;
	private RebanhoBovino bovino;
	private RebanhoSuino suino;
	
	private Fazenda() {	}
	
	public static Fazenda getInstance() {
		if(uniqueInstance == null)
			uniqueInstance = new Fazenda();
		return uniqueInstance;
	}
	
	public double totalAnimais() {
		return bovino.qtdAnimais() + suino.qtdAnimais();
	}

	public double valorAtivo() {
		return suino.valorRebanho() + bovino.valorRebanho();
	}
	
	public RebanhoBovino getRebanhoBovino() {
		return bovino;
	}
	
	public RebanhoSuino getRebanhoSuino() {
		return suino;
	}
	
	
	
	

}
