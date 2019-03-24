
package br.com.fatec.main;

/**
 * Classe que implementa a descricao de um notebook
 * @author Natalia Goncalves
 *
 */
public class Notebook extends ProdutoUnitario{
	private String marca;
	private double peso;
	private String tamanho;
	private String modelo;
	private int memoria;
	private int hd;
	private boolean placaVideo;
	private boolean saidaUSB;

	/**
	 * @param marca			marca do notebook
	 * @param peso			peso do notebook
	 * @param tamanho		dimens�es do notebook
	 * @param modelo		modelo do notebook
	 * @param memoria		quantidade de mem�ria do notebook( em GB)
	 * @param hd			quantidade de HD (em GB)
	 * @param placaVideo	indica se possui placa de v�deo
	 * @param saidaUSB		indica se possui sa�da USB
	 */
	public Notebook(String nome, double valor, Desconto desconto, String marca, double peso, String tamanho,
			String modelo, int memoria, int hd, boolean placaVideo, boolean saidaUSB) {
		super(nome, valor, desconto);
		this.marca = marca;
		this.peso = peso;
		this.tamanho = tamanho;
		this.modelo = modelo;
		this.memoria = memoria;
		this.hd = hd;
		this.placaVideo = placaVideo;
		this.saidaUSB = saidaUSB;
	}

	
	@Override
	public void descreverProduto() {
		System.out.println("Marca: " + this.marca);
		System.out.println("Peso: " + this.peso + " kg");
		System.out.println("Tamanho: " + this.tamanho);
		System.out.println("Modelo: " + this.modelo);
		System.out.println("Mem�ria RAM: " + this.memoria + " GB");
		System.out.println("HD: " + this.hd + " GB");
		if(this.placaVideo) System.out.println("Placa de v�deo: Sim");
		else System.out.println("Placa de v�deo: N�o");
		if(this.saidaUSB) System.out.println("USB: Sim");
		else System.out.println("USB: N�o");
	}

}
