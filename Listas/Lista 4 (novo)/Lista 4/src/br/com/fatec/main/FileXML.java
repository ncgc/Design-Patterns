package br.com.fatec.main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import br.com.fatec.pagamento.Pagamento;

public class FileXML extends RecuperaPagamentos {
	private String fileName;
	private Document doc;
	
	public FileXML(String fileName) {
		this.fileName = fileName;		
	}
	
	public void lerArquivo() throws IOException  {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			File file = new File(fileName);
			doc = builder.parse(file);
			doc.getDocumentElement().normalize();
		}
		catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			throw new IOException("Arquivo não encontrado");
		} 
	}


	
	public String getFileName() {
		return fileName;
	}

	public Document getDoc() {
		return doc;
	}

	@Override
	public ArrayList<Pagamento> recuperarPagamento() {
		ArrayList<Pagamento> pagamentos = new ArrayList<Pagamento>();
		NodeList list = doc.getElementsByTagName("list");
		
		Pagamento pag;
		for(int i = 0; i < list.item(0).getChildNodes().getLength(); i++){
			Element eElement = doc.getDocumentElement();
			XMLtoPagamento xp = new XMLtoPagamento(eElement);
			if(eElement.getElementsByTagName("nomeTitular").item(i).getTextContent() != null) {
				pag = xp.converteCartao(i);
			}
			else {
				pag = xp.converteBoleto(i);
			}
			pagamentos.add(pag);
		}
		return pagamentos;
	}
		
	
		
}
