package br.com.everton.bolsa.reader;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.everton.bolsa.modelo.Negociacao;

public class LeitorXMLTest {

	@Test
		public void carregaXmlComUmaNegociacaoEmListaUnitaria() {

     /*Nesse caso estou simulando um arquivo xml, mas na verdade estou passando uma string e convertendo-a
	 para bytes e então passando para a função carrega que irá converter esse xml em uma lista de objetos de 
	 do tipo Negociacao
	*/
		String xmlDeTeste = "<list>" +
		          "  <negociacao>" +
		          "    <preco>43.5</preco>" +
		          "    <quantidade>1000</quantidade>" +
		          "    <data>" +
		          "      <time>1322233344455</time>" +
		          "    </data>" +
		          "  </negociacao>" +
		          "</list>";
		  
		  LeitorXML leitor = new LeitorXML();

		  InputStream xml = new ByteArrayInputStream(xmlDeTeste.getBytes());

		  List<Negociacao> negociacoes = leitor.carrega(xml);
	   
		  assertEquals(1, negociacoes.size());
		  assertEquals(43.5, negociacoes.get(0).getPreco(), 0.000000001);
		  assertEquals(1000, negociacoes.get(0).getQuantidade());
	}
	
	// Testando com um xml com uma lista vazia
	@Test(expected=NullPointerException.class)
	public void carregaXmlComUmaNegociacaoEmListaVazia() {
    
	String xmlDeTeste = "<list>" +
	          "</list>";
	  
	  LeitorXML leitor = new LeitorXML();

	  InputStream xml = new ByteArrayInputStream(xmlDeTeste.getBytes());

	  List<Negociacao> negociacoes = leitor.carrega(xml);
      
	 if(negociacoes.isEmpty()){
		 
		 throw new NullPointerException("A lista não está vazia");
	 }
	
}

	// Testando com um xml com uma lista com várias negociacoes
	@Test
	public void carregaXmlComUmaNegociacaoEmListaVarias() {

	String xmlDeTeste = "<list>" +
	          "  <negociacao>" +
	          "    <preco>43.5</preco>" +
	          "    <quantidade>1000</quantidade>" +
	          "    <data>" +
	          "      <time>1322233344455</time>" +
	          "    </data>" +
	          "  </negociacao>" +
	          
	          "  <negociacao>" +
	          "    <preco>43.5</preco>" +
	          "    <quantidade>1000</quantidade>" +
	          "    <data>" +
	          "      <time>1322233344455</time>" +
	          "    </data>" +
	          "  </negociacao>" +
	           
				"  <negociacao>" + "    <preco>43.5</preco>" + "    <quantidade>1000</quantidade>" + "    <data>"
				+ "      <time>1322233344455</time>" + "    </data>" + "  </negociacao>" +
	          
				"  <negociacao>" + "    <preco>43.5</preco>" + "    <quantidade>1000</quantidade>" + "    <data>"
				+ "      <time>1322233344455</time>" + "    </data>" + "  </negociacao>" +
	          
	          "</list>";
	  LeitorXML leitor = new LeitorXML();

	  InputStream xml = new ByteArrayInputStream(xmlDeTeste.getBytes());

	  List<Negociacao> negociacoes = leitor.carrega(xml);
   
	  assertEquals(4, negociacoes.size());
	  assertEquals(43.5, negociacoes.get(0).getPreco(), 0.000000001);
	  assertEquals(1000, negociacoes.get(0).getQuantidade());
}

	
	
	
}
