package br.com.fatec.main;

public class Cartao {
	private String numeroCartao;
	private String nomeTitular;
	
	public Cartao(String numeroCartao, String nomeTitular) {
		this.numeroCartao = numeroCartao;
		this.nomeTitular = nomeTitular;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public String getNomeTitular() {
		return nomeTitular;
	}

}
