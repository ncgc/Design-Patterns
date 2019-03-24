package br.com.fatec.main;

import org.json.simple.JSONObject;

import br.com.fatec.modelo.Cartao;
import br.com.fatec.modelo.Pagador;
import br.com.fatec.pagamento.PagamentoBoleto;
import br.com.fatec.pagamento.PagamentoCartao;

public class JSONtoPagamento{
	private JSONObject jO;

	public JSONtoPagamento(JSONObject jO) {
		this.jO = jO;
	}
	
	public PagamentoBoleto converteBoleto() {
		String nome = (String) jO.get("nome");
		String cpf = (String) jO.get("CPF");
		Pagador pagador = new Pagador(nome,cpf);
		String bancoRecebimento = (String) jO.get("bancoRecebimento");
		String bancoPagamento = (String) jO.get("bancoPagamento");
		String dataHora = (String) jO.get("data");
		double valor = (double) jO.get("valor");
		String numeroBoleto = (String) jO.get("numeroBoleto");
		return new PagamentoBoleto(bancoRecebimento, bancoPagamento, pagador, dataHora, valor, numeroBoleto);
	}

	public PagamentoCartao converteCartao() {
		String nome = (String) jO.get("nome");
		String cpf = (String) jO.get("CPF");
		Pagador pagador = new Pagador(nome,cpf);
		String bancoRecebimento = (String) jO.get("bancoRecebimento");
		String bancoPagamento = (String) jO.get("bancoPagamento");
		String dataHora = (String) jO.get("data");
		double valor = (double) jO.get("valor");
		String numeroCartao = (String) jO.get("numeroCartao");
		String nomeTitular = (String) jO.get("nomeTitular");
		Cartao cartao = new Cartao(numeroCartao, nomeTitular);
		int parcelas;
		if(jO.containsKey("parcelas"))
			parcelas = (int)(long) jO.get("parcelas");
		else {
			parcelas = 0;
		}
		return new PagamentoCartao(bancoRecebimento, bancoPagamento, pagador, dataHora, valor, cartao, parcelas);
	}
	
}
