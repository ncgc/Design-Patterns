package br.com.fatec.main;

public class Notebook extends ProdutoUnitario{
	private String marca;
	private double peso;
	private String tamanho;
	private String modelo;
	private int memoria;
	private int hd;
	private boolean placaVideo;
	private boolean USB;
	
	public Notebook(String nome, double valor, Desconto desconto) {
		super(nome, valor, desconto);
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public void setMemoria(int memoria) {
		this.memoria = memoria;
	}

	public void setHd(int hd) {
		this.hd = hd;
	}

	public void setPlacaVideo(boolean placaVideo) {
		this.placaVideo = placaVideo;
	}

	public void setUSB(boolean uSB) {
		USB = uSB;
	}

	public String getMarca() {
		return marca;
	}

	public double getPeso() {
		return peso;
	}

	public String getTamanho() {
		return tamanho;
	}

	public String getModelo() {
		return modelo;
	}

	public int getMemoria() {
		return memoria;
	}

	public int getHd() {
		return hd;
	}

	public boolean isPlacaVideo() {
		return placaVideo;
	}

	public boolean isUSB() {
		return USB;
	}
	
}
