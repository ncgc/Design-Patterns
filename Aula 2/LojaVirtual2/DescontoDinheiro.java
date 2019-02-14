public class DescontoDinheiro implements desconto{
    public double valorDesconto;
    
    public DescontoValor(double valor){
        this.valorDesconto = valor;
    }

    @Override
    public double valorDesconto(){
        return valorDesconto;
    }
}