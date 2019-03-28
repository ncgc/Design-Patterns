package financeiro;

import main.Rebanho;

public interface Transacao {
	
	public void compraAnimal(Rebanho rebanhoComprado);
	public void vendaAnimal(Rebanho rebanhoVendido);
	
}
