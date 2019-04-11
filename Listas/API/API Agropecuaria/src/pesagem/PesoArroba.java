package pesagem;

/**
 * @author natalia
 * Informa o peso do animal em arroba
 */
public class PesoArroba implements ConversorPeso {
	private double pesoA;

	public PesoArroba(double pesoArroba) {
		this.pesoA = pesoArroba;
	}
	
	/**
	 * @return converte o peso para kg
	 */
	@Override
	public double getPesoKilo() {
		return pesoA * 14.689;
	}
	
	/**
	 * @return retorna o peso em arrobas
	 */
	@Override
	public double getPesoArroba() {
		return pesoA;
	}

		
}
