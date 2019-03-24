/**
 * 
 */
package br.com.fatec.modelo;

/**
 * Descreve as características do pagador da conta
 * @author Natalia Gonçalves
 * @version 1.0 (Mar 17 2019)
 *
 */
public class Pagador {
	private String nome;
	private String cpf;
	
	public Pagador(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	@Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null) return false;
        if(getClass() != o.getClass()) return false;
        Pagador other = (Pagador) o;
        
        //comparação dos nomes
        
        if(this.nome == null){
            if(other.nome != null) return false;
        }
        else if(other.nome == null) return false;
        else if (!this.nome.equals(other.nome)) return false;
        
        //comparação dos cpfs
        
        if(this.cpf == null){
            if(other.cpf != null) return false;
        }
        else if(other.cpf == null) return false;
        else if (!this.cpf.equals(other.cpf)) return false;
        return true;
    }
	
}
