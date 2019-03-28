package main;

import java.util.ArrayList;
import java.util.List;

import cadastro.Suino;
import financeiro.Transacao;

public class RebanhoSuino extends Rebanho implements Transacao {
	private List<Suino> animais = new ArrayList<>();
	
	public RebanhoSuino(List<Suino> animais) {
		this.animais.addAll(animais);
	}

	@Override
	public void compraAnimal(Rebanho rebanhoComprado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void vendaAnimal(Rebanho rebanhoVendido) {
		// TODO Auto-generated method stub
		
	}
}
