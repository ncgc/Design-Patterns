package br.com.fatec.main;

import java.util.ArrayList;

import br.com.fatec.pagamento.Pagamento;

public abstract class RecuperaPagamentos {
	
	
	protected String cabecalho() {
		String cabecalho = "### Arquivo de envio de remessa ###";
		return cabecalho;
	}
	
	protected String rodape() {
		String rodape = "### Fim arquivo ###";
		return rodape;
	}
	
	public abstract ArrayList<Pagamento> recuperarPagamento();
	
	public void escreverArquivo() {
		System.out.println(this.cabecalho());
		
		
	}
}
