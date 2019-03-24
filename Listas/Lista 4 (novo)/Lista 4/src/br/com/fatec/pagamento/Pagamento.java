package br.com.fatec.pagamento;

import br.com.fatec.modelo.Pagador;

/**
 *Implementa os dados básicos de uma pagamento
 *@author Natalia Gonçalves
 *@version 1.0 (Mar 24 2019) 
 */

public class Pagamento {
	protected String bancoRecebimento;
	protected String bancoPagamento;
	protected Pagador pagador;
	protected String dataHora;
	protected double valor;
	
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
