package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import cadastro.PesoArroba;

class testCadastro {

	@Test
	@DisplayName("Deve converter o peso de kg para arroba")
	void test1() {
		PesoArroba pa = new PesoArroba(154.00);
		
		assertEquals(pa.pesoArroba(), 10.484, 0.0001);
	}
	
	@Test
	@DisplayName("Deve ")
	void test2() {
		
		
	}

}
