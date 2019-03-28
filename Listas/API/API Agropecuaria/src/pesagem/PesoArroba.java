package pesagem;

public class PesoArroba implements ConversorPeso {
	private double pesoA;

	public PesoArroba(double pesoArroba) {
		this.pesoA = pesoArroba;
	}
	
	@Override
	public double getPesoKilo() {
		return pesoA * 14.689;
	}

		
}
