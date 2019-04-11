package pesagem;

/**
 * 
 * @author natalia 
 * Informa o peso do animal em kilos
 */
public class PesoKilo implements ConversorPeso{
	private double pesoK;

	public PesoKilo(double pesoK) {
		this.pesoK = pesoK;
	}

	/**
	 * @return retorna o peso em kilos
	 */
	@Override
	public double getPesoKilo() {
		return pesoK;
	}

	/**
	 * @return converte o peso em arrobas
	 */
	@Override
	public double getPesoArroba() {
		return pesoK/14.689;
	}
	
	
	
}
