public class Produto{
    public String nome;
    public double preco;
    
    CalculadorPreco calcValor;
   
    public Produto(String nome, double preco, Desconto desconto){
        this.nome = nome;
        this.preco = preco;
        calcValor = new CalculadorPreco(this, desconto);
    }

    public double valor(){
        return calcValor.calcularValor();
    }

}