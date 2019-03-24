package br.com.fatec.pagamento;

import br.com.fatec.modelo.Cartao;
import br.com.fatec.modelo.Pagador;

public class PagamentoCartao  extends Pagamento{
	private Cartao cartao;
	private int parcelas;
	private Forma modo;
	
	
	public PagamentoCartao(String bancoRecebimento, String bancoPagamento, Pagador pagador, String dataHora,
			double valor, Cartao cartao, int parcelas) {
		super(bancoRecebimento, bancoPagamento, pagador, dataHora, valor);
		this.cartao = cartao;
		this.parcelas = parcelas;
		this.modo = setModo();
	}

	public int getParcelas() {
		return parcelas;
	}
	
	public Forma isModo() {
		return modo;
	}
	public Forma setModo() {
		if(parcelas == 0)
			return Forma.DEBITO;
		else
			return Forma.CREDITO;
	}
	
	public Cartao getCartao() {
		return cartao;
	}

	public Forma getModo() {
		return modo;
	}

	@Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null) return false;
        if(getClass() != o.getClass()) return false;
        PagamentoCartao other = (PagamentoCartao) o;
        
        //comparação dos cartões
        
        if(this.cartao == null){
            if(other.cartao != null) return false;
        }
        else if(other.cartao == null) return false;
        else if (!this.cartao.equals(other.cartao)) return false;
        
        //comparação dos pagadores
        
        if(this.pagador == null){
            if(other.pagador != null) return false;
        }
        else if(other.pagador == null) return false;
        else if (!this.pagador.equals(other.pagador)) return false;
        return true;
    }

}
