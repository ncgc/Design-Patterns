package br.com.fatec;

public abstract class Pagamento {
	private String bancoRecebimento;
	private String bancoPagamento;
	private Pagador pagador;
	private String dataHora;
	private double valor;
	
	public Pagamento(String bancoRecebimento, String bancoPagamento, Pagador pagador, String dataHora, double valor) {
		this.bancoRecebimento = bancoRecebimento;
		this.bancoPagamento = bancoPagamento;
		this.pagador = pagador;
		this.dataHora = dataHora;
		this.valor = valor;
	}

	public String getBancoRecebimento() {
		return bancoRecebimento;
	}

	public String getBancoPagamento() {
		return bancoPagamento;
	}

	public Pagador getPagador() {
		return pagador;
	}

	public String getDataHora() {
		return dataHora;
	}

	public double getValor() {
		return valor;
	}
	
}
