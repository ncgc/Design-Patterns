public class Veiculo{
    protected double valorHora;
    protected double valorDiaria;
    protected double valorMensal;

    public Veiculo (double valorHora, double valorDiaria, double valorMensal){
        this.valorDiaria = valorHora;
        this.valorDiaria = valorDiaria;
        this.valorMensal = valorMensal;
    }

    /**
     * @return the valorHora
     */
    public double getValorHora() {
        return valorHora;
    }

    /**
     * @param valorHora the valorHora to set
     */
    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    /**
     * @return the valorDiaria
     */
    public double getValorDiaria() {
        return valorDiaria;
    }

    /**
     * @param valorDiaria the valorDiaria to set
     */
    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    /**
     * @return the valorMensal
     */
    public double getValorMensal() {
        return valorMensal;
    }

    /**
     * @param valorMensal the valorMensal to set
     */
    public void setValorMensal(double valorMensal) {
        this.valorMensal = valorMensal;
    }


}