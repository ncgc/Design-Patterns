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
import main.Fazenda;
import main.Rebanho;
import pesagem.PesoKilo;

@TestInstance(Lifecycle.PER_CLASS)
class testMain {
	Animal vaca = new Bovino(new PesoKilo(95), Genero.FEMEA, 2019,1,22, new CotacaoBovino(153.00), RacaBovina.ANGUS);
	Animal boi = new Bovino(new PesoKilo(110), Genero.MACHO, 2017,1,22, new CotacaoBovino(153.00), RacaBovina.HIGHLAND);
	Animal boi2 = new Bovino(new PesoKilo(100), Genero.MACHO, 2017,1,22, new CotacaoBovino(173.00), RacaBovina.BEEFMASTER);
	
	Animal porco1 = new Suino(new PesoKilo(8), Genero.FEMEA, 2019, 02, 02, new CotacaoSuino(5.00), RacaSuina.HAMPSHIRE);
	Animal porco2 = new Suino(new PesoKilo(8), Genero.FEMEA, 2018, 02, 02, new CotacaoSuino(5.00), RacaSuina.HAMPSHIRE);
	Animal porco3 = new Suino(new PesoKilo(7), Genero.MACHO, 2018, 12, 14, new CotacaoSuino(4.3), RacaSuina.LARGEWHITE);
	Animal porco4 = new Suino(new PesoKilo(2), Genero.FEMEA, 2019, 04, 02, new CotacaoSuino(2.00), RacaSuina.NILOCANASTRA);
	
	Fazenda f = Fazenda.getInstance();
	
	@BeforeAll
	public void init()  {
		ArrayList<Animal> a = new ArrayList<Animal>();
		a.addAll(Arrays.asList(vaca,boi,boi2, porco1, porco2, porco3, porco4));
		Rebanho rebanhoComprado = new Rebanho(a);
		new Compra(rebanhoComprado, 2019,02,02, f);
		
		List<Animal> fBovino = f.getRebanhoBovino().getAnimais();
		List<Animal> fSuino = f.getRebanhoSuino().getAnimais();
		
		assertEquals(3, fBovino.size());
		assertEquals(4, fSuino.size());
	}
	
	
	@Test
	@DisplayName("Deve retornar a quantidade total de animais cadastrados")
	void test() {
		assertEquals(7, f.totalAnimais());
	}
	
	@Test
	@DisplayName("Deve retornar a quantidade de animais fêmeas")
	void test1() {
		assertEquals(1, f.getQuantidadeGenero(f.getRebanhoBovino(), Genero.FEMEA));
		assertEquals(3, f.getQuantidadeGenero(f.getRebanhoSuino(), Genero.FEMEA));
	}
	
	@Test
	@DisplayName("Deve retornar a quantidade de animais machos")
	void test2() {
		assertEquals(2, f.getQuantidadeGenero(f.getRebanhoBovino(), Genero.MACHO));
		assertEquals(1, f.getQuantidadeGenero(f.getRebanhoSuino(), Genero.MACHO));
	}
	
	@Test
	@DisplayName("Deve retornar o peso total dos animais")
	void test3() {
		assertEquals(25, f.getPesoTotal(f.getRebanhoSuino(), "kilo"));
		assertEquals(20.76,f.getPesoTotal(f.getRebanhoBovino(), "arroba"), 0.01);
	}
	
	@Test
	@DisplayName("Deve retornar o preço do rebanho")
	void test4() {
		assertEquals(3427.12,f.valorAtivo(), 0.01);
	}
	
	@Test
	@DisplayName("Deve retornar o percentual de animais vacianados e quantos faltam vacinar")
	void test5() {
		assertEquals(0, f.getPercentualVacinado(f.getRebanhoBovino(), "raiva"));
		assertEquals(0, f.getPercentualVacinado(f.getRebanhoSuino(), "raiva"));
		
		assertEquals(1, f.getPercentualNaoVacinado(f.getRebanhoBovino(), "raiva"));
		assertEquals(1, f.getPercentualNaoVacinado(f.getRebanhoSuino(), "raiva"));
	}
	
	
	
}

