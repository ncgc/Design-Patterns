package br.com.fatec.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.fatec.main.ContaEstacionamento;
import br.com.fatec.main.Passeio;
import br.com.fatec.main.ValorDiaria;
import br.com.fatec.main.ValorHora;
import br.com.fatec.main.ValorMensal;
import br.com.fatec.main.Veiculo;

class test {

	@Test
	@DisplayName("Deve calcular o valor do estacionamento de um veiculo com menos de 12 horas de permanencia")
	void test1() {
		Veiculo v = new Passeio(2.00, 26.00, 300.00);
		ContaEstacionamento conta = new ContaEstacionamento(8, 19, v, new ValorHora());
		
		assertEquals(conta.valorConta(), 22.00, 0.001);
	}
	
	@Test
	@DisplayName("Deve calcular o valor do estacionamento de um veiculo com mais de 12 horas de permanencia")
	void test2() {
		Veiculo v = new Passeio(2.00, 26.00, 300.00);
		ContaEstacionamento conta = new ContaEstacionamento(8, 21, v, new ValorDiaria());
		
		assertEquals(conta.valorConta(), 26.00, 0.001);
	}
	
	@Test
	@DisplayName("Deve calcular o valor do estacionamento de um veiculo com menos de 15 dias de permanencia")
	void test3() {
		Veiculo v = new Passeio(2.00, 26.00, 300.00);
		ContaEstacionamento conta = new ContaEstacionamento(8, 368, v, new ValorDiaria());
		
		assertEquals(conta.valorConta(),390.00, 0.001);
	}
	
	@Test
	@DisplayName("Deve calcular o valor do estacionamento de um veiculo com mais de 15 dias de permanencia")
	void test4() {
		Veiculo v = new Passeio(2.00, 26.00, 300.00);
		ContaEstacionamento conta = new ContaEstacionamento(8,392, v, new ValorMensal());
		
		assertEquals(conta.valorConta(),300.00, 0.001);
	}
	
}
