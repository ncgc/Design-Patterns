package br.com.fatec.main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
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
		try {
			File file = new File(fileName);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();			
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			this.doc = dBuilder.parse(file);
			
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
		String[] tags = {"br.com.pageseguro.RemessaBoleto", "br.com.pageseguro.RemessaCartaoCredito", "br.com.pageseguro.RemessaCartaoCredito"};
		
		for(String tag: tags) {
			Pagamento pag;
			NodeList boleto = doc.getElementsByTagName(tag);
			for (int i = 0; i < boleto.getLength(); i++) {
		        Node childNode = boleto.item(i);
		        Element eElement = (Element) childNode;
		        XMLtoPagamento xp = new XMLtoPagamento(eElement);
		        if(tag.contains("Boleto")) pag = xp.converteBoleto(0);
		        else pag = xp.converteCartao(0);
		        pagamentos.add(pag);
		        System.out.println(i);
			}
		}
		return pagamentos;
	}

	
	
	
	
	
	
		
}
