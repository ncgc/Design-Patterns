package main;

import java.util.ArrayList;
import java.util.List;

import cadastro.Bovino;
import financeiro.Transacao;

public class RebanhoBovino extends Rebanho implements Transacao{
	private List<Bovino> animais = new ArrayList<>();
	
	public RebanhoBovino(List<Bovino> animais) {
		this.animais.addAll(animais);
	}

	public List<Bovino> getAnimais() {
		return animais;
	}

	@Override
	public void compraAnimal(Rebanho rebanhoComprado) {
		this.animais.addAll(((RebanhoBovino) rebanhoComprado).getAnimais());
	}

	@Override
	public void vendaAnimal(Rebanho rebanhoVendido) {
		this.animais.removeAll(((RebanhoBovino) rebanhoVendido).getAnimais());
	}

}
