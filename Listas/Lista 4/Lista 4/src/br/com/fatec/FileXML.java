package br.com.fatec;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.*;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class FileXML {
	private String fileName;
	private ArrayList<Pagamento> pagamentos;

	public FileXML(String fileName) {
		this.fileName = fileName;
		this.pagamentos = new ArrayList<Pagamento>();	
	}

	public ArrayList<Pagamento> leitura() {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			File file = new File(fileName);
			Document document = builder.parse(file);

			NodeList list = document.getElementsByTagName("list");
			Element root = document.getDocumentElement();

			for(int i = 0; i < list.item(0).getChildNodes().getLength(); i++){
				Element eElement = document.getDocumentElement();
				Pagamento pag;
				String nome = eElement.getElementsByTagName("nome").item(i).getTextContent();
				String cpf = eElement.getElementsByTagName("CPF").item(i).getTextContent();
				Pagador pagador = new Pagador(nome, cpf);
				String bancoRecebimento = eElement.getElementsByTagName("bancoRecebimento").item(i).getTextContent();
				String bancoPagamento = eElement.getElementsByTagName("bancoPagamento").item(i).getTextContent();
				String dataHora = eElement.getElementsByTagName("data").item(i).getTextContent();
				double valor = Double.parseDouble(eElement.getElementsByTagName("valor").item(i).getTextContent());
				if(eElement.getElementsByTagName("numeroCartao").item(i) != null) {
					String numeroCartao = eElement.getElementsByTagName("numeroCartao").item(i).getTextContent();
					String nomeTitular = eElement.getElementsByTagName("nomeTitular").item(i).getTextContent();
					int parcelas;
					if(eElement.getElementsByTagName("parcelas").item(i) != null) {
						parcelas =  Integer.valueOf(eElement.getElementsByTagName("parcelas").item(i).getTextContent());
					}
					else {
						parcelas = 0;
					}
					pag = new PagamentoCartao(bancoRecebimento, bancoPagamento, pagador, dataHora, valor, numeroCartao, nomeTitular, parcelas);
				}
				else {
					String numeroBoleto = eElement.getElementsByTagName("numeroBoleto").item(i).getTextContent();
					pag = new PagamentoBoleto(bancoRecebimento, bancoPagamento, pagador, dataHora, valor, numeroBoleto);
				}
				pagamentos.add(pag);

			}

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return pagamentos;
	}




}
