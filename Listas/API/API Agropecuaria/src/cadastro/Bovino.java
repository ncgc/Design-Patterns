package cadastro;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Bovino extends Animal {
	private static final AtomicInteger count = new AtomicInteger(0);
	private final int bovinoID;
	
	public Bovino(double peso, String raca, Genero genero, Date dataNascimento) {
		super(peso, raca, genero, dataNascimento);
		bovinoID = count.incrementAndGet(); 
	}

}
