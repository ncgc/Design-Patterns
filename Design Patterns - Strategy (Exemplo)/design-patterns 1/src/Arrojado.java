
public class Arrojado implements Investimentos{

	@Override
	public double realizaInvestimento() {
		int escolhido = new java.util.Random().nextInt(10);
		if(escolhido >=0 && escolhido <=1)
			return 0.05;
		else if(escolhido >= 2 && escolhido <= 4)
			return 0.03;
		else 
			return 0.006;
		
	}

}
