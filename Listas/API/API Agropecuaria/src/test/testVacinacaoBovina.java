package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import vacinacao.Vacinacao;
import vacinacao.VacinacaoBovina;

class testVacinacaoBovina {
	VacinacaoBovina vb = VacinacaoBovina.getVacinacaoBovina();

	@Test
	@DisplayName("Lista de vacinacao obrigatoria bovina")
	void test1() {
		List<Vacinacao> lista = vb.getAnvisa();
		assertEquals(13,lista.size());
	}
	
	@Test
	@DisplayName("Adicionar / Remover nova vacinacao obrigatoria")
	void test2() {
		Vacinacao v = new Vacinacao("teste");
		vb.addVacinacao(v);
		List<Vacinacao> lista = vb.getAnvisa();
		
		assertEquals(14,lista.size());
		assertTrue(lista.contains(v));
		
		vb.removeVacinacao(v);
		List<Vacinacao> lista2 = vb.getAnvisa();
		
		assertEquals(13,lista2.size());
		assertFalse(lista2.contains(v));
	}
	
	@Test
	@DisplayName("Remover vacina não listada como obrigatoria")
	void test3() {
		Vacinacao v = new Vacinacao("teste");
		vb.removeVacinacao(v);
		List<Vacinacao> lista = vb.getAnvisa();
		
		assertEquals(13,lista.size());
		assertFalse(lista.contains(v));
	}
	
	@Test
	@DisplayName("Adicionar vacina já listada")
	void test4() {
		Vacinacao v = vb.getAnvisa().get(0);
		vb.addVacinacao(v);
		
		List<Vacinacao> lista = vb.getAnvisa();
		assertEquals(13,lista.size());
		assertEquals(lista.indexOf(v), lista.lastIndexOf(v));
	}

}
