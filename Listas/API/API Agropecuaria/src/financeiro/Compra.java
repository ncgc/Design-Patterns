package financeiro;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cadastro.Animal;
import cadastro.Bovino;
import cadastro.Suino;
import main.Fazenda;
import main.Rebanho;

public class Compra {
	private Rebanho rebanhoComprado;
	private Date dataCompra;
	private double valorCompra;
	private Fazenda fazenda;
	
	public Compra(Rebanho rebanhoComprado, Date dataCompra, Fazenda fazenda) {
		this.rebanhoComprado = rebanhoComprado;
		this.dataCompra = dataCompra;
		this.valorCompra = rebanhoComprado.valorRebanho();
		this.fazenda = fazenda;
		atualizarRebanho();
		atualizarHistorico();
	}
	
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
	
	private void atualizarHistorico() {
		fazenda.getHistoricoCompra().add(this);
	}

	public Rebanho getRebanhoComprado() {
		return rebanhoComprado;
	}

	public Date getDataCompra() {
		return dataCompra;
	}

	public double getValorCompra() {
		return valorCompra;
	}
	
}
