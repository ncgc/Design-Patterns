
public class CalculadorDeImpostos {
	public void realizaCalculo(Orcamento orcamento, Imposto imposto) {
		double i = imposto.calcula(orcamento);
		System.out.println(i);
	}
}
