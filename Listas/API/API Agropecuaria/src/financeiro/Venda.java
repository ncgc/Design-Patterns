package financeiro;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cadastro.Animal;
import main.Fazenda;
import main.Rebanho;
import main.RebanhoBovino;

public class Venda {
	private List<Venda> historicoVendas = new ArrayList<>();
	private Rebanho rebanhoVendido;
	private Date dataVenda;
	private double valorVenda;
	private Fazenda fazenda;
	
	public Venda(Rebanho rebanho, Date dataVenda, Fazenda fazenda) {
		this.rebanhoVendido = rebanho;
		this.dataVenda = dataVenda;
		this.valorVenda = valorTransacao();
		this.fazenda = fazenda.getInstance();
		isVenda();
	}
	
	private void isVenda() {
		boolean isVenda = true;
		if(rebanhoVendido instanceof RebanhoBovino) {
			for(Animal animal: ((RebanhoBovino) rebanhoVendido).getAnimais()) {
				
			}
		}
		
	}

	private double valorTransacao() {
		return rebanhoVendido.valorRebanho();
	}

	private void atualizarRebanho() {
		if(rebanhoVendido instanceof RebanhoBovino) {
			fazenda.getRebanhoBovino().vendaAnimal(rebanhoVendido);
		}
		else {
			fazenda.getRebanhoSuino().vendaAnimal(rebanhoVendido);
		}	
	}
}
