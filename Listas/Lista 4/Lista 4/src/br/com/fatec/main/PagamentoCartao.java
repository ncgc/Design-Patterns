package br.com.fatec.main;


public class PagamentoCartao extends Pagamento{
	private Cartao cartao;
	private int parcelas;
	private Forma modo;
	
	
	public PagamentoCartao(String bancoRecebimento, String bancoPagamento, Pagador pagador, String dataHora,
			double valor, Cartao cartao, int parcelas) {
		super(bancoRecebimento, bancoPagamento, pagador, dataHora, valor);
		this.cartao = cartao;
		this.parcelas = parcelas;
	}

	public int getParcelas() {
		return parcelas;
	}
	
	public Cartao cartao() {
		return cartao;
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
