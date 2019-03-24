package br.com.fatec.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;

import br.com.fatec.main.Cartao;
import br.com.fatec.main.FileJSON;
import br.com.fatec.main.FileXML;
import br.com.fatec.main.Pagador;
import br.com.fatec.main.Pagamento;
import br.com.fatec.main.PagamentoBoleto;
import br.com.fatec.main.PagamentoCartao;

class testLeitura {

	@Test
	@DisplayName("Deve ler o arquivo JSON")
	void test1() {
		String filePath = new File("").getAbsolutePath();
		filePath.concat("..\\src\\br\\com\\fatec\\remessa.json");
		FileJSON f = new FileJSON(filePath);
		
		ArrayList<Pagamento> pagamentos = f.leitura();
		int fim = pagamentos.size()-1;
		
		Pagador pagadori = new Pagador("Sandoval Félix","52147655106"); 
		Cartao cartao =  new Cartao("59105948", "CECÍLIA CASTELHANO");
		Pagamento pi = new PagamentoCartao("Banco Safra", "Itaú",pagadori, "Sep 1, 2018 11:54:13 PM",366.3654500816, cartao , 7);
		
		Pagador pagadorf = new Pagador("Elsa Piratininga", "87478000207");
		Pagamento pf = new PagamentoBoleto("Santander", "Banco do Brasil", pagadorf,"Sep 1, 2018 11:54:13 PM",281.75865414362704, "56356851");
		
		assertEquals(pagamentos.get(0), pi);
		assertEquals(pagamentos.get(fim), pf);
	}
	
	@Test
	@DisplayName("Deve ler o arquivo XML")
	void test2() {
		String filePath = new File("").getAbsolutePath();
		filePath.concat("..\\src\\br\\com\\fatec\\remessa.xml");
		FileXML x = new FileXML(filePath);
		
		ArrayList<Pagamento> pagamentos = x.leitura();
		int fim = pagamentos.size()-1;
		
		Pagador pagadori = new Pagador("Adelaide Carvalhaes","56608514522");
		Cartao cartaoi = new Cartao("98315792", "LIEDSON LAGO");
		Pagamento pi = new PagamentoCartao("Caixa Econômica","Banco Safra", pagadori,"2018-09-02 02:58:10.96 UTC", 362.4101749037519,cartaoi, 2);
		
		Pagador pagadorf = new Pagador("Viriato Ayres","52147655106");
		Cartao cartaof = new Cartao("56555327", "LAÍS FELGUEIRAS");
		Pagamento pf = new PagamentoCartao("Itaú", "Caixa Econômica", pagadorf,"2018-09-02 02:58:10.96 UTC", 439.0602889262974, cartaof, 9);
		
		assertEquals(pagamentos.get(0), pi);
		assertEquals(pagamentos.get(fim), pf);
	}

}

