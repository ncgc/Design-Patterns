package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.fatec.Desconto;
import br.com.fatec.DescontoDinheiro;
import br.com.fatec.DescontoPorcentagem;
import br.com.fatec.Produto;
import br.com.fatec.ProdutoComposto;
import br.com.fatec.ProdutoUnitario;

class testTaskI {

	@Test
	@DisplayName("Deve calcular preco do kit sem desconto")
	void test1() {
		Desconto d = new DescontoDinheiro(0);
		
		Produto p1 = new ProdutoUnitario("Notebook", 2500.00, d);
		Produto p2 = new ProdutoUnitario("Capa Notebook", 30.00, d);
		Produto p3 = new ProdutoUnitario("Mouse", 20.00, d);
		Produto p4 = new ProdutoUnitario("Fone de ouvido", 60.00, d);
		
		Produto kit = new ProdutoComposto("Informática", Arrays.asList(p1, p2, p3, p4), d);
		
		assertEquals(kit.getValorProduto(),2610.00, 0.0001);
		
	}
	
	@Test
	@DisplayName("Deve calcular preco do kit com desconto em dinheiro sobre o valor do kit")
	void test2() {
		Desconto dkit = new DescontoDinheiro(150.00);
		Desconto dprod = new DescontoDinheiro(0.00);
		
		Produto p1 = new ProdutoUnitario("Notebook", 2500.00, dprod);
		Produto p2 = new ProdutoUnitario("Capa Notebook", 30.00, dprod);
		Produto p3 = new ProdutoUnitario("Mouse", 20.00, dprod);
		Produto p4 = new ProdutoUnitario("Fone de ouvido", 60.00, dprod);
		
		Produto kit = new ProdutoComposto("Informática", Arrays.asList(p1, p2, p3, p4), dkit);
		
		assertEquals(kit.getValorComDesconto(), 2460.00, 0.0001);
	}
	
	@Test
	@DisplayName("Deve calcular preco do kit com desconto em porcentagem sobre o valor do kit")
	void test3() {
		Desconto dkit = new DescontoPorcentagem(5);
		Desconto dprod = new DescontoDinheiro(0.00);
		
		Produto p1 = new ProdutoUnitario("Notebook", 2500.00, dprod);
		Produto p2 = new ProdutoUnitario("Capa Notebook", 30.00, dprod);
		Produto p3 = new ProdutoUnitario("Mouse", 20.00, dprod);
		Produto p4 = new ProdutoUnitario("Fone de ouvido", 60.00, dprod);
		
		Produto kit = new ProdutoComposto("Informática", Arrays.asList(p1, p2, p3, p4), dkit);
		
		assertEquals(kit.getValorComDesconto(), 2479.50, 0.0001);
		
	}
	
	@Test
	@DisplayName("Deve calcular preco do produto unitario com desconto em porcentagem")
	void test4() {
		Desconto d = new DescontoPorcentagem(2.5);
		
		Produto p1 = new ProdutoUnitario("Notebook", 2500.00, d);
		
		assertEquals(p1.getValorComDesconto(), 2437.50, 0.0001);
		
	}
	
	@Test
	@DisplayName("Deve calcular preco do produto unitario com desconto em dinheiro")
	void test5() {
		Desconto d = new DescontoDinheiro(155.25);
		
		Produto p1 = new ProdutoUnitario("Notebook", 2500.00, d);
		
		assertEquals(p1.getValorComDesconto(), 2344.75, 0.0001);
		
	}
}
