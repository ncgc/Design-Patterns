public class sistema{

    public static void main(String[] args) {
        Desconto d1 = new DescontoDinheiro(100);
        Produto p1 = new Produto("Notebook", 2000, d1);
        System.out.println("Valor de venda:" + p1.valor());

        Desconto d2 = new DescontoPorcentagem(15);
        Produto p2 = new Produto("Notebook", 2000, d2);
        System.out.println("Valor de venda:" + p2.valor());

    }
}
