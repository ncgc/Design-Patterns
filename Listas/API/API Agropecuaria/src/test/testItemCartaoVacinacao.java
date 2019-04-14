package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.joda.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import cadastro.Animal;
import cadastro.Bovino;
import cadastro.Genero;
import cadastro.RacaBovina;
import financeiro.CotacaoBovino;
import pesagem.PesoKilo;
import vacinacao.ItemCartaoVacinacao;
import vacinacao.Status;
import vacinacao.Vacinacao;

class testItemCartaoVacinacao {
	Animal vaca = new Bovino(new PesoKilo(95), Genero.FEMEA, 2019,1,22, new CotacaoBovino(153.00), RacaBovina.ANGUS);
	Vacinacao  febreAftosa = new Vacinacao("Febre Aftosa");
	ItemCartaoVacinacao icv = new ItemCartaoVacinacao(vaca, febreAftosa);
	
	
	@Test
	@DisplayName("Prazo de aplicação quando há multiplas doses ao ano")
	void test1() {
		
		Vacinacao febreAftosaInfantil = new Vacinacao("Febre Aftosa (até 2 anos)");
		febreAftosaInfantil.setIdadeMaxima(24);
		febreAftosaInfantil.setIdadeMinima(4);
		febreAftosaInfantil.setInveraloAplicacao(6);
		
		ItemCartaoVacinacao icv = new ItemCartaoVacinacao(vaca, febreAftosaInfantil);
		ArrayList<LocalDate> limiteAplicacao = icv.getPrazoAplicacao();
		
		assertEquals(4, limiteAplicacao.size());
		assertEquals(new LocalDate(2019,5,22), limiteAplicacao.get(0));
		assertEquals(new LocalDate(2019,11,22), limiteAplicacao.get(1));
		assertEquals(new LocalDate(2020,5,22), limiteAplicacao.get(2));
		assertEquals(new LocalDate(2020,11,22), limiteAplicacao.get(3));
	}
	

	@Test
	@DisplayName("Prazo de aplicação quando aplicado apenas uma vez por ano")
	void test2() {
		
		ArrayList<LocalDate> limiteAplicacao = icv.getPrazoAplicacao();
		
		assertEquals(new LocalDate(2020,1,22), limiteAplicacao.get(0));	
		assertEquals(20, limiteAplicacao.size());
	}
	

	@Test
	@DisplayName("Status inicial da vacinacao")
	void test3() {
		
		ArrayList<Status> statusAplicacao = icv.getStatus();
		
		assertEquals(20, statusAplicacao.size());
		assertEquals(Status.AGENDAMENTO_PENDENTE, statusAplicacao.get(0));
		assertEquals(Status.AGENDAMENTO_PENDENTE, statusAplicacao.get(19));
	}
	

	@Test
	@DisplayName("Agendamento da vacinaçao dentro do prazo de vacinacao")
	void test4() {
		
		icv.setDataAgendamento(2020, 1, 22);
		icv.setDataAgendamento(2021, 1, 22);
		ArrayList<LocalDate> dataAplicacao = icv.getDataAgendamento();
		
		assertEquals(2, dataAplicacao.size());
		assertEquals(new LocalDate(2020,1,22), dataAplicacao.get(0));
		assertEquals(new LocalDate(2021,1,22), dataAplicacao.get(1));
	}
	
	@Test
	@DisplayName("Status Agendada")
	void test6() {
		
		icv.setDataAgendamento(2020, 1, 22);
		ArrayList<Status> statusAplicacao = icv.getStatus();
		
		assertEquals(Status.AGENDADA, statusAplicacao.get(0));
		assertEquals(Status.AGENDAMENTO_PENDENTE, statusAplicacao.get(1));
	}
	
	
	@Test
	@DisplayName("Agendamento da vacinaçao com data inferior a data mínima")
	void test5() {
		
		icv.setDataAgendamento(2019, 8, 22);
		ArrayList<LocalDate> dataAplicacao = icv.getDataAgendamento();
		
		assertEquals(0, dataAplicacao.size());
	}
	
	
	@Test
	@DisplayName("Sem alteração de status com agendamento da primeira vacina inferior a data mínima")
	void test7() {
		
		icv.setDataAgendamento(2019, 8, 22);
		ArrayList<Status> statusAplicacao = icv.getStatus();
		
		assertEquals(Status.AGENDAMENTO_PENDENTE, statusAplicacao.get(0));
	}
	
	
	@Test
	@DisplayName("Agendamento da vacinaçao acima do prazo de vacinacao")
	void test8() {
		
		icv.setDataAgendamento(2021, 8, 15);
		ArrayList<LocalDate> dataAplicacao = icv.getDataAgendamento();
		
		assertEquals(0, dataAplicacao.size());
	}
	
	
	@Test
	@DisplayName("Status Agendamento Fora do Prazo")
	void test9() {
		
		icv.setDataAgendamento(2020, 3, 22);	
		
		ArrayList<Status> statusAplicacao = icv.getStatus();
		assertEquals(Status.VENCIDA, statusAplicacao.get(0));
		
	}
	
	
	@Test
	@DisplayName("Aplicacao vacina na data agendada")
	void test10() {
		
		icv.setDataAgendamento(2020, 1, 22);
		
		ArrayList<Status> statusAplicacao = icv.getStatus();
		ArrayList<LocalDate> dataAplicacao = icv.getDataAgendamento();
		
		LocalDate dataAplicada = new LocalDate(2020,1, 22);
		icv.aplicacao(dataAplicada);
		
		assertEquals(dataAplicada, dataAplicacao.get(0));
		assertEquals(Status.APLICADA, statusAplicacao.get(0));
	}
	

	@Test
	@DisplayName("Aplicacao vacina fora do prazo, mas antes do vencimento da subsequente")
	void test11() {
		
		icv.setDataAgendamento(2020, 1, 22);
		
		ArrayList<Status> statusAplicacao = icv.getStatus();
		ArrayList<LocalDate> dataAplicacao = icv.getDataAplicacao();
		
		LocalDate dataAplicada = new LocalDate(2020,10, 8);
		icv.aplicacao(dataAplicada);
		
		assertEquals(dataAplicada, dataAplicacao.get(0));
		assertEquals(Status.APLICADA, statusAplicacao.get(0));
	}
	
	
	@Test
	@DisplayName("Aplicacao vacina fora do prazo e após vencimento da subsequente")
	void test12() {
		
		icv.setDataAgendamento(2020, 1, 22);
		
		ArrayList<Status> statusAplicacao = icv.getStatus();
		ArrayList<LocalDate> dataAplicacao = icv.getDataAplicacao();
		
		LocalDate dataAplicada = new LocalDate(2021,4, 18);
		icv.aplicacao(dataAplicada);
		
		assertEquals(null, dataAplicacao.get(0));
		assertEquals(Status.NÃO_APLICADA, statusAplicacao.get(0));
		assertEquals(dataAplicada, dataAplicacao.get(1));
		assertEquals(Status.APLICADA, statusAplicacao.get(1));
		
	}
	
	@Test
	@DisplayName("Aplicacao de vacina sem agendamento")
		void test13() {
		ArrayList<Status> statusAplicacao = icv.getStatus();
		ArrayList<LocalDate> dataAplicacao = icv.getDataAplicacao();
		
		LocalDate dataAplicada = new LocalDate(2021,4, 18);
		icv.aplicacao(dataAplicada);
		
		assertEquals(null, dataAplicacao.get(0));
		assertEquals(Status.NÃO_APLICADA, statusAplicacao.get(0));
		assertEquals(dataAplicada, dataAplicacao.get(1));
		assertEquals(Status.APLICADA, statusAplicacao.get(1));
	}
	
	
	@Test
	@DisplayName("Aplicacao de vacina vencida")
	void test14() {
		icv.setDataAgendamento(2020, 3, 22);
	
		ArrayList<Status> statusAplicacao = icv.getStatus();
		ArrayList<LocalDate> dataAplicacao = icv.getDataAplicacao();
		
		LocalDate dataAplicada = new LocalDate(2020,3, 22);
		icv.aplicacao(dataAplicada);
		
		assertEquals(dataAplicada, dataAplicacao.get(0));
		assertEquals(Status.APLICADA, statusAplicacao.get(0));
		
	}
	
	@Test
	@DisplayName("Alterar data dentro do prazo")
	void test15() {
		icv.setDataAgendamento(2020,3,22);
		LocalDate dataAnterior = new LocalDate(2020,3,22);
		LocalDate dataNova = new LocalDate(2020,1,22);
		
		icv.alteraDataAgendamento(dataAnterior, dataNova);
		ArrayList<LocalDate> dataAgendamento = icv.getDataAgendamento();
		
		assertEquals(dataNova, dataAgendamento.get(0));
	}
	

	@Test
	@DisplayName("Alterar data fora do prazo")
	void test16() {
		icv.setDataAgendamento(2020,3,22);
		LocalDate dataAnterior = new LocalDate(2020,3,22);
		LocalDate dataNova = new LocalDate(2022,1,22);
		
		icv.alteraDataAgendamento(dataAnterior, dataNova);
		ArrayList<LocalDate> dataAgendamento = icv.getDataAgendamento();
		
		assertEquals(dataAnterior, dataAgendamento.get(0));
		
	}
	
}
