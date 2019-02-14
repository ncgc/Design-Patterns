import java.util.Date;

public class Pessoa {
    public Date dataNasc;
    CalculadorTempo calcTempo;

    public Pessoa(){
        calcTempo = new CalculadorTempo();
    }
}