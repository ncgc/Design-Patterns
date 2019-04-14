package test;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import cadastro.Animal;
import cadastro.Bovino;
import cadastro.Genero;
import cadastro.RacaBovina;
import cadastro.RacaSuina;
import cadastro.Suino;
import financeiro.CotacaoBovino;
import financeiro.CotacaoSuino;
import main.Fazenda;
import pesagem.PesoKilo;

class testMain {
	Animal vaca = new Bovino(new PesoKilo(95), Genero.FEMEA, 2019,1,22, new CotacaoBovino(153.00), RacaBovina.ANGUS);
	Animal boi = new Bovino(new PesoKilo(110), Genero.MACHO, 2017,1,22, new CotacaoBovino(153.00), RacaBovina.HIGHLAND);
	Animal boi2 = new Bovino(new PesoKilo(100), Genero.MACHO, 2017,1,22, new CotacaoBovino(173.00), RacaBovina.BEEFMASTER);
	
	Animal porco1 = new Suino(new PesoKilo(8), Genero.FEMEA, 2019, 02, 02, new CotacaoSuino(5.00), RacaSuina.HAMPSHIRE);
	Animal porco2 = new Suino(new PesoKilo(8), Genero.FEMEA, 2018, 02, 02, new CotacaoSuino(5.00), RacaSuina.HAMPSHIRE);
	Animal porco3 = new Suino(new PesoKilo(7), Genero.MACHO, 2018, 12, 14, new CotacaoSuino(4.3), RacaSuina.LARGEWHITE);
	Animal porco4 = new Suino(new PesoKilo(2), Genero.FEMEA, 2019, 04, 02, new CotacaoSuino(2.00), RacaSuina.NILOCANASTRA);
	
	Fazenda f = Fazenda.getInstance();
	
	@Disabled
	@Test
	@DisplayName("Deve retornar a quantidade total de animais cadastrados")
	void test() {
		assertEquals(3, f.getRebanhoBovino());
		assertEquals(2, f.getRebanhoSuino());
	}
	
	@Disabled
	@Test
	@DisplayName("Deve retornar a quantidade de animais fêmeas")
	void test1() {
		
	}
	
	@Disabled
	@Test
	@DisplayName("Deve retornar a quantidade de animais machos")
	void test2() {
		
	}
	
	@Disabled
	@Test
	@DisplayName("Deve retornar o peso total dos animais")
	void test3() {
		
	}
	
	@Test
	@DisplayName("Deve retornar o preço do rebanho")
	void test4() {
		
	}
	
}

