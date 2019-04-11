package pesagem;

public class PesoKilo implements ConversorPeso{
	private double pesoK;

	public PesoKilo(double pesoK) {
		this.pesoK = pesoK;
	}

	@Override
	public double getPesoKilo() {
		return pesoK;
	}

	@Override
	public double getPesoArroba() {
		return pesoK/14.689;
	}
	
	
	
}
