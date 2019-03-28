package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import cadastro.Animal;
import cadastro.Bovino;
import cadastro.Genero;
import cadastro.RacaBovina;
import cadastro.RacaSuina;
import cadastro.Suino;
import financeiro.CalculoPreco;
import financeiro.Cotacao;
import financeiro.CotacaoBovino;
import financeiro.CotacaoSuino;
import pesagem.PesoArroba;
import pesagem.PesoKilo;

class testFinanceiro {

	@Test
	@DisplayName("Deve calcular a cotacao de um boi com peso em kilos")
	void test1() {
		Cotacao c =  new CotacaoBovino(153.00);
		Animal boi =  new Bovino(new PesoKilo(90), Genero.FEMEA, "2018-11-15", RacaBovina.GELBVIEH, (CotacaoBovino) c);
		CalculoPreco cp = new CalculoPreco(boi, c);
		
		assertEquals(937.436,cp.valorVenda(), 0.001);	
	}
	
	@Test
	@DisplayName("Deve calcular a cotacao de um boi com peso em arrobas")
	void test2() {
		Cotacao c =  new CotacaoBovino(153.00);
		Animal boi =  new Bovino(new PesoArroba(5), Genero.FEMEA, "2018-11-15", RacaBovina.GELBVIEH, (CotacaoBovino) c);
		CalculoPreco cp = new CalculoPreco(boi, c);
		
		assertEquals(765, cp.valorVenda(), 0.001);
	}

	
	@Test
	@DisplayName("Deve calcular a cotacao de um porco com peso em kilos")
	void test3() {
		Cotacao c = new CotacaoSuino(4.29);
		Animal porco = new Suino(new PesoKilo(7), Genero.MACHO, "2018-12-14", RacaSuina.LARGEWHITE, (CotacaoSuino) c);
		CalculoPreco cp = new CalculoPreco(porco, c);
		
		assertEquals(30.03, cp.valorVenda(), 0.001);
	}
	
	@Test
	@DisplayName("Deve calcular a cotacao de um porco com peso em arrobas")
	void test4() {
		Cotacao c = new CotacaoSuino(4.29);
		Animal porco = new Suino(new PesoArroba(0.47), Genero.MACHO, "2018-12-14", RacaSuina.LARGEWHITE, (CotacaoSuino) c);
		CalculoPreco cp = new CalculoPreco(porco, c);
		
		assertEquals(29.617, cp.valorVenda(), 0.001);
		
	}
}
