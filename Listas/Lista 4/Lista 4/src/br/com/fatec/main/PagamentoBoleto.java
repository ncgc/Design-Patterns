package br.com.fatec.main;

public class PagamentoBoleto extends Pagamento{
	private String numeroBoleto;
	
	public PagamentoBoleto(String bancoRecebimento, String bancoPagamento, Pagador pagador, String dataHora,
			double valor, String numeroBoleto) {
		super(bancoRecebimento, bancoPagamento, pagador, dataHora, valor);
		this.numeroBoleto = numeroBoleto;
	}

	public String getNumeroBoleto() {
		return numeroBoleto;
	}


}
