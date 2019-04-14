package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import cadastro.Animal;
import cadastro.Bovino;
import cadastro.Genero;
import cadastro.RacaBovina;
import cadastro.RacaSuina;
import cadastro.Suino;
import financeiro.Compra;
import financeiro.CotacaoBovino;
import financeiro.CotacaoSuino;
import financeiro.Venda;
import main.Fazenda;
import main.Rebanho;
import pesagem.PesoKilo;

@TestInstance(Lifecycle.PER_CLASS)
class testVenda {
	Animal vaca = new Bovino(new PesoKilo(95), Genero.FEMEA, 2019,1,22, new CotacaoBovino(153.00), RacaBovina.ANGUS);
	Animal porco1 = new Suino(new PesoKilo(8), Genero.FEMEA, 2019, 02, 02, new CotacaoSuino(5.00), RacaSuina.HAMPSHIRE);
	Animal porco2 = new Suino(new PesoKilo(7), Genero.MACHO, 2018, 12, 14, new CotacaoSuino(4.3), RacaSuina.LARGEWHITE);
	Animal boi = new Bovino(new PesoKilo(110), Genero.MACHO, 2017,1,22, new CotacaoBovino(153.00), RacaBovina.HIGHLAND);
	Fazenda f = Fazenda.getInstance();
	
	@BeforeAll
	public void init()  {
		ArrayList<Animal> a = new ArrayList<Animal>();
		a.addAll(Arrays.asList(vaca,boi, porco1, porco2));
		Rebanho rebanhoComprado = new Rebanho(a);
		new Compra(rebanhoComprado, 2019,02,02, f);
		
		List<Animal> fBovino = f.getRebanhoBovino().getAnimais();
		List<Animal> fSuino = f.getRebanhoSuino().getAnimais();
		
		assertEquals(2, fBovino.size());
		assertEquals(2, fSuino.size());
	}

	@Test
	@DisplayName("Venda bovino existente")
	void test1() {
		ArrayList<Animal> b = new ArrayList<Animal>();
		b.addAll(Arrays.asList(vaca));
		Rebanho rebanhoVendido = new Rebanho(b);
		Venda v = new Venda(rebanhoVendido, 2019,02,02, f);
		
		List<Venda> historico = f.getHistoricoVenda();
		List<Animal> fBovino = f.getRebanhoBovino().getAnimais();
		List<Animal> fSuino = f.getRebanhoSuino().getAnimais();
		
		assertTrue(historico.size()>0);
		assertTrue(historico.contains(v));
		assertEquals(1, fBovino.size());
		assertEquals(2, fSuino.size());
		assertEquals(989.51,v.getValorVenda(),0.01);
		
	}

	@Test
	@DisplayName("Venda bovino não existente")
	void test2() {
		Animal vaca2 = new Bovino(new PesoKilo(90), Genero.FEMEA, 2017,1,22, new CotacaoBovino(120.00), RacaBovina.CHIANINA);
		ArrayList<Animal> b = new ArrayList<Animal>();
		b.addAll(Arrays.asList(vaca2));
		Rebanho rebanhoVendido = new Rebanho(b);
		Venda v = new Venda(rebanhoVendido, 2019,02,02, f);
		
		List<Venda> historico = f.getHistoricoVenda();
		List<Animal> fBovino = f.getRebanhoBovino().getAnimais();
		List<Animal> fSuino = f.getRebanhoSuino().getAnimais();
		
		assertTrue(historico.size()>0);
		assertFalse(historico.contains(v));
		assertEquals(1, fBovino.size());
		assertEquals(2, fSuino.size());
		assertEquals(0.00, v.getValorVenda());
	}
	
	@Test
	@DisplayName("Venda suino existente")
	void test3() {
		ArrayList<Animal> s = new ArrayList<Animal>();
		s.addAll(Arrays.asList(porco1));
		Rebanho rebanhoVendido = new Rebanho(s);
		Venda v = new Venda(rebanhoVendido, 2019,02,02, f);
		
		List<Venda> historico = f.getHistoricoVenda();
		List<Animal> fBovino = f.getRebanhoBovino().getAnimais();
		List<Animal> fSuino = f.getRebanhoSuino().getAnimais();
		
		assertTrue(historico.size()>0);
		assertTrue(historico.contains(v));
		assertEquals(1, fBovino.size());
		assertEquals(1, fSuino.size());
		assertEquals(40.00,v.getValorVenda(),0.01);
		
	}
	
	@Test
	@DisplayName("Venda suino inexistente")
	void test4() {
		Animal porco4 = new Suino(new PesoKilo(2), Genero.MACHO, 2019, 01, 14, new CotacaoSuino(4.3), RacaSuina.DUROCJERSEY);
		ArrayList<Animal> s = new ArrayList<Animal>();
		s.addAll(Arrays.asList(porco4));
		Rebanho rebanhoVendido = new Rebanho(s);
		Venda v = new Venda(rebanhoVendido, 2019,02,02, f);
		
		List<Venda> historico = f.getHistoricoVenda();
		List<Animal> fBovino = f.getRebanhoBovino().getAnimais();
		List<Animal> fSuino = f.getRebanhoSuino().getAnimais();
		
		assertTrue(historico.size()>0);
		assertFalse(historico.contains(v));
		assertEquals(1, fBovino.size());
		assertEquals(1, fSuino.size());
		assertEquals(0,v.getValorVenda(),0.01);
	}
	
}
