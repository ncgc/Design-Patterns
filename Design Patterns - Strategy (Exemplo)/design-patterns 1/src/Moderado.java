
public class Moderado implements Investimentos {

	@Override
	public double realizaInvestimento() {
		int escolhido = new java.util.Random().nextInt(2);
		if(escolhido == 0) return 0.025;
		else return 0.7;
	}
	

}
