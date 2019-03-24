package br.com.fatec.pagamento;

import br.com.fatec.modelo.Pagador;

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
	
	@Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null) return false;
        if(getClass() != o.getClass()) return false;
        PagamentoBoleto other = (PagamentoBoleto) o;
        
        //comparação dos boletos
        
        if(this.numeroBoleto == null){
            if(other.numeroBoleto != null) return false;
        }
        else if(other.numeroBoleto == null) return false;
        else if (!this.numeroBoleto.equals(other.numeroBoleto)) return false;
        
        //comparação dos pagadores
        
        if(this.pagador == null){
            if(other.pagador != null) return false;
        }
        else if(other.pagador == null) return false;
        else if (!this.pagador.equals(other.pagador)) return false;
        return true;
    }

}
