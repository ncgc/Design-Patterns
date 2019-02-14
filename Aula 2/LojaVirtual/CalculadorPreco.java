public class CalculadorPreco{
    public Produto produto;
    public Desconto desconto;
    
    public  CalculadorPreco(Produto produto, Desconto desconto){
        this.produto = produto;
        this.desconto =  desconto;
    }

    public double calcularValor(){
        return produto.preco - desconto.valorDesconto;
    }
}