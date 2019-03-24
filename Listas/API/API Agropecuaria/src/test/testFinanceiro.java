package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import cadastro.Animal;
import cadastro.Bovino;
import cadastro.Genero;
import cadastro.Suino;
import financeiro.CalculoPreco;
import financeiro.Cotacao;
import financeiro.CotacaoBovino;
import financeiro.CotacaoSuino;

class testFinanceiro {

	@Test
	@DisplayName("Deve calcular a cotacao de um boi")
	void test1() {
		Cotacao c =  new CotacaoBovino(153.00);
		Animal boi = new Bovino(75.00, "Angus", Genero.MACHO, new Date(2018, 02, 20),c, null);
		double preco = new CalculoPreco(boi, c).valorVenda();
		
		assertEquals(preco, 11475.00, 0.0001);
	}

	@Test
	@DisplayName("Deve calcular a cotacao de um porco")
	void test2() {
		Cotacao c = new CotacaoSuino(4.29);
		Animal porco = new Suino(85.00, "Javali", Genero.FEMEA, new Date(2018, 11, 15), c);
		double preco = new CalculoPreco(porco, c).valorVenda();
		
		assertEquals(preco,364.65, 0.0001);
	}
}
