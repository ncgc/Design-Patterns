package main;

import java.util.ArrayList;
import java.util.List;

import cadastro.Animal;
import cadastro.Genero;
import pesagem.ConversorPeso;
import pesagem.PesoKilo;
import vacinacao.ItemCartaoVacinacao;
import vacinacao.Status;
import vacinacao.Vacinacao;

public class Rebanho {
	private ArrayList<Animal> animais;
	
	public Rebanho(ArrayList<Animal> animais) {
		this.animais = animais;
	}

	public List<Animal> getAnimais() {
		return animais;
	}
	
	public int qtdAnimais() {
		return animais.size();
	}
	
	public int calculaGenero(Genero g) {
		int count = 0;
		for(Animal a: animais) {
			if(a.getGenero() == g) count++;
		}
		return count;	
	}
	
	public double pesoTotalKg() {
		int count = 0;
		for(Animal a: animais) { 
			ConversorPeso peso = a.getPeso();
			count += peso.getPesoKilo();
		}
		return count;
	}
	
	public double pesoTotalArroba() {
		ConversorPeso peso = new PesoKilo(pesoTotalKg());
		return peso.getPesoArroba();
	}
	
	public double valorRebanho() {
		double count = 0;
		for(Animal a: animais) {
			count += a.getPreco();
		}
		return count;
	}
	
	public double percentualVacinado(String doenca) {
		int count = 0;
		for(Animal a: animais) {
			ArrayList<ItemCartaoVacinacao> cartao = a.getCartaoVacinacao();
			for(ItemCartaoVacinacao item: cartao) {
				Vacinacao vItem = item.getVacinacao();
				doenca = doenca.toLowerCase();
				String vDoenca = vItem.getDoença().toLowerCase();
				if(vDoenca.equals(doenca)) {
					if(item.getStatus().equals(Status.APLICADA)){
						count+=1;
					}
				}
			}
		}
		return count/animais.size();
	}
	
	public double percentualNaoVacinado(String doenca) {
		return 1 - percentualVacinado(doenca);
	}


	public void addRebanho(List<Animal> rebanhoComprado) {
		animais.addAll(rebanhoComprado);
	}
	
	public void removeRebanho(List<Animal> rebanhoVendido) {
		animais.removeAll(rebanhoVendido);
	}
	
}
