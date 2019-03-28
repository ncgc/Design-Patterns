package main;

import java.util.List;

import cadastro.Animal;
import cadastro.Genero;
import pesagem.ConversorPeso;

public abstract class Rebanho {
	private List<Animal> animais;
	
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
	
	public double pesoTotal() {
		int count = 0;
		for(Animal a: animais) { 
			ConversorPeso peso = a.getPeso();
			count += peso.getPesoKilo();
		}
		return count;
	}
	
	public double valorRebanho() {
		int count = 0;
		for(Animal a: animais) {
			count += a.getPreco();
		}
		return count;
	}
}
