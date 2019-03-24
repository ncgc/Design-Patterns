package br.com.fatec.main;

public class DescontoPorcentagem implements Desconto{
	public double valorDesconto;
	
	public DescontoPorcentagem(double percentual) {
		this.valorDesconto = percentual;
	}
	
	public double valorDesconto() {
		return valorDesconto/100;
	}

}
