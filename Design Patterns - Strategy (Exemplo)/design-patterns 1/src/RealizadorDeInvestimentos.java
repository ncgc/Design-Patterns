
public class RealizadorDeInvestimentos {
	public double realiza(Conta conta, Investimentos investimento) {
		return investimento.realizaInvestimento() * conta.getSaldo() * 0.75;
	}
}
