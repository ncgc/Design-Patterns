package vacinacao;

import java.util.ArrayList;

import org.joda.time.LocalDate;

import cadastro.Animal;

/**
 * @author natalia 
 * Realiza o controle de vacinacao para cada uma das vacinas que o animal 
 * deverá tomar ao longo de sua vida. 
 * @
 */
public class ItemCartaoVacinacao {
	private Animal animal;
	private Vacinacao vacinacao;
	private ArrayList<LocalDate> dataAgendamento;
	private ArrayList<LocalDate> prazoAplicacao;
	private ArrayList<LocalDate> dataAplicacao;
	private ArrayList<Status> statusAplicacao;
	
	/**
	 * @param animal	animal a que o item de vacinacao está associado;
	 * @param vacinacao	doença indicada pela anvisa como obrigatória;
	 * 
	 */
	public ItemCartaoVacinacao(Animal animal, Vacinacao vacinacao) {
		this.animal = animal;
		this.vacinacao = vacinacao;
		this.dataAgendamento = new ArrayList<LocalDate>();
		this.prazoAplicacao = new ArrayList<LocalDate>();
		this.dataAplicacao = new ArrayList<LocalDate>();
		this.statusAplicacao = new ArrayList<Status>();
		criar();
	}
	
	/**
	 * Define o prazo de aplicacao e status de aplicacao inicial de cada doença
	 */
	private void criar() {
		setPrazoAplicacao();
		setStatusInicial();
	}
	
	/**
	 * Define o prazo recomendado para que a vacina seja aplicada ao longo da vida do animal
	 * considerando o intervalo entre as aplicações, a idade mínima para a primeira aplicação e
	 * idade máxima para aplicação (no caso de ser exclusiva para novilhos/leitões).
	 */
	private void setPrazoAplicacao() {
		LocalDate nascimento = animal.getDataNascimento();
		//1a dose
			int prazo_d1 = vacinacao.getIdadeMinima();
			LocalDate dose_1 = nascimento.plusMonths(prazo_d1);
			prazoAplicacao.add(dose_1);
		//outras doses
			int intervalo = vacinacao.getIntervaloAplicacao();
			int doses = (vacinacao.getIdadeMaxima() - vacinacao.getIdadeMinima())/intervalo;
			for(int d = 1; d <= doses; d++) {
				prazoAplicacao.add(dose_1.plusMonths(d * intervalo));
			}
		}
			
	/**
	 * @return retorna as datas recomendadas para aplicacao de uma vacina 
	 * ao longo da vida do animal.
	 */
	public ArrayList<LocalDate> getPrazoAplicacao(){
		return this.prazoAplicacao;
	}
	
	/**
	 * Define o status de agendamento de todas as doses da vacina a serem tomadas
	 * como sendo inicialmente pendentes.
	 */
	private void setStatusInicial() {
		for(int i = 0; i < prazoAplicacao.size(); i++) {
			statusAplicacao.add(Status.AGENDAMENTO_PENDENTE);
		}
	}
	
	/**
	 * @return todos os status de aplicacao da vacina ao longo da vida do animal
	 */
	public ArrayList<Status> getStatus(){
		return this.statusAplicacao;
	}
	
	/**
	 * @param data 		data de agendamento informada;
	 * @param indice	indicação de qual a dose da vacina que será agendada;
	 * @return true		se a data de agendamento estiver entre o prazo mínimo de aplicacao e 
	 * 					o prazo da aplicação subsequente (se houver); 
	 * @return false	se a data de agendamento for superior ao prazo da aplicacão subsequente ou 
	 * 					inferior ao prazo mínimo. 
	 */
	
	private boolean validaAgendamento(LocalDate data, int indice) {
		if(data.isEqual(prazoAplicacao.get(indice))) return true;
		if(data.isBefore(prazoAplicacao.get(indice))) return false;
		if(data.isAfter(prazoAplicacao.get(indice))) {
			try {
				if(data.isBefore(prazoAplicacao.get(indice + 1))) return true;
			} finally {}
		}	
		return false;
	}
	
	/**
	 * Define a data de agendamento, caso seja válida. 
	 * 
	 * @param ano 	ano da data de agendamento;
	 * @param mes	mês da data de agendamento;
	 * @param dia	dia da data de agendamento;
	 * 
	 */
	public void setDataAgendamento(int ano, int mes, int dia) {
		LocalDate data = new LocalDate(ano, mes, dia);
		int indice = statusAplicacao.indexOf(Status.AGENDAMENTO_PENDENTE);
		if(validaAgendamento(data, indice)) {
			dataAgendamento.add(data);
			atualizaStatusAgendamento(indice, data);
		}
	}
	
	/**
	 * Altera uma data de agendamento, se a nova data for válida;
	 * @param anterior	data de agendamento anterior;
	 * @param nova		nova data de agendamento;
	 */
	public void alteraDataAgendamento(LocalDate anterior, LocalDate nova) {
		int indice = dataAgendamento.indexOf(anterior);
		if(validaAgendamento(nova, indice)) {
			dataAgendamento.set(indice, nova);
			atualizaStatusAgendamento(indice, nova);
		}	
	}
	
	/**
	 * @return todas as datas de agendamento de uma determinada doença
	 */
	public ArrayList<LocalDate>  getDataAgendamento() {
		return this.dataAgendamento;
	}

	/**
	 * Atualiza o status de agendamento quanto a vacinação.
	 * Se a data de agendamento for superior a data recomendada para aplicacao,
	 * o status mudará para VENCIDA. Do contrário, o status passará para AGENDADA.
	 * Existe uma tolerância de um mês de atraso. 
	 * 
	 * @param indice indica qual a dose da vacinação está se referindo;
	 * @param data	data de agendamento
	 */
	private void atualizaStatusAgendamento(int indice, LocalDate data) {
		LocalDate limite = prazoAplicacao.get(indice);
		if(data.isAfter(limite.plusMonths(1))) 
			statusAplicacao.set(indice, Status.VENCIDA);
		else {
			statusAplicacao.set(indice, Status.AGENDADA);
		}
	}
	
	/**
	 * @return valor da dose a ser aplicada.
	 */
	private int indiceAplicacao() {
		if(statusAplicacao.contains(Status.VENCIDA)) {
			return statusAplicacao.indexOf(Status.VENCIDA);
		}
		if(statusAplicacao.contains(Status.AGENDADA)) {
			return statusAplicacao.indexOf(Status.AGENDADA);
		}
		else {
			return statusAplicacao.indexOf(Status.AGENDAMENTO_PENDENTE);
		}
	}
	
	/**
	 * Verifica se a dataAplicada está dentro do prazo. 
	 * Se estiver, define a data aplicada e status APLICADA na dose esperada.
	 * Do contrário, procura qual dose é equivalente a data de aplicação e 
	 * considera todas as doses anteriores como NÃO APLICADAS. 
	 * @param dataAplicada data em que a vacina foi aplicada
	 */
	public void aplicacao(LocalDate dataAplicada) {
		int indice = indiceAplicacao();
		while(dataAplicada.isAfter(prazoAplicacao.get(indice))){
			try {
				if(dataAplicada.isBefore(prazoAplicacao.get(indice + 1))) {
					break;
				}
				else {
					dataAplicacao.add(null);
					statusAplicacao.set(indice, Status.NÃO_APLICADA);	
				}
			} finally {}
			indice += 1;
		}
		dataAplicacao.add(dataAplicada);
		statusAplicacao.set(indice, Status.APLICADA);
	}
	
	/**
	 * 
	 * @return todas as datas de aplicaçoes das vacinas
	 */
	public ArrayList<LocalDate> getDataAplicacao(){
		return this.dataAplicacao;
	}
	
	public Vacinacao getVacinacao() {
		return vacinacao;
	}
	
}
