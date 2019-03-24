package br.com.fatec.main;

import org.w3c.dom.Element;

import br.com.fatec.modelo.Cartao;
import br.com.fatec.modelo.Pagador;
import br.com.fatec.pagamento.PagamentoBoleto;
import br.com.fatec.pagamento.PagamentoCartao;

public class XMLtoPagamento {
	private Element eElement;
	
	public XMLtoPagamento(Element eElement) {
		this.eElement = eElement;
	}

	public PagamentoCartao converteCartao(int i) {
		String nome = eElement.getElementsByTagName("nome").item(i).getTextContent();
		String cpf = eElement.getElementsByTagName("CPF").item(i).getTextContent();
		Pagador pagador = new Pagador(nome, cpf);
		String bancoRecebimento = eElement.getElementsByTagName("bancoRecebimento").item(i).getTextContent();
		String bancoPagamento = eElement.getElementsByTagName("bancoPagamento").item(i).getTextContent();
		String dataHora = eElement.getElementsByTagName("data").item(i).getTextContent();
		double valor = Double.parseDouble(eElement.getElementsByTagName("valor").item(i).getTextContent());
		String numeroCartao = eElement.getElementsByTagName("numeroCartao").item(i).getTextContent();
		String nomeTitular = eElement.getElementsByTagName("nomeTitular").item(i).getTextContent();
		Cartao cartao = new Cartao(numeroCartao, nomeTitular);
		int parcelas;
		if(eElement.getElementsByTagName("parcelas").item(i) != null) {
			parcelas =  Integer.valueOf(eElement.getElementsByTagName("parcelas").item(i).getTextContent());
		}
		else {
			parcelas = 0;
		}
		return new PagamentoCartao(bancoRecebimento, bancoPagamento, pagador, dataHora, valor,cartao, parcelas);
	}
	
	public PagamentoBoleto converteBoleto(int i) {
		String nome = eElement.getElementsByTagName("nome").item(i).getTextContent();
		String cpf = eElement.getElementsByTagName("CPF").item(i).getTextContent();
		Pagador pagador = new Pagador(nome, cpf);
		String bancoRecebimento = eElement.getElementsByTagName("bancoRecebimento").item(i).getTextContent();
		String bancoPagamento = eElement.getElementsByTagName("bancoPagamento").item(i).getTextContent();
		String dataHora = eElement.getElementsByTagName("data").item(i).getTextContent();
		String numeroBoleto = eElement.getElementsByTagName("numeroBoleto").item(i).getTextContent();
		double valor = Double.parseDouble(eElement.getElementsByTagName("valor").item(i).getTextContent());
		return new PagamentoBoleto(bancoRecebimento, bancoPagamento, pagador, dataHora, valor, numeroBoleto);
	}

}
