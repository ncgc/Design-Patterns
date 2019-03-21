package br.com.fatec;

public class DescontoPorcentagem implements Desconto{
	    public double percentual;

	    public DescontoPorcentagem(double percentual){
	        this.percentual = percentual;
	    }

	    public double valorDesconto(){
	        return (percentual/100);
	    }
}
