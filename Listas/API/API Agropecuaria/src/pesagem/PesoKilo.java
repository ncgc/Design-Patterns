package cadastro;

public class PesoKilo{
	private double pesoK;

	public PesoKilo(double pesoA) {
		this.pesoK = pesoA * 14.689;
	}
	
	public double pesoKilo() {
		return pesoK;
	}
	
}
