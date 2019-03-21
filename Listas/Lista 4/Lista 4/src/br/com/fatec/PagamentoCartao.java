package br.com.fatec;


public class PagamentoCartao extends Pagamento{
	private String numeroCartao;
	private String nomeTitular;
	private int parcelas;
	private Forma modo;
	
	
	public PagamentoCartao(String bancoRecebimento, String bancoPagamento, Pagador pagador, String dataHora,
			double valor, String numeroCartao, String nomeTitular, int parcelas) {
		super(bancoRecebimento, bancoPagamento, pagador, dataHora, valor);
		this.numeroCartao = numeroCartao;
		this.nomeTitular = nomeTitular;
		this.parcelas = parcelas;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public String getNomeTitular() {
		return nomeTitular;
	}

	public int getParcelas() {
		return parcelas;
	}
	
	public Forma isModo() {
		return modo;
	}
	public void setModo() {
		if(parcelas == 0)
			this.modo = Forma.DEBITO;
		else
			this.modo = Forma.CREDITO;
	}

}
