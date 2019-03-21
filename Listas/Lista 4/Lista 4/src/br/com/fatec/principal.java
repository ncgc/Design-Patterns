package br.com.fatec;

import java.util.ArrayList;

public class principal {

	
	public static void main(String[] args) {
		
		FileJSON f = new FileJSON("C:\\Users\\natal\\Documents\\2019.1\\Padrões de projeto\\Design-Patterns\\Lista 4\\Lista 4\\src\\br\\com\\fatec\\remessa.json");
		ArrayList<Pagamento> pagamentos = f.leitura();
		
		FileXML x = new FileXML("C:\\Users\\natal\\Documents\\2019.1\\Padrões de projeto\\Design-Patterns\\Lista 4\\Lista 4\\src\\br\\com\\fatec\\remessa.xml");
		System.out.println(x.leitura().get(0));	
	}		
			
			
	
}
