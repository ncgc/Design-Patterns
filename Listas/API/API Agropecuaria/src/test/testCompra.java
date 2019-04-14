package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import cadastro.Animal;
import cadastro.Bovino;
import cadastro.Genero;
import cadastro.RacaBovina;
import cadastro.RacaSuina;
import cadastro.Suino;
import financeiro.Compra;
import financeiro.CotacaoBovino;
import financeiro.CotacaoSuino;
import main.Fazenda;
import main.Rebanho;
import pesagem.PesoKilo;

class testCompra {
	Animal vaca = new Bovino(new PesoKilo(95), Genero.FEMEA, 2019,1,22, new CotacaoBovino(153.00), RacaBovina.ANGUS);
	Animal porco1 = new Suino(new PesoKilo(8), Genero.FEMEA, 2019, 02, 02, new CotacaoSuino(5.00), RacaSuina.HAMPSHIRE);
	Animal porco2 = new Suino(new PesoKilo(7), Genero.MACHO, 2018, 12, 14, new CotacaoSuino(4.3), RacaSuina.LARGEWHITE);
	Animal boi = new Bovino(new PesoKilo(110), Genero.MACHO, 2017,1,22, new CotacaoBovino(153.00), RacaBovina.HIGHLAND);

	
	@Test
	@DisplayName("Compra de rebanho bovino")
	void test1() {
		Fazenda f = Fazenda.getInstance();
		ArrayList<Animal> b = new ArrayList<Animal>();
		b.addAll(Arrays.asList(vaca,boi));
		Rebanho rebanhoComprado = new Rebanho(b);
		Compra c = new Compra(rebanhoComprado, 2019,02,02, f);
		
		List<Compra> historico = f.getHistoricoCompra();
		List<Animal> fBovino = f.getRebanhoBovino().getAnimais();
		List<Animal> fSuino = f.getRebanhoSuino().getAnimais();
		
		assertTrue(historico.size()>0);
		assertTrue(historico.contains(c));
		assertEquals(2, fBovino.size());
		assertEquals(0, fSuino.size());
		assertEquals(2135.27,c.getValorCompra(),0.01);
	}

	@Test
	@DisplayName("Compra de rebanho suino")
	void test2() {
		Fazenda f = Fazenda.getInstance();
		ArrayList<Animal> s = new ArrayList<Animal>();
		s.addAll(Arrays.asList(porco1, porco2));
		Rebanho rebanhoComprado = new Rebanho(s);
		Compra c = new Compra(rebanhoComprado, 2019,02,02, f);
		
		List<Compra> historico = f.getHistoricoCompra();
		List<Animal> fBovino = f.getRebanhoBovino().getAnimais();
		List<Animal> fSuino = f.getRebanhoSuino().getAnimais();
		
		assertTrue(historico.size()>1);
		assertEquals(2, fBovino.size());
		assertEquals(2, fSuino.size());
		assertEquals(70.1,c.getValorCompra(),0.01);
	}
	
	@Test
	@DisplayName("Compra de rebanho misto")
	void test3() {
		Fazenda f = Fazenda.getInstance();
		ArrayList<Animal> a = new ArrayList<Animal>();
		a.addAll(Arrays.asList(vaca,boi, porco1, porco2));
		Rebanho rebanhoComprado = new Rebanho(a);
		Compra c = new Compra(rebanhoComprado, 2019,02,02, f);
		
		List<Compra> historico = f.getHistoricoCompra();
		List<Animal> fBovino = f.getRebanhoBovino().getAnimais();
		List<Animal> fSuino = f.getRebanhoSuino().getAnimais();
		
		assertTrue(historico.size()>1);
		assertEquals(4, fBovino.size());
		assertEquals(4, fSuino.size());
		assertEquals(2205.37,c.getValorCompra(),0.01);
	}
	
}
