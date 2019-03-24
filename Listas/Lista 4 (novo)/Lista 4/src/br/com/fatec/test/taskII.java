package br.com.fatec.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.fatec.modelo.ValidaCPF;

class taskII {

	@Test
	@DisplayName("Deve retornar true quando CPF válido")
	void test1() {
		ValidaCPF v = new ValidaCPF("529.982.247-25"); 
		assertTrue(v.isCPFValido());
	}
	
	@Test
	@DisplayName("Deve retornar false quando CPF inválido")
	void test2() {
		ValidaCPF v = new ValidaCPF("529.982.247-12"); 
		assertFalse(v.isCPFValido());
	}

}
