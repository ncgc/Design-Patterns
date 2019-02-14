public class DescontoPorcentagem implements Desconto{
    public double valorProduto;
    public double valorDesconto;
    public double percentual;

    public DescontoPercentual(Produto p, double percentual){
        this.valorProduto = p.preco;
        this.percentual = percentual;
    }

    @Override
    public double valorDesconto(){
        return (valorDesconto/100);
    }
}