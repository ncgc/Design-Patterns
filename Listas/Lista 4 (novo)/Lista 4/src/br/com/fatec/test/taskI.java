package br.com.fatec.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;

import br.com.fatec.main.FileJSON;
import br.com.fatec.main.FileXML;
import br.com.fatec.modelo.Cartao;
import br.com.fatec.modelo.Pagador;
import br.com.fatec.pagamento.Pagamento;
import br.com.fatec.pagamento.PagamentoBoleto;
import br.com.fatec.pagamento.PagamentoCartao;

class taskI {

	@Disabled
	@Test
	@DisplayName("Deve retornar uma mensagem de erro se o arquivo JSON não encontrado")
	void test1() {
		String filePath = new File("").getAbsolutePath();
		filePath.concat("..\\src\\br\\com\\fatec\\remessa.json");
		FileJSON json = new FileJSON(filePath);
		
		assertThrows(FileNotFoundException.class, () -> {
		    json.lerArquivo();
		  });
	}
	
	@Disabled
	@Test
	@DisplayName("Deve retornar ler o arquivo JSON")
	void test2() throws FileNotFoundException {
		String filePath = new File("").getAbsolutePath();
		filePath = filePath.concat("\\src\\arquivos\\remessa.json");
		FileJSON json = new FileJSON(filePath);
		json.lerArquivo();
		JSONArray jA = json.getLeitura();
		
		assertNotNull(jA);
	}
	
	@Disabled
	@Test
	@DisplayName("Deve converter o arquivo JSON em uma lista de pagamentos")
	void test3() throws FileNotFoundException {
		String filePath = new File("").getAbsolutePath();
		filePath = filePath.concat("\\src\\arquivos\\remessa.json");
		FileJSON json = new FileJSON(filePath);
		json.lerArquivo();
		
		ArrayList<Pagamento> pagamentos = json.recuperarPagamento();
		int fim = pagamentos.size()-1;
		
		Pagador pagadori = new Pagador("Sandoval Félix","52147655106"); 
		Cartao cartao =  new Cartao("59105948", "CECÍLIA CASTELHANO");
		PagamentoCartao pi = new PagamentoCartao("Banco Safra", "Itaú",pagadori, "Sep 1, 2018 11:54:13 PM",366.3654500816, cartao , 7);
		
		Pagador pagadorf = new Pagador("Elsa Piratininga", "87478000207");
		PagamentoBoleto pf = new PagamentoBoleto("Santander", "Banco do Brasil", pagadorf,"Sep 1, 2018 11:54:13 PM",281.75865414362704, "56356851");
		
		assertEquals(pagamentos.get(0), pi);
		assertEquals(pagamentos.get(fim), pf);
		
	}
	
	@Disabled
	@Test
	@DisplayName("Deve retornar uma mensagem de erro se o arquivo XML não encontrado")
	void test4() {
		String filePath = new File("").getAbsolutePath();
		filePath = filePath.concat("..\\src\\br\\com\\fatec\\remessa.xml");
		FileXML xml = new FileXML(filePath);
		
		assertThrows(IOException.class, () -> {
		    xml.lerArquivo();
		  });
	}
	
	@Disabled
	@Test
	@DisplayName("Deve retornar ler o arquivo XML")
	void test5() throws IOException {
		String filePath = new File("").getAbsolutePath();
		filePath = filePath.concat("\\src\\arquivos\\remessa.xml");
		FileXML xml = new FileXML(filePath);
		xml.lerArquivo();
		Document doc = xml.getDoc();
		
		assertNotNull(doc);
	}
	
	@Test
	@DisplayName("Deve converter o arquivo XML em uma lista de pagamentos")
	void test6() throws IOException {
		String filePath = new File("").getAbsolutePath();
		filePath = filePath.concat("\\src\\arquivos\\remessa.xml");
		FileXML xml = new FileXML(filePath);
		xml.lerArquivo();
		
		ArrayList<Pagamento> pagamentos = xml.recuperarPagamento();
		int fim = pagamentos.size()-1;
		
		Pagador pagadori = new Pagador("Sandoval Félix","87478000207");
		Pagamento pi = new PagamentoBoleto("Banco do Brasil","Bradesco", pagadori,"2018-09-02 02:58:10.96 UTC", 328.8093068652568, "88604651");
		
		Pagador pagadorf = new Pagador("Viriato Ayres","52147655106");
		Cartao cartaof = new Cartao("56555327", "LAÍS FELGUEIRAS");
		Pagamento pf = new PagamentoCartao("Itaú", "Caixa Econômica", pagadorf,"2018-09-02 02:58:10.96 UTC", 439.0602889262974, cartaof, 9);
		
		assertEquals(pagamentos.get(0), pi);
		assertEquals(pagamentos.get(fim), pf);
	}
	
	
	

}
