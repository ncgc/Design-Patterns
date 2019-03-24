package br.com.fatec.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FileJSON {
	
	private String fileName;
	private ArrayList<Pagamento> pagamentos;
	
	public FileJSON(String fileName) {
		this.fileName = fileName;
		this.pagamentos = new ArrayList<Pagamento>();
	}
	
	public ArrayList<Pagamento> leitura() {
		File file = new File(fileName);
		JSONParser parser = new JSONParser();
		
		 try {
			 JSONArray jArray = (JSONArray) parser.parse(new InputStreamReader(new FileInputStream(file), "UTF-8"));
				for(int i=0; i < jArray.size(); i++) {
					JSONObject jO = (JSONObject) jArray.get(i);
					Pagamento pag;
					String nome = (String) jO.get("nome");
					String cpf = (String) jO.get("CPF");
					Pagador pagador = new Pagador(nome,cpf);
					String bancoRecebimento = (String) jO.get("bancoRecebimento");
					String bancoPagamento = (String) jO.get("bancoPagamento");
					String dataHora = (String) jO.get("data");
					double valor = (double) jO.get("valor");
					if(jO.containsKey("numeroCartao")) {
						String numeroCartao = (String) jO.get("numeroCartao");
						String nomeTitular = (String) jO.get("nomeTitular");
						Cartao cartao = new Cartao(numeroCartao, nomeTitular);
						int parcelas;
						if(jO.containsKey("parcelas"))
							parcelas = (int)(long) jO.get("parcelas");
						else {
							parcelas = 0;
						}
						pag = new PagamentoCartao(bancoRecebimento, bancoPagamento, pagador, dataHora, valor, cartao, parcelas);
					}
					else {
						String numeroBoleto = (String) jO.get("numeroBoleto");
						pag = new PagamentoBoleto(bancoRecebimento, bancoPagamento, pagador, dataHora, valor, numeroBoleto);
					}
					pagamentos.add(pag);
				}
		 }
		catch (FileNotFoundException e) {
	            e.printStackTrace();
		}
        catch (IOException e) {
            e.printStackTrace();
        } 
		catch (ParseException e) {
            e.printStackTrace();
        }	   
		 return pagamentos;
	}
		

}
