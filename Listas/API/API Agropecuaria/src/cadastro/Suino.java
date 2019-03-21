package cadastro;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Suino extends Animal{
	private static final AtomicInteger count = new AtomicInteger(150000);
	private final int suinoID;
	

	public Suino(double peso, String raca, Genero genero, Date dataNascimento) {
		super(peso, raca, genero, dataNascimento);
		suinoID = count.incrementAndGet();
	}

}
