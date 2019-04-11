package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import pesagem.PesoArroba;
import pesagem.PesoKilo;

class testPeso {
	
	@Test
	@DisplayName("Deve retornar o peso em kilo")
	void test1() {
		PesoKilo pk = new PesoKilo(45);
		assertEquals(pk.getPesoKilo(), 45.00, 0.0001);	
	}
	
	@Test
	@DisplayName("Deve converter o peso em kilos")
	void test2() {
		PesoArroba pa = new PesoArroba(6);
		assertEquals(pa.getPesoKilo(),88.134, 0.0001);
	}
	
	@Test
	@DisplayName("Deve retornar o peso em Arrobas")
	void test3() {
		PesoArroba pa = new PesoArroba(6);
		assertEquals(pa.getPesoArroba(), 6, 0.0001);
	}

	@Test
	@DisplayName("Deve converter o peso em Arrobas")
	void test4() {
		PesoKilo pk = new PesoKilo(1);
		assertEquals(pk.getPesoArroba(), 0.0681, 0.0001);
	}
	
}
