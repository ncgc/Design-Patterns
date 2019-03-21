package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.fatec.Desconto;
import br.com.fatec.DescontoDinheiro;
import br.com.fatec.DescontoPorcentagem;
import br.com.fatec.Produto;

class test {

	@Test
	@DisplayName("Deve calcular preco do produto com desconto em porcentagem")
	void test1() {
		Desconto d = new DescontoPorcentagem(5.0);
		
		Produto p1 = new Produto("Jeans", 120.00, d);
		
		assertEquals(p1.valorComDesconto(), 114.00, 0.0001);
		
	}
	
	@Test
	@DisplayName("Deve calcular preco do produto com desconto em dinheiro")
	void test2() {
		Desconto d = new DescontoDinheiro(15.30);
		
		Produto p1 = new Produto("Jeans", 120.00, d);
		
		assertEquals(p1.valorComDesconto(), 104.70, 0.0001);
		
	}

}
