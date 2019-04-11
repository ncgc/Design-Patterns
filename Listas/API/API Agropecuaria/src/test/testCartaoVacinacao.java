package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

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
import pesagem.PesoKilo;
import vacinacao.ItemCartaoVacinacao;
import vacinacao.Vacinacao;
import vacinacao.VacinacaoBovina;
import vacinacao.VacinacaoSuina;

class testCartaoVacinacao {

	@Test
	@DisplayName("Criacao do cartão de vacinação de um bovino")
	
	void test1() {
		Animal vaca = new Bovino(new PesoKilo(95), Genero.FEMEA, 2019,1,22, new CotacaoBovino(153.00), RacaBovina.ANGUS);
		ArrayList<ItemCartaoVacinacao> cv = vaca.getCartaoVacinacao();
		VacinacaoBovina vb = VacinacaoBovina.getVacinacaoBovina();
		List<Vacinacao> lista = vb.getAnvisa();
		
		assertEquals(lista.size(),cv.size());
		assertEquals(lista.get(0).getDoença(), cv.get(0).getVacinacao().getDoença());
		assertEquals(lista.get(12).getDoença(), cv.get(12).getVacinacao().getDoença());
	}
	
	
	@Test
	@DisplayName("Criacao do cartão de vacinação de um suino")
	void test2() {
		Animal porco = new Suino(new PesoKilo(8), Genero.FEMEA, 2019, 02, 02, new CotacaoSuino(5.00), RacaSuina.HAMPSHIRE);
		ArrayList<ItemCartaoVacinacao> cv = porco.getCartaoVacinacao();
		VacinacaoSuina vb = VacinacaoSuina.getVacinacaoSuina();
		List<Vacinacao> lista = vb.getAnvisa();
		
		assertEquals(lista.size(),cv.size());
		assertEquals(lista.get(0).getDoença(), cv.get(0).getVacinacao().getDoença());
		assertEquals(lista.get(4).getDoença(), cv.get(4).getVacinacao().getDoença());
		
	}

}
