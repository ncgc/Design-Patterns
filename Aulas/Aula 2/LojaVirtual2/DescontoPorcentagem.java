public class DescontoPorcentagem implements Desconto{
    public double valorProduto;
    public double valorDesconto;
    public double percentual;

    public DescontoPorcentagem(double percentual){
        this.percentual = percentual;
    }

    @Override
    public double valorDesconto(){
        return (valorDesconto/100);
    }
}