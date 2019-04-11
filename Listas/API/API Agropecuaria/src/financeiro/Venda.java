package financeiro;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cadastro.Animal;
import cadastro.Bovino;
import cadastro.Suino;
import main.Fazenda;
import main.Rebanho;

public class Venda  {
	private Rebanho rebanhoVendido;
	private Date dataVenda;
	private double valorVenda;
	private Fazenda fazenda;
	
	public Venda(Rebanho rebanho, Date dataVenda, Fazenda fazenda) {
		this.dataVenda = dataVenda;
		this.valorVenda = rebanhoVendido.valorRebanho();
		this.fazenda = fazenda.getInstance();
		validaVenda(rebanho);
	}
	
	private void validaVenda(Rebanho rebanho) {
		rebanhoVendido = new Rebanho(new ArrayList<Animal>());
		for(Animal a: rebanho.getAnimais()) {
			if(isVenda(a))
				rebanhoVendido.getAnimais().add(a);
		}
		if(rebanhoVendido.getAnimais().isEmpty()) {}
		else {
			atualizarRebanho();
			atualizarHistorico();
		}
	}

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
	
	private void atualizarHistorico() {
		fazenda.getHistoricoVenda().add(this);
	}

	public Rebanho getRebanhoVendido() {
		return rebanhoVendido;
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	public double getValorVenda() {
		return valorVenda;
	}
	
	
}
