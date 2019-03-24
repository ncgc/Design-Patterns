package br.com.fatec.main;

public class DescontoDinheiro implements Desconto{
	 public double valorDesconto;

	 public DescontoDinheiro(double valor){
	        this.valorDesconto = valor;
	    }

	    @Override
	    public double valorDesconto(){
	        return valorDesconto;
	    }
}
