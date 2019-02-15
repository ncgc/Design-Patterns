
public class TesteDeImpostos {

	public static void main(String[] args) {
		Imposto iss = new ISS();
		Imposto icms = new ICMS();
		
		Orcamento orcamento = new Orcamento(500.00);
		CalculadorDeImpostos calc = new CalculadorDeImpostos();
		
		calc.realizaCalculo(orcamento, iss);
		calc.realizaCalculo(orcamento, icms);

	}

}
