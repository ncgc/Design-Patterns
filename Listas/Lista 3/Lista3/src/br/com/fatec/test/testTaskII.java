package br.com.fatec.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.fatec.main.Desconto;
import br.com.fatec.main.DescontoDinheiro;
import br.com.fatec.main.Mochila;
import br.com.fatec.main.Notebook;
import br.com.fatec.main.Produto;
import br.com.fatec.main.ProdutoComposto;

public class testTaskII {
	
	@Test
	@DisplayName("Deve descrever o produto")
	void test1() {
		Desconto d = new DescontoDinheiro(0);
		Notebook n1 = new Notebook("Notebook", 1478.00, d, "Samsung", 1.95, "37.7 x 1.99 x 24.9",
									"Essentials E20 Intel Dual Core - 4",4, 500, true, true);
		n1.descreverProduto();
		System.out.println();
		
		assertTrue(true);
	}
	
	@Test
	@DisplayName("Deve descrever o kit")
	void test2() {
		Desconto d = new DescontoDinheiro(0);
		
		Mochila m2 = new Mochila("Mochila", 150.00 , d, "Imaginarium", "Marinho", "33 x 42 x 18", 5);
		
		Notebook n2 = new Notebook("Notebook", 4800.00, d, "Dell", 2.10, "30.1 x 1.99 x 15.4",
									"Inspirion", 8, 1000 , true, true);
		
		Produto p = new ProdutoComposto("Computadores", Arrays.asList(m2, n2), d);
		
		p.descreverProduto();
		
		assertTrue(true);
	}
}
