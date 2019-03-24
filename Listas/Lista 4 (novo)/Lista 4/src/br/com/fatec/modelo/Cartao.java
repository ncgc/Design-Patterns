
package br.com.fatec.modelo;

/**
 * Descreve as características de um cartão bancário
 * @author Natalia Gonçalves
 * @version 1.0 (Mar 17 2019)
 *
 */
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
	
	@Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null) return false;
        if(getClass() != o.getClass()) return false;
        Cartao other = (Cartao) o;
        
        //comparação de titulares
        
        if(this.nomeTitular == null){
            if(other.nomeTitular != null) return false;
        }
        else if(other.nomeTitular == null) return false;
        else if (!this.nomeTitular.equals(other.nomeTitular)) return false;
        
        //comparação dos numeros
        
        if(this.numeroCartao == null){
            if(other.numeroCartao != null) return false;
        }
        else if(other.numeroCartao == null) return false;
        else if (!this.numeroCartao.equals(other.numeroCartao)) return false;
        return true;
    }
}
