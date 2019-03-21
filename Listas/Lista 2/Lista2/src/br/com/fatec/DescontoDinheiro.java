package br.com.fatec;

public class DescontoDinheiro implements Desconto{
	  public double valorDesconto;
	    
	    public DescontoDinheiro(double valor){
	        this.valorDesconto = valor;
	    }

	    public double valorDesconto(){
	        return valorDesconto;
	    }
}
