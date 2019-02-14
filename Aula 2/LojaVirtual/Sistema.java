public class sistema{

    public static void main(String[] args) {
        Desconto d = new Desconto(100);
        Produto p1 = new Produto("Notebook", 2000, d);
        System.out.println("Valor de venda:" + p1.valor());
    }
}
