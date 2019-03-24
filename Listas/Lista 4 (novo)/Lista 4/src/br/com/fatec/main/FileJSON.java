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

import br.com.fatec.pagamento.Pagamento;


public class FileJSON extends RecuperaPagamentos{
	private String fileName;
	private JSONArray leitura;

	public FileJSON(String fileName) {
		this.fileName = fileName;
	}
	
	public void lerArquivo() throws FileNotFoundException {
		File file = new File(fileName);
		JSONParser parser = new JSONParser();
		 try {
			 leitura = (JSONArray) parser.parse(new InputStreamReader(new FileInputStream(file), "UTF-8"));
		 }
		 catch (FileNotFoundException e) {
			 e.printStackTrace();
			 throw new FileNotFoundException("Arquivo não encontrado");
		}
		 catch (IOException e) {
			 e.printStackTrace();
		 } 
		catch (ParseException e) {
			e.printStackTrace();
		}	
	}

	public JSONArray getLeitura() {
		return leitura;
	}

	@Override
	public ArrayList<Pagamento> recuperarPagamento() {
		ArrayList<Pagamento> pagamentos = new ArrayList<Pagamento>();
		Pagamento pag;
		for(int i=0; i < leitura.size(); i++) {
			JSONObject jO = (JSONObject) leitura.get(i);
			JSONtoPagamento jp = new JSONtoPagamento(jO);
			if(jO.containsKey("numeroCartao")) pag = jp.converteCartao();
			else pag = jp.converteBoleto(); 
			pagamentos.add(pag);
		}	
		return pagamentos;
	}	
	
}
