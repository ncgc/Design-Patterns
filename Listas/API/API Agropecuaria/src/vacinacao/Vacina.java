package vacinacao;

public class Vacina {
	private String descricao;
	private boolean status;
	private int animal;
	
	public Vacina(String descricao, boolean status, int animal) {
		this.descricao = descricao;
		this.status = status;
		this.animal = animal;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getAnimal() {
		return animal;
	}

	public void setAnimal(int animal) {
		this.animal = animal;
	}
	
}
