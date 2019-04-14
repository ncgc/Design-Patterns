package main;

import java.util.ArrayList;
import java.util.List;

import cadastro.Animal;
import cadastro.Bovino;
import cadastro.Genero;
import financeiro.Compra;
import financeiro.Venda;

public class Fazenda {
	
	private static Fazenda uniqueInstance;
	private  Rebanho bovino;
	private  Rebanho suino;
	private List<Compra> historicoCompra;
	private List<Venda> historicoVenda;

	
	private Fazenda() {
		this.bovino = new Rebanho(new ArrayList<Animal>());
		this.suino = new Rebanho(new ArrayList<Animal>());
		this.historicoCompra = new ArrayList<>();
		this.historicoVenda= new ArrayList<>();
	}
	
	public static Fazenda getInstance() {
		if(uniqueInstance == null)
			uniqueInstance = new Fazenda();
		return uniqueInstance;
	}
	
	// Administração populacional
	public double totalAnimais() {
		return bovino.qtdAnimais() + suino.qtdAnimais();
	}
	
	public Rebanho getRebanhoBovino() {
		return bovino;
	}
	
	public Rebanho getRebanhoSuino() {
		return suino;
	}
	
	public int getQuantidadeGenero(Rebanho r, Genero g) {
		return r.calculaGenero(g);
	}
	
	public void nascimento(Animal a) {
		if(a instanceof Bovino) {
			bovino.getAnimais().add(a);
		}
		else {
			suino.getAnimais().add(a);
		}
	}
	
	public void morte(Animal a) {
		if(a instanceof Bovino) {
			bovino.getAnimais().remove(a);
		}
		else {
			suino.getAnimais().remove(a);
		}
	}
	
	public double getPesoTotal(Rebanho r, String unPeso) {
		if(unPeso.toLowerCase().equals("kilo"))
			return r.pesoTotalKg();
		return r.pesoTotalArroba();
	}
	
	//Administração financeira
	public double valorAtivo() {
		return suino.valorRebanho() + bovino.valorRebanho();
	}
	
	public void compraRebanho(Rebanho rAtual, Rebanho rComprado) {
		rAtual.addRebanho(rComprado.getAnimais());
	}
	
	public void vendaRebanho(Rebanho rAtual, Rebanho rVendido) {
		rAtual.removeRebanho(rVendido.getAnimais());
	}

	public List<Compra> getHistoricoCompra() {
		return historicoCompra;
	}

	public void setHistoricoCompra(Compra compra) {
		historicoCompra.add(compra);
	}

	public List<Venda> getHistoricoVenda() {
		return historicoVenda;
	}

	public void setHistoricoVenda(Venda venda) {
		historicoVenda.add(venda);
	}
	
	
	//Administração sanitária
	public double getPercentualVacinado(Rebanho r, String doenca) {
		return r.percentualVacinado(doenca);
	}
	
	public double getPercentualNaoVacinado(Rebanho r, String doenca) {
		return r.percentualNaoVacinado(doenca);
	}
}
